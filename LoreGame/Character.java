import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Character extends JFrame implements Runnable {

    public int x;
    public int y;

    public Image characterImage;

    public Image characterAnimationFrames[] = new Image[2];

    int xMove = 1;

    // public int drawX = 100; // move X without drawing to screen
    public int drawX = 100;
    public int drawY = 250;
    public int width = 300;
    public int height = 300;
    public int noDrawX = 100;

    int drawFinalX = 550; // final frame of animation

    // Window activeWindow;
    public int health = 10;
    public String name;
    public int attackPower = 9;

    public boolean alive = false;

    // enum Modes {ROAM, ATTACK};

    public short mode;

    public short attack = 5;
    public int mapLocation;
    public boolean movement = false;
    public Random random = new Random();
    public int rand;
    public int newLocation;
    public String exits = "11111111";
    Robot robot;
    public String deadName;

    boolean drawOnce = true;

    // public int characterAnimate = 0;
    // public boolean movementFlag = false;

    public boolean moveEastToWest = false;

    // Animatons
    // Animation animDown = new Animation(500, characterAnimationFrames);
    // Animation animUp = new Animation(500, characterAnimationFrames);
    // Animation animLeft = new Animation(500, characterAnimationFrames);
    Animation animRight = new Animation(500, characterAnimationFrames);
    // Enemy(String namee, int location){

    // this.name = namee;
    // this.mapLocation = location;
    // this.deadName = "Dead " + this.name;
    // this.alive = true;
    // //this.movement = true;
    // //this.health = this.health - attacked;
    // };

    // @Override
    public void tick() {

        // Animations
        // animDown.tick();
        // animUp.tick();
        animRight.tick();

        // animLeft.tick();
        // Movement
        // moveTowards();
        if (x < 2) {
            // movement = true;
            move();
            movement = false;

        }

        // Attack
        // checkAttacks();
        // i++;

        // animRight.getCurrentFrame();
        // //animLeft.tick();
        // //Movement
        // if(x < 500);
        // moveTowards();

        // if(x < 500);
        // moveAround();

        // drawX++;
        // try {
        // Thread.sleep(100);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // //checkAttacks();

        // //i++;

    }

    public void moveTowards() {

    }

    public void run() {

        // public void drawWallsFacingNorth(Graphics g) throws IOException {

        System.out.println("thread is running...");

        // javax.swing.FocusManager.getCurrentManager().getGlobalActiveWindow();

        try {
            robot = new Robot();
            Thread.sleep(500);
            // this.mapLocation += this.newLocation;

            // System.out.println("NEW " + newLocation);

            rand = Math.abs(random.nextInt());

            System.out.println("sdfad!");

            // activeWindow = getSelectedWindow(5);

            while (movement == true) {
                // activeWindow = getActiveWindow();

                System.out.println("JESTER X IS: " + x);

                if (this.health < 1) {
                    alive = false;
                    this.name = this.deadName;
                    this.movement = false;
                }

                // System.out.println("WINDOW" + activeWindow );
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

                System.out.println("JESTER MOVED!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), drawX, drawY, width, height, null);
    }

    public void displayEnemyAttack() {

        if (this.alive == true)
            System.out.println(this.name + " attacks you for " + this.attack + " damage!!");

    }

    private Image getCurrentAnimationFrame() {

        return animRight.getCurrentFrame();

        // }
    }

    public void moveWestToEastRender(){

        //     int i = 0;
        //     int totalAnimationCount = 0;
        //movement = true;
        //movement = false;
        //if(movement == true && characterDrawX < 600)
        if(drawX < 550 ){
            drawX += 5;
             
        }
        
        if(noDrawX < 550){
        
            noDrawX += 5;
        }
           
        
                    movement = false;
                    
             
                if(drawX > 500 && movement == false && x < 2){
                    x++;
            
                }
                if(noDrawX > 500){
               
                    //characterLocationX++;
                }
        
         
        
        
         }
        
        
         public void moveWestToEast(){
        
        
        if(drawX < 550 ){
            drawX += 5;
             
        }
            
            if(noDrawX < 550){
            
                noDrawX += 5;
            }
               
            
                        
                        
                 
                 
                    if(noDrawX > 500 || drawX > 500){
                   
                        x++;
                        movement = false;
                    }
            
             
            
            
             }
        
        
        
        private boolean moveOneUnit = true;
        
            public void move() {
                
                //characterAnimate++;
                //characterDrawX++;
                if(moveOneUnit == true)
               x++;
        
               moveOneUnit = false;
               movement = false;
               
            }
        
            public Character(Image image, int x, int y) {
        
                this.characterImage = image;
                this.x = x;
                this.x = y;
        
            }
        
            // Method to retrieve a specific image from the array
            public Image getImage() {
        
                return characterImage;
        
            }
        
        }
        