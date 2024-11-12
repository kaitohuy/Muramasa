package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin;
import object.OBJ_Diamond;
import object.OBJ_Posion_Blue;
import object.OBJ_Posion_Red;

public class MON_Eye extends Entity{

	GamePanel gp;
	
	public MON_Eye(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_crep;
		name = "demon";
		eWidth = (int)(gp.tileSize*1.5);
		eHeight = (int)(gp.tileSize*1.5);
		defaultSpeed = 2;
		speed = defaultSpeed;
		maxLife = 50;
		life = maxLife;
		attack = 10;
		defense = 5;
		exp = 20;
		knockBackPower = 5;
		numOfDirecion = 2;
		
		setDefaultSolidArea(18, 12, 32, 32, 64, 64);
		getImage();
	}
	
public void getImage() {
		
		up1 = setup("/monster/eye_up_1", eWidth, eHeight);
		up2 = setup("/monster/eye_up_2", eWidth, eHeight);
		down1 = setup("/monster/eye_down_1", eWidth, eHeight);
		down2 = setup("/monster/eye_down_2", eWidth, eHeight);
		left1 = setup("/monster/eye_left_1", eWidth, eHeight);
		left2 = setup("/monster/eye_left_2", eWidth, eHeight);
		right1 = setup("/monster/eye_right_1", eWidth, eHeight);
		right2 = setup("/monster/eye_right_2", eWidth, eHeight);
		
	}
	
	public void setAction() {
		
		if(onPath == true) {
			
			//check if it stops chasing
			checkStopChasingOrNot(gp.player, 15, 100);	
			
			//search the direction to go
			searchPath(getGoalCol(gp.player), getGoalRow(gp.player));

		}
		else {
			//check if it start chasing
			checkStartChasingOrNot(gp.player, 5, 100);

			//get random direction
			getRandomDirection(120);
		}
	}
	
	public void damageReaction() {
		
		actionLockCounter = 0;
//		direction = gp.player.direction;
//		onPath = true;
	}

	public void checkDrop() {
		int i = new Random().nextInt(100);
		
		//set the monster drop
		if(i < 20) {
			dropItem(new OBJ_Coin(gp));
		}
		if(i >= 20 && i < 60) {
			dropItem(new OBJ_Posion_Red(gp));
		}
		if(i >= 60 && i < 100) {
			dropItem(new OBJ_Posion_Blue(gp));
		}
	}
}
