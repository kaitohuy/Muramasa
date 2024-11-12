package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Arm_Right extends Entity{

	public static final String objName = "arm right";
	
	GamePanel gp;
	
	public OBJ_Arm_Right(GamePanel gp) {
		super(gp);
		this.gp = gp;

		eWidth = gp.tileSize*2;
		eHeight = gp.tileSize*2;
		type = type_obstacle;
		name = objName;
		image = setup("/objects/arm_right", eWidth, eHeight);
		down1 = image;
		collision = false;
		
		setDefaultSolidArea(16, 16, gp.tileSize, gp.tileSize, 0, 0);
		
	}

}
