package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Pickaxe extends Entity{

	public static final String objName = "Pickaxe";
	
	GamePanel gp;
	
	public OBJ_Pickaxe(GamePanel gp) {
		super(gp);
		
		type = type_pickaxe;
		name  = objName;
		eWidth = gp.tileSize;
		eHeight = gp.tileSize;
		down1 = setup("/objects/pickaxe", gp.tileSize, gp.tileSize);
		description = "[Pickaxe]\nYou will dig it!";
		attackvalue = 2;
		attackArea.width = 30;
		attackArea.height = 30;
		
		price = 15;
		knockBackPower = 10;
		motion1_duration = 10;
		motion2_duration = 20;
	}
}
