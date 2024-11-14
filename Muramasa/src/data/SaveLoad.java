package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.GamePanel;

public class SaveLoad {
    GamePanel gp;
    DatabaseConnection dbManager;

    public SaveLoad(GamePanel gp) {
        this.gp = gp;
        this.dbManager = new DatabaseConnection();
    }

    public void save() {
        try (Connection conn = dbManager.getConnection()) {
            // Lưu thông tin người chơi
            String playerSql = "INSERT INTO player (level, max_life, life, max_mana, mana, strength, exp, next_level_exp, coin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement playerStmt = conn.prepareStatement(playerSql);
            playerStmt.setInt(1, gp.player.level);
            playerStmt.setInt(2, gp.player.maxLife);
            playerStmt.setInt(3, gp.player.life);
            playerStmt.setInt(4, gp.player.maxMana);
            playerStmt.setInt(5, gp.player.mana);
            playerStmt.setInt(6, gp.player.strength);
            playerStmt.setInt(7, gp.player.exp);
            playerStmt.setInt(8, gp.player.nextLevelExp);
            playerStmt.setInt(9, gp.player.coin);
            playerStmt.executeUpdate();

            // Lưu thông tin đồ vật
            String inventorySql = "INSERT INTO inventory (player_id, item_name, item_amount) VALUES ((SELECT id FROM player ORDER BY id DESC LIMIT 1), ?, ?)";
            PreparedStatement inventoryStmt = conn.prepareStatement(inventorySql);
            for (int i = 0; i < gp.player.inventory.size(); i++) {
                inventoryStmt.setString(1, gp.player.inventory.get(i).name);
                inventoryStmt.setInt(2, gp.player.inventory.get(i).amount);
                inventoryStmt.executeUpdate();
            }

            // Lưu thông tin đối tượng bản đồ
            String mapObjectSql = "INSERT INTO map_objects (map_id, object_name, world_x, world_y, loot_name, opened, player_id) VALUES (?, ?, ?, ?, ?, ?, (SELECT id FROM player ORDER BY id DESC LIMIT 1))";
            PreparedStatement mapStmt = conn.prepareStatement(mapObjectSql);
            for (int mapNum = 0; mapNum < gp.maxMap; mapNum++) {
                for (int i = 0; i < gp.obj[gp.currentMap].length; i++) {
                    if (gp.obj[mapNum][i] != null) {
                        mapStmt.setInt(1, mapNum);
                        mapStmt.setString(2, gp.obj[mapNum][i].name);
                        mapStmt.setInt(3, gp.obj[mapNum][i].worldX);
                        mapStmt.setInt(4, gp.obj[mapNum][i].worldY);
                        mapStmt.setString(5, gp.obj[mapNum][i].loot != null ? gp.obj[mapNum][i].loot.name : null);
                        mapStmt.setBoolean(6, gp.obj[mapNum][i].opened);
                        mapStmt.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try (Connection conn = dbManager.getConnection()) {
            // Đọc thông tin người chơi
            String playerSql = "SELECT * FROM player ORDER BY id DESC LIMIT 1";
            PreparedStatement playerStmt = conn.prepareStatement(playerSql);
            ResultSet playerRs = playerStmt.executeQuery();
            if (playerRs.next()) {
                gp.player.level = playerRs.getInt("level");
                gp.player.maxLife = playerRs.getInt("max_life");
                gp.player.life = playerRs.getInt("life");
                gp.player.maxMana = playerRs.getInt("max_mana");
                gp.player.mana = playerRs.getInt("mana");
                gp.player.strength = playerRs.getInt("strength");
                gp.player.exp = playerRs.getInt("exp");
                gp.player.nextLevelExp = playerRs.getInt("next_level_exp");
                gp.player.coin = playerRs.getInt("coin");
            }

            // Đọc thông tin đồ vật
            String inventorySql = "SELECT * FROM inventory WHERE player_id = (SELECT id FROM player ORDER BY id DESC LIMIT 1)";
            PreparedStatement inventoryStmt = conn.prepareStatement(inventorySql);
            ResultSet inventoryRs = inventoryStmt.executeQuery();
            gp.player.inventory.clear();
            while (inventoryRs.next()) {
                gp.player.inventory.add(gp.eGenerator.getObject(inventoryRs.getString("item_name")));
                gp.player.inventory.get(gp.player.inventory.size() - 1).amount = inventoryRs.getInt("item_amount");
            }

            // Đọc thông tin đối tượng bản đồ
            String mapObjectSql = "SELECT * FROM map_objects WHERE player_id = (SELECT id FROM player ORDER BY id DESC LIMIT 1)";
            PreparedStatement mapStmt = conn.prepareStatement(mapObjectSql);
            ResultSet mapRs = mapStmt.executeQuery();
            while (mapRs.next()) {
                int mapNum = mapRs.getInt("map_id");
                int index = mapRs.getInt("object_id");
                if (!mapRs.getString("name").equals("NA")) {
                    gp.obj[mapNum][index] = gp.eGenerator.getObject(mapRs.getString("name"));
                    gp.obj[mapNum][index].worldX = mapRs.getInt("world_x");
                    gp.obj[mapNum][index].worldY = mapRs.getInt("world_y");
                    gp.obj[mapNum][index].opened = mapRs.getBoolean("opened");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void reset() {
 
        try (Connection conn = dbManager.getConnection()) {
        		String deleteInventorySQL = "DELETE FROM inventory";
                try (PreparedStatement ps1 = conn.prepareStatement(deleteInventorySQL)) {
                    ps1.executeUpdate();
                }

                // Xóa các bản ghi trong bảng map_objects
                String deleteMapObjectsSQL = "DELETE FROM map_objects";
                try (PreparedStatement ps2 = conn.prepareStatement(deleteMapObjectsSQL)) {
                    ps2.executeUpdate();
                }

                // Xóa các bản ghi trong bảng player (bảng cha)
                String deletePlayerSQL = "DELETE FROM player";
                try (PreparedStatement ps3 = conn.prepareStatement(deletePlayerSQL)) {
                    ps3.executeUpdate();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
