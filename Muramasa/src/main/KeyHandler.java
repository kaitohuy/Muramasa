package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, useManaKeyPressed, useLifeKeyPressed, guardPressed, shotKeyPressed, utilKeyPressed, summonKeyPressed, tradeKeyPressed;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		//title state
		if(gp.gameState == gp.titleState) {
			titleState(code);
		}
		
		//play state
		else if(gp.gameState == gp.playState) {
			playState(code);
		}
		//pause state
		else if(gp.gameState == gp.pauseState) {
			pauseState(code);
		}
		
		//dialogue state
		else if(gp.gameState == gp.dialogueState || gp.gameState == gp.cutSceneState) {
			dialogueState(code);
		}
		//character State
		else if(gp.gameState == gp.characterState) {
			characterState(code);
		}
		//option State
		else if(gp.gameState == gp.optionState) {
			optionState(code);
		}
		//game over state 
		else if(gp.gameState == gp.gameOverState) {
			gameOverState(code);
		}
		//trade state 
		else if(gp.gameState == gp.tradeState) {
			tradeState(code);
		}
		//map state 
		else if(gp.gameState == gp.mapState) {
			mapState(code);
		}
	}

	public void titleState(int code) {
		
		if(gp.ui.titleScreenState == 0) {
			if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
				gp.ui.commandNum--;
				gp.playSe(9);
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			
			if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
				gp.ui.commandNum++;
				gp.playSe(9);
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			
			if (code == KeyEvent.VK_ENTER) {
				gp.playSe(9);
				
				if(gp.ui.commandNum == 0) {
//					gp.saveLoad.reset();
					gp.ui.titleScreenState = 1;
				}
				
				if(gp.ui.commandNum == 1) {
//					gp.saveLoad.load();
					gp.gameState = gp.playState;
					gp.playMusic(23);
				}
				
				if(gp.ui.commandNum == 2) {
					System.exit(0);
				}
			}
		}
		else if(gp.ui.titleScreenState == 1) {
			
			if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
				gp.ui.commandNum--;
				gp.playSe(9);
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 4;
				}
			}
			
			if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
				gp.ui.commandNum++;
				gp.playSe(9);
				if(gp.ui.commandNum > 4) {
					gp.ui.commandNum = 0;
				}
			}
			
			if (code == KeyEvent.VK_ENTER) {
				gp.playSe(9);
				if(gp.ui.commandNum == 0) {
					gp.stopMusic();
					gp.gameState = gp.playState;
					gp.level = "easy";
					gp.playMusic(23);
					gp.ui.commandNum = 0;
				}
				
				if(gp.ui.commandNum == 1) {
					//later
					gp.stopMusic();
					gp.playMusic(23);
					gp.gameState = gp.playState;
					gp.level = "medium";
					gp.ui.commandNum = 0;
				}
				
				if(gp.ui.commandNum == 2) {
					//later
					gp.stopMusic();
					gp.playMusic(23);
					gp.gameState = gp.playState;
					gp.level = "hard";
					gp.ui.commandNum = 0;
				}
				
				if(gp.ui.commandNum == 3) {
					//later
					gp.stopMusic();
					gp.playMusic(23);
					gp.gameState = gp.playState;
					gp.level = "asian";
					gp.ui.commandNum = 0;
				}
				
				if(gp.ui.commandNum == 4) {
					gp.ui.titleScreenState = 0;
					gp.ui.commandNum = 0;
				}
			}
		}
	}
	
	public void playState(int code) {
		
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			upPressed = true;
		}
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			downPressed = true;	
		}
		if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		if (gp.player.canAttack == true && gp.player.attacking == false) {
			if(code == KeyEvent.VK_J || code == KeyEvent.VK_NUMPAD1) { 
				gp.playSe(7);
				gp.player.attacking = true;
				gp.player.canAttack = false;
				gp.player.cooldownCounter = 0;
			}
		}
		if (code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
		if (code == KeyEvent.VK_F) {
			guardPressed = true;
		}
		if (code == KeyEvent.VK_E) {
			useManaKeyPressed = true;
		}
		if (code == KeyEvent.VK_R) {
			useLifeKeyPressed = true;
		}
		if (code == KeyEvent.VK_U || code == KeyEvent.VK_NUMPAD4) {
			shotKeyPressed = true;
		}
		if (code == KeyEvent.VK_I || code == KeyEvent.VK_NUMPAD5) {
			utilKeyPressed = true;
		}
		if (code == KeyEvent.VK_O || code == KeyEvent.VK_NUMPAD6) {
			summonKeyPressed = true;
		}
		if (code == KeyEvent.VK_C) {
			gp.gameState = gp.characterState;
		}
		if (code == KeyEvent.VK_P) {
			gp.gameState = gp.pauseState;
		}
		if (code == KeyEvent.VK_SPACE) {
			gp.gameState = gp.optionState;
		}
		if (code == KeyEvent.VK_M) {
			gp.gameState = gp.mapState;
		}
		if (code == KeyEvent.VK_X) {
			if(gp.map.miniMapOn == false) {
				gp.map.miniMapOn = true;
			}else {
				gp.map.miniMapOn = false;
			}
		}
	}
	
	public void pauseState(int code) {
		
		if (code == KeyEvent.VK_P || code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE || code == KeyEvent.VK_ESCAPE) {
			gp.gameState = gp.playState;
		}
	}
	
	public void dialogueState(int code) {
		
		if (code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
	}
	
	public void characterState(int code) {
		
		if (code == KeyEvent.VK_C || code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_SPACE) {
			gp.gameState = gp.playState;
		}
		
		playerInventory(code);
		
		if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_J || code == KeyEvent.VK_NUMPAD1) {
			gp.player.selectItem();
			gp.playSe(9);
		}
	}

	private void optionState(int code) {
		// TODO Auto-generated method stub
		if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_ESCAPE) {
			gp.gameState = gp.playState;
			gp.ui.commandNum = 0;
		}
		if(code == KeyEvent.VK_ENTER || code == KeyEvent.VK_J || code == KeyEvent.VK_NUMPAD1) {
			enterPressed = true;
		}
		
		int maxCommandNum = 0;
		switch(gp.ui.subState) {
		case 0: maxCommandNum = 5; break;
		case 2: maxCommandNum = 0; break;
		case 3: maxCommandNum = 1; break;
		}
		
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			gp.playSe(9);
			gp.ui.commandNum--;
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = maxCommandNum;
			}
		}
		
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			gp.playSe(9);
			gp.ui.commandNum++;
			if(gp.ui.commandNum > maxCommandNum) {
				gp.ui.commandNum = 0;
			}
		}
		if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 1 && gp.music.VolumeScale > 0) {
					gp.music.VolumeScale--;
					gp.music.checkVolume();
					gp.playSe(9);
				}
				if(gp.ui.commandNum == 2 && gp.se.VolumeScale > 0) {
					gp.se.VolumeScale--;
					gp.playSe(9);
				}
			}
		}
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 1 && gp.music.VolumeScale < 5) {
					gp.music.VolumeScale++;
					gp.music.checkVolume();
					gp.playSe(9);
				}
				if(gp.ui.commandNum == 2 && gp.se.VolumeScale < 5) {
					gp.se.VolumeScale++;
					gp.playSe(9);
				}
			}
		}
	}
	
	private void gameOverState(int code) {
		// TODO Auto-generated method stub
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			gp.playSe(9);
			gp.ui.commandNum--;
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = 1;
			}
		}
		
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			gp.playSe(9);
			gp.ui.commandNum++;
			if(gp.ui.commandNum > 1) {
				gp.ui.commandNum = 0;
			}
		}
		if(code == KeyEvent.VK_ENTER) {
			if(gp.ui.commandNum == 0) {
				gp.saveLoad.load();
				gp.gameState = gp.playState;
				gp.resetGame();
				gp.playMusic(23);
			}else {
				gp.gameState = gp.titleState;
				gp.ui.titleScreenState = 0;
				gp.ui.commandNum = 0;
			}
		}
	}

	private void tradeState(int code) {
		// TODO Auto-generated method stub
		if(code == KeyEvent.VK_ENTER || code == KeyEvent.VK_J || code == KeyEvent.VK_NUMPAD1) {
			tradeKeyPressed = true;
		}
		
		if(gp.ui.subState == 0) {
			if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
				gp.playSe(9);
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			
			if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
				gp.playSe(9);
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			
		}
		
		if(gp.ui.subState == 0) {
			npcInventory(code);
			if(code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_SPACE) {
				gp.gameState = gp.playState; 
			}
		}
		
		if(gp.ui.subState == 1) {
			npcInventory(code);
			if(code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_SPACE) {
				gp.ui.subState = 0; 
			}
		}
		
		if(gp.ui.subState == 2) {
			playerInventory(code);
			if(code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_SPACE) {
				gp.ui.subState = 0; 
			}
		}
		
	}
	
	public void mapState(int code) {
		if (code == KeyEvent.VK_M || code == KeyEvent.VK_ENTER || code == KeyEvent.VK_ESCAPE) {
			gp.gameState = gp.playState;
		}
	}
	
	public void playerInventory(int code) {
		
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			if(gp.ui.playerSlotRow == 0) {
				gp.ui.playerSlotRow = gp.ui.numberSlotY - 1;
			}else {
				gp.ui.playerSlotRow--;
			}
			gp.playSe(9);
		}
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			if(gp.ui.playerSlotRow == gp.ui.numberSlotY - 1) {
				gp.ui.playerSlotRow = 0;
			}else {
				gp.ui.playerSlotRow++;
			}
			gp.playSe(9);
		}
		if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			if(gp.ui.playerSlotCol == 0) {
				gp.ui.playerSlotCol = gp.ui.numberSlotX - 1;
			}else {
				gp.ui.playerSlotCol--;
			}
			gp.playSe(9);
		}
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			if(gp.ui.playerSlotCol == gp.ui.numberSlotX - 1) {
				gp.ui.playerSlotCol = 0;
			}else {
				gp.ui.playerSlotCol++;
			}
			gp.playSe(9);
		}
	}
	
	public void npcInventory(int code) {
		
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			if(gp.ui.npcSlotRow == 0) {
				gp.ui.npcSlotRow = gp.ui.numberSlotY - 1;
			}else {
				gp.ui.npcSlotRow--;
			}
			gp.playSe(9);
		}
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			if(gp.ui.npcSlotRow == gp.ui.numberSlotY - 1) {
				gp.ui.npcSlotRow = 0;
			}else {
				gp.ui.npcSlotRow++;
			}
			gp.playSe(9);
		}
		if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			if(gp.ui.npcSlotCol == 0) {
				gp.ui.npcSlotCol = gp.ui.numberSlotX - 1;
			}else {
				gp.ui.npcSlotCol--;
			}
			gp.playSe(9);
		}
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			if(gp.ui.npcSlotCol == gp.ui.numberSlotX - 1) {
				gp.ui.npcSlotCol = 0;
			}else {
				gp.ui.npcSlotCol++;
			}
			gp.playSe(9);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			downPressed = false;	
		}
		if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}		
		if (code == KeyEvent.VK_F) {
			guardPressed = false;
		}
		if (code == KeyEvent.VK_E) {
			useManaKeyPressed = false;
		}
		if (code == KeyEvent.VK_R) {
			useLifeKeyPressed = false;
		}
		if (code == KeyEvent.VK_U || code == KeyEvent.VK_NUMPAD4) {
			shotKeyPressed = false;
		}
		if (code == KeyEvent.VK_I || code == KeyEvent.VK_NUMPAD5) {
			utilKeyPressed = false;
		}
		if (code == KeyEvent.VK_ENTER) {
			enterPressed = false;
		}
	}
	
}
