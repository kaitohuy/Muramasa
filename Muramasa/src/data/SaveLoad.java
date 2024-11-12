package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import main.GamePanel;

public class SaveLoad {

	GamePanel gp;
	
	public SaveLoad(GamePanel gp) {
		this.gp = gp;
	}
	
	public void save() {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));			
			
			DataStorage ds = new DataStorage();
			ds.level = gp.player.level;
			ds.maxLife = gp.player.maxLife;
			ds.life = gp.player.life;
			ds.maxMana = gp.player.maxMana;
			ds.mana = gp.player.mana;
			ds.strength = gp.player.strength;
			ds.exp = gp.player.exp;
			ds.nextLevelExp = gp.player.nextLevelExp;
			ds.coin = gp.player.coin;
			
			//player inventory
			for (int i = 0; i < gp.player.inventory.size(); i++) {
				ds.itemNames.add(gp.player.inventory.get(i).name);
				ds.itemAmounts.add(gp.player.inventory.get(i).amount);
			}
			
			ds.currentWeponSlot = gp.player.getCurrentWeaponSlot();
			ds.currentArmorSlot = gp.player.getCurrentArmorSlot();
			
			ds.mapObjectName = new String[gp.maxMap][gp.obj[gp.currentMap].length];
			ds.mapObjectWorldX = new int[gp.maxMap][gp.obj[gp.currentMap].length];
			ds.mapObjectWorldY = new int[gp.maxMap][gp.obj[gp.currentMap].length];
			ds.mapObjectLootName = new String[gp.maxMap][gp.obj[gp.currentMap].length];
			ds.mapObjectOpened = new boolean[gp.maxMap][gp.obj[gp.currentMap].length];
			
			for (int mapNum = 0; mapNum < gp.maxMap; mapNum++) {
				for (int i = 0; i < gp.obj[gp.currentMap].length; i++) {
					if (gp.obj[mapNum][i] == null) {
						ds.mapObjectName[mapNum][i] = "NA";
					} else {
						ds.mapObjectName[mapNum][i] = gp.obj[mapNum][i].name;
						ds.mapObjectWorldX[mapNum][i] = gp.obj[mapNum][i].worldX;
						ds.mapObjectWorldY[mapNum][i] = gp.obj[mapNum][i].worldY;
						if (gp.obj[mapNum][i].loot != null) {
							ds.mapObjectLootName[mapNum][i] = gp.obj[mapNum][i].loot.name;
						}
						ds.mapObjectOpened[mapNum][i] = gp.obj[mapNum][i].opened;
					}
				}
			}
			
			//write the datastorage object
			oos.writeObject(ds);
			
			oos.close();
		}
		catch(Exception e) {
			System.out.println("Save exceptions");
		}
	}
	
	public void load() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
			
			//read the datastorage object
			DataStorage ds = (DataStorage)ois.readObject();
			
			gp.player.level = ds.level;
			gp.player.maxLife = ds.maxLife;
			gp.player.life = ds.life;
			gp.player.maxMana = ds.maxMana;
			gp.player.mana = ds.mana;
			gp.player.strength = ds.strength;
			gp.player.exp = ds.exp;
			gp.player.nextLevelExp = ds.nextLevelExp;
			gp.player.coin = ds.coin;
			
			gp.player.inventory.clear();
			for (int i = 0; i < ds.itemNames.size(); i++) {
				gp.player.inventory.add(gp.eGenerator.getObject(ds.itemNames.get(i)));
				gp.player.inventory.get(i).amount = ds.itemAmounts.get(i);
			}
			
			gp.player.currentWeapon = gp.player.inventory.get(ds.currentWeponSlot);
			gp.player.currentArmor = gp.player.inventory.get(ds.currentArmorSlot);
			gp.player.getAttack();
			gp.player.getDefenseArmor();
			gp.player.getAttackImage();
			
			//objects on map
			for (int mapNum = 0; mapNum < gp.maxMap; mapNum++) {
				for (int i = 0; i < gp.obj[gp.currentMap].length; i++) {
					if (ds.mapObjectName[mapNum][i].equals("NA")) {
						gp.obj[mapNum][i] = null;
					}
					else if(gp.obj[mapNum][i] != null){
						gp.obj[mapNum][i] = gp.eGenerator.getObject(ds.mapObjectName[mapNum][i]);
						gp.obj[mapNum][i].worldX = ds.mapObjectWorldX[mapNum][i];
						gp.obj[mapNum][i].worldY = ds.mapObjectWorldY[mapNum][i];
						if (ds.mapObjectLootName[mapNum][i] != null) {
							gp.obj[mapNum][i].setLoot(gp.eGenerator.getObject(ds.mapObjectLootName[mapNum][i]));
						}
						gp.obj[mapNum][i].opened = ds.mapObjectOpened[mapNum][i];
						if(gp.obj[mapNum][i].opened == true) {
							gp.obj[mapNum][i].down1 = gp.obj[mapNum][i].image2;
						}
					}
				}
			}
			
			ois.close();
		} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Load Exception");;
		}
	}
}
