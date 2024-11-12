package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Bridge_Horizontal extends Entity{

	public static final String objName = "bridge horizontal";
	
	GamePanel gp;
	
	public OBJ_Bridge_Horizontal(GamePanel gp) {
		super(gp);
		this.gp = gp;

		eWidth = gp.tileSize*6;
		eHeight = gp.tileSize*3;
		type = type_obstacle;
		name = objName;
		image = setup("/objects/bridge_horizontal", eWidth, eHeight);
		down1 = image;
		collision = false;
		
	}

}
