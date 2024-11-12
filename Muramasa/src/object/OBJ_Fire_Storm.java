package object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

public class OBJ_Fire_Storm extends Projectile{

	public static final String objName = "shuriken";
	
	GamePanel gp;
	
	public OBJ_Fire_Storm(GamePanel gp) {
		super(gp);
		this.gp = gp;
		name = objName;
		speed = 4;
		maxLife = 240;
		life = maxLife;
		attack = 10;
		useCost = 1;
		knockBackPower = 5;
		alive = false;
		maxFrameAttack = 4;
		attacking = true;
		getAttackImage();
		setDefaultSolidArea(24, 24, 48, 48, 0, 0);
	}

	private void getAttackImage() {
		
	    for (int i = 0; i < maxFrameAttack; i++) {
	    	String tempPath = "/objects/fire_storm_" + i;
	    	attackRight[i] = setup(tempPath, gp.tileSize*2, gp.tileSize*2);
	    	attackLeft[i] = attackRight[i];
	    	attackUp[i] = attackRight[i];
	    	attackDown[i] = attackRight[i];
	    }
	}
	
	public Color getParticleColor() {
		Color color = new Color(240,50,0);
		return color;
	}
	
	public int getPariticleSize() {
		
		int size = 8;//pixel
		return size;
	}
	
	public int getParticleSpeed() {
		int speed = 1;
		return speed;
	}
	
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}

}
