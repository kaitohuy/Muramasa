package main;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	
	public static JFrame window;

	public static void main(String[] args) {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Muramasa");
		new Main().setIcon();
		
		GamePanel gamepanel = new GamePanel();
		window.add(gamepanel);
		
		gamepanel.config.loadConfig();
		if(gamepanel.fullScreenOn == true) {			
			window.setUndecorated(true);
		}
		
		window.pack();
		
		window.setLocationRelativeTo(null); //center
		window.setVisible(true);
		
		gamepanel.setupGame();
		gamepanel.startGameThread();
	}
	
	public void setIcon() {
		
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/player/king_down_1.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.setIconImage(icon.getImage());
	}
}
