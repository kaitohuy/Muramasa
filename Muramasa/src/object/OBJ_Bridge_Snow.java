package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Bridge_Snow extends Entity{

	public static final String objName = "bridge snow";
	
	GamePanel gp;
	
	public OBJ_Bridge_Snow(GamePanel gp) {
		super(gp);
		this.gp = gp;

		eWidth = gp.tileSize*6;
		eHeight = gp.tileSize*2;
		type = type_obstacle;
		name = objName;
		image = setup("/objects/brigde_snow", eWidth, eHeight);
		down1 = image;
		collision = false;
		
	}

}
