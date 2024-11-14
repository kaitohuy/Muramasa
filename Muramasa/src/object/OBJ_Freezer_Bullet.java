package object;

import java.awt.Color;
import entity.Projectile;
import main.GamePanel;

public class OBJ_Freezer_Bullet extends Projectile{

	public static final String objName = "freezer bullet";
	
	GamePanel gp;
	
	public OBJ_Freezer_Bullet(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		this.gp = gp;
		
		eWidth = gp.tileSize;
		eHeight = gp.tileSize;
		name = objName;
		speed = 5;
		maxLife = 160;
		life = maxLife;
		attack = 2;
		useCost = 1;
		alive = false;
		getImage();
	}
	
	public void getImage() {
		up1 = setup("/projectile/freezer_bullet_up", eWidth, eHeight);
		up2 = setup("/projectile/freezer_bullet_up", eWidth, eHeight);
		down1 = setup("/projectile/freezer_bullet_down", eWidth, eHeight);
		down2 = setup("/projectile/freezer_bullet_down", eWidth, eHeight);
		left1 = setup("/projectile/freezer_bullet_left", eWidth, eHeight);
		left2 = setup("/projectile/freezer_bullet_left", eWidth, eHeight);
		right1 = setup("/projectile/freezer_bullet_right", eWidth, eHeight);
		right2 = setup("/projectile/freezer_bullet_right", eWidth, eHeight);
	}

	public Color getParticleColor() {
		Color color = new Color(110, 228, 255, 255);
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
