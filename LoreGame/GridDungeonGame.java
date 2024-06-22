import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.sound.midi.*;


//New Comment
public class GridDungeonGame extends JFrame implements Runnable {
    
    public DrawGraphics drawGraphics;
   
    


    

	// private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	// private Thread thread;
	
	// private BufferStrategy bs;
	private Graphics g;
	
	//States
	// public State gameState;
	// public State menuState;
	
	//Input
	// private KeyManager keyManager;
	// private MouseManager mouseManager;
	
	// //Camera
	// private GameCamera gameCamera;
	
	// //Handler
	// private Handler handler;
	
	// public Game(String title, int width, int height){
	// 	this.width = width;
	// 	this.height = height;
	// 	this.title = title;
	// 	keyManager = new KeyManager();
	// 	mouseManager = new MouseManager();
	// }
	
	private void init(){
		// display = new Display(title, width, height);
		// display.getFrame().addKeyListener(keyManager);
		// display.getFrame().addMouseListener(mouseManager);
		// display.getFrame().addMouseMotionListener(mouseManager);
		// display.getCanvas().addMouseListener(mouseManager);
		// display.getCanvas().addMouseMotionListener(mouseManager);
		// Assets.init();
		
		// handler = new Handler(this);
		// gameCamera = new GameCamera(handler, 0, 0);
		
		// gameState = new GameState(handler);
		// menuState = new MenuState(handler);
		// State.setState(menuState);
	}
	
	private void tick(){
		// keyManager.tick();
		//drawGraphics.movePlayer(0,0);
		// if(State.getState() != null)
		// 	State.getState().tick();
	}
	
	private void render(){

        //drawGraphics.movePlayer(0,0);
        //drawGraphics.gamePanel.repaint();

		// bs = display.getCanvas().getBufferStrategy();
		// if(bs == null){
		// 	display.getCanvas().createBufferStrategy(3);
		// 	return;
		// }
		// g = bs.getDrawGraphics();
		//Clear Screen
		//g.clearRect(0, 0, width, height);
		//Draw Here!
		
		// if(State.getState() != null)
		// 	State.getState().render(g);
		
		// //End Drawing!
		// bs.show();
		//g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 120;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			

			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		//stop();
		
	}
	
	// public KeyManager getKeyManager(){
	// 	return keyManager;
	// }
	
	// public MouseManager getMouseManager(){
	// 	return mouseManager;
	// }
	
	// public GameCamera getGameCamera(){
	// 	return gameCamera;
	// }
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		// thread = new Thread(this);
		// thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		// try {
		// 	// thread.join();
		// } catch (InterruptedException e) {
		// 	//e.printStackTrace();
		}



    
    public GridDungeonGame() {
        
       //drawGraphics = new DrawGraphics();
       
       //Thread thread = new Thread(drawGraphics);
       //thread.start();

	
    }
    public static void main(String[] args) {
        
        
        //MidiPlayer player = new MidiPlayer("opera.mid");
        //Thread thread = new Thread(player);
        //thread.start();
//ButtonPanel buttons = new ButtonPanel();



       DrawGraphics drawGraphics = new DrawGraphics();
       
//drawGraphics.add(buttons);

       Thread thread2 = new Thread(drawGraphics);
        thread2.start();
		//drawGraphics.add(buttons);





        SwingUtilities.invokeLater(GridDungeonGame::new);

        
    
    }
    
}