package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {

	GamePanel gp;
	
	public Config(GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void saveConfig() {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"));
		
			//full screen
			if(gp.fullScreenOn == true) {
				bw.write("On");
			}
			if(gp.fullScreenOn == false) {
				bw.write("Off");
			}
			bw.newLine();
			
			//music volume
			bw.write(String.valueOf(gp.music.VolumeScale));
			bw.newLine();
			
			//se volume
			bw.write(String.valueOf(gp.se.VolumeScale));
			bw.newLine();
			
			bw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadConfig() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("config.txt"));
			
			String s = br.readLine();
			
			//fullscreen
			if(s.equals("On")) {
				gp.fullScreenOn = true;
			}
			if(s.equals("Off")) {
				gp.fullScreenOn = false;
			}
			
			//music volume
			s = br.readLine();
			gp.music.VolumeScale = Integer.parseInt(s);
			
			//se volume
			s = br.readLine();
			gp.se.VolumeScale = Integer.parseInt(s);
			
			
			br.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
