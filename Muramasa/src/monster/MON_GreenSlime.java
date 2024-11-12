package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin;
import object.OBJ_Diamond;
import object.OBJ_Posion_Blue;
import object.OBJ_Posion_Red;
import object.OBJ_Grass_Bullet;

public class MON_GreenSlime extends Entity{

	GamePanel gp;
	
	public MON_GreenSlime(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		this.gp = gp;
		
		type = type_crep;
		name = "Green Slime";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 50;
		life = maxLife;
		attack = 15;
		defense = 0;
		exp = 5;
		projectile = new OBJ_Grass_Bullet(gp);

		setDefaultSolidArea(3, 18, 42, 30, 0, 0);
		
		getImage();
	}
	
	public void getImage() {
		
		up1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
		down1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
		
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
