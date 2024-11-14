package main;

import entity.Entity;
import object.OBJ_Armor_Lv0;
import object.OBJ_Armor_Lv1;
import object.OBJ_Armor_Lv2;
import object.OBJ_Armor_Lv3;
import object.OBJ_Bone;
import object.OBJ_Chest;
import object.OBJ_Coin;
import object.OBJ_Meteors;
import object.OBJ_Key;
import object.OBJ_Lantern;
import object.OBJ_Posion_Blue;
import object.OBJ_Posion_Red;
import object.OBJ_Skull;
import object.OBJ_Grass_Bullet;
import object.OBJ_Stone;
import object.OBJ_Summon_Book;
import object.OBJ_Sword_Lv0;
import object.OBJ_Sword_Lv1;
import object.OBJ_Sword_Lv2;
import object.OBJ_Sword_Lv3;
import object.OBJ_Tent;

public class EntityGenerator {

	GamePanel gp;
	
	public EntityGenerator(GamePanel gp) {
		this.gp = gp;
	}
	
	public Entity getObject(String itemName) {
		
		Entity obj = null;

		switch(itemName) {
		case OBJ_Armor_Lv0.objName: obj = new OBJ_Armor_Lv0(gp); break;
		case OBJ_Armor_Lv1.objName: obj = new OBJ_Armor_Lv1(gp); break;
		case OBJ_Armor_Lv2.objName: obj = new OBJ_Armor_Lv2(gp); break;
		case OBJ_Armor_Lv3.objName: obj = new OBJ_Armor_Lv3(gp); break;
		case OBJ_Bone.objName: obj = new OBJ_Bone (gp); break;
		case OBJ_Chest.objName: obj = new OBJ_Chest(gp); break;
		case OBJ_Coin.objName: obj = new OBJ_Coin(gp); break;
		case OBJ_Meteors.objName: obj = new OBJ_Meteors(gp); break;
		case OBJ_Key.objName: obj = new OBJ_Key(gp); break;
		case OBJ_Lantern.objName: obj = new OBJ_Lantern(gp); break;
		case OBJ_Posion_Blue.objName: obj = new OBJ_Posion_Blue(gp); break;
		case OBJ_Posion_Red.objName: obj = new OBJ_Posion_Red(gp); break;
		case OBJ_Grass_Bullet.objName: obj = new OBJ_Grass_Bullet(gp); break;
		case OBJ_Skull.objName: obj = new OBJ_Skull(gp); break;
		case OBJ_Summon_Book.objName: obj = new OBJ_Summon_Book(gp); break;
		case OBJ_Stone.objName: obj = new OBJ_Stone(gp); break;
		case OBJ_Sword_Lv0.objName: obj = new OBJ_Sword_Lv0(gp); break;
		case OBJ_Sword_Lv1.objName: obj = new OBJ_Sword_Lv1(gp); break;
		case OBJ_Sword_Lv2.objName: obj = new OBJ_Sword_Lv2(gp); break;
		case OBJ_Sword_Lv3.objName: obj = new OBJ_Sword_Lv3(gp); break;
		case OBJ_Tent.objName: obj = new OBJ_Tent(gp); break;
		}
		return obj;
	}
}
