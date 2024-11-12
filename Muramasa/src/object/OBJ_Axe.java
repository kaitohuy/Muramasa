package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Axe extends Entity{

	public static final String objName = "Woodcutter's Axe";
	
	GamePanel gp;
	
	public OBJ_Axe(GamePanel gp) {
		super(gp);
		
		type = type_axe;
		name  = objName;
		eWidth = gp.tileSize;
		eHeight = gp.tileSize;
		down1 = setup("/objects/axe", eWidth, eHeight);
		description = "[" + name + "]\nA bit rusty but still can\ncut some trees.";
		attackvalue = 2;
		attackArea.width = 36;
		attackArea.height = 36;
		
		price = 15;
		knockBackPower = 5;
		motion1_duration = 20;
		motion2_duration = 40;
	}
}
