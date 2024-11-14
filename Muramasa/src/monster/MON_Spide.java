package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin;
import object.OBJ_Poison_Bullet;
import object.OBJ_Posion_Blue;
import object.OBJ_Posion_Red;

public class MON_Spide extends Entity{

	GamePanel gp;
	
	public MON_Spide(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		this.gp = gp;
		
		type = type_crep;
		name = "spide";
		eWidth = gp.tileSize*2;
		eHeight = gp.tileSize*2;
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 3000;
		life = maxLife;
		attack = 190;
		defense = 25;
		exp = 50000;
		projectile = new OBJ_Poison_Bullet(gp);

		setDefaultSolidArea(18, 16, 48, 48, 64, 64);
		
		getImage();
	}
	
	public void getImage() {
		
		up1 = setup("/monster/spide_up_1", eWidth, eHeight);
		up2 = setup("/monster/spide_up_2", eWidth, eHeight);
		down1 = setup("/monster/spide_down_1", eWidth, eHeight);
		down2 = setup("/monster/spide_down_2", eWidth, eHeight);
		left1 = setup("/monster/spide_left_1", eWidth, eHeight);
		left2 = setup("/monster/spide_left_2", eWidth, eHeight);
		right1 = setup("/monster/spide_right_1", eWidth, eHeight);
		right2 = setup("/monster/spide_right_2", eWidth, eHeight);
		
	}

	public void setAction() {
		
		if(onPath == true) {
			
			//check if it stops chasing
			checkStopChasingOrNot(gp.player, 15, 100);	
			
			//search the direction to go
			searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
			
			//check if it shoots a projectile
			checkShootOtNot(150, 30);
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
		onPath = true;
	}
	
	public void checkDrop() {
		int i = new Random().nextInt(100);
		
		//set the monster drop
		if(i < 80) {
			dropItem(new OBJ_Coin(gp));
		}
		if(i >= 80 && i < 90) {
			dropItem(new OBJ_Posion_Red(gp));
		}
		if(i >= 90 && i < 100) {
			dropItem(new OBJ_Posion_Blue(gp));
		}
	}

}
