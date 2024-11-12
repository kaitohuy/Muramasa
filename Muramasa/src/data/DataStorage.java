package data;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DataStorage implements Serializable{

	//Player status
	int level;
	int maxLife;
	int life;
	int maxMana;
	int mana;
	int strength;
	int dexterity;
	int exp;
	int nextLevelExp;
	int coin;
	
	ArrayList<String> itemNames = new ArrayList<>();
	ArrayList<Integer> itemAmounts = new ArrayList<>();
	int currentWeponSlot;
	int currentArmorSlot;
	
	String mapObjectName[][];
	int mapObjectWorldX[][];
	int mapObjectWorldY[][];
	String mapObjectLootName[][];
	boolean mapObjectOpened[][];
}
