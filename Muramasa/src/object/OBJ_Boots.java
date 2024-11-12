package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Boots extends Entity{

	public static final String objName = "boots";
			
	GamePanel gp;
	
	public OBJ_Boots(GamePanel gp) {
		super(gp);
		
		eWidth = gp.tileSize;
		eHeight = gp.tileSize;
		name  = objName;
		down1 = setup("/objects/boots", eWidth, eHeight);
	}
}
