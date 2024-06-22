import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


// public LoadRooms loadRooms = new LoadRooms();

public class DrawGraphics extends JFrame implements Runnable {

    //private final JPanel mainPanel;

    private Image sprite = new ImageIcon("gold.png").getImage();
    private Image sprite2 = new ImageIcon("bartender.png").getImage();


    public ImageButtonsPanel buttons9 = new ImageButtonsPanel();
//ButtonPanel buttons = new ButtonPanel();

    private Image[] sprites;
    private int[][] spritePositions;
    private boolean[] dragging;
    //private int dragOffsetX, dragOffsetY;
    private int draggedSpriteIndex = -1;

   private JLabel imageLabel = new JLabel("jester.png");
    private JLabel imageLabel2  = new JLabel("bard.png");
    private int dragOffsetX, dragOffsetY;

    private Rectangle imageBounds;
    public File charTemp2;

    private int spriteX = 300 , spriteY = 500;
    private int spriteX2 = 300 , spriteY2 = 400;
   // private boolean dragging = false;
   

//    private boolean button1Clicked = false;
//    private boolean button2Clicked = false;
//    private boolean button3Clicked = false;

//    private JButton button1;
//    private JButton button2;
//    private JButton button3;

//    private ImageIcon button1Icon1 = new ImageIcon("buttonON.png");
//    private ImageIcon button1Icon2 = new ImageIcon("buttonOFF.png");
//    private ImageIcon button2Icon1 = new ImageIcon("bard.png");
//    private ImageIcon button2Icon2 = new ImageIcon("jester.png");
//    private ImageIcon button3Icon1 = new ImageIcon("bartender.png");
//    private ImageIcon button3Icon2 = new ImageIcon("bard.png");
public boolean buttonON[] = {true, true};


    private static final int ROOM_SIZE = 800; // Room size in pixels
    private static final int CELL_SIZE = 40; // Cell size in pixels
    private static final int PLAYER_SIZE = 20; // Player size in pixels

    public Player player = new Player();

    private char[][] grid;

    private int numRows;
    private int numCols;

    private final int INVISIBLE = 0;

    private JPanel gamePanel;
    private int playerX;
    private int playerY;
    private int playY = playerX;
    private int playX = playerY;

    // MidiPlayer playerMusic = new MidiPlayer("opera.mid");

    public Character character[] = new Character[3];

    public static Room room[][] = new Room[LoadRooms.MAP_X_WIDTH][LoadRooms.MAP_Y_HEIGHT];

    public BufferedImage currentNorthWall;
    public BufferedImage currentEastWall;
    public BufferedImage currentSouthWall;
    public BufferedImage currentWestWall;

    LoadRooms loadRooms = new LoadRooms(room);

    public Image charTemp;

    Thread thread;
    Thread thread2;
    Thread thread3;

    ImageIcon icon;
    Image image;

    boolean running = false;

    ImageMoveFrame frame;
    // frame.setVisible(true);
    // frame.loadFile();
    private void init() {
        running = true;

    }

    private void tick() {

        character[0].tick(); // NEEDED
        character[1].tick();
        character[2].tick();

    }

    private void render() {

        gamePanel.repaint();

    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();

        thread2 = new Thread(character[0]);

        thread2.start();



        // thread3 = new Thread(character[1]);

        // thread3.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        init();

        int fps = 30;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    public DrawGraphics() {

        // Set player starting position

        this.numRows = LoadRooms.MAP_X_WIDTH;
        this.numCols = LoadRooms.MAP_Y_HEIGHT;

        grid = new char[numRows][numCols];
        // ImageIcon icon = new ImageIcon("00N.png");
        // Image image = icon.getImage();
        // room[0][0].northWall = image;



        try {
            charTemp = ImageIO.read(new File("jester.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        character[0] = new Character(charTemp, -1, 0);

        try {
            charTemp = ImageIO.read(new File("bartender.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        character[1] = new Character(charTemp, 0, 1);

        try {
            charTemp = ImageIO.read(new File("bard.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        character[2] = new Character(charTemp, 1, 2);

        // Thread thread = new Thread(playerMusic);

        try {
            character[0].characterAnimationFrames[0] = ImageIO.read(new File("jester.png"));
        } catch (IOException e) {
        }
        try {
            character[0].characterAnimationFrames[1] = ImageIO.read(new File("jester2.png"));
        } catch (IOException e) {
        }
        // try{character[0].characterAnimationFrames[2] = ImageIO.read(new
        // File("jester.png"));} catch (IOException e) {}

        try {
            character[1].characterAnimationFrames[0] = ImageIO.read(new File("bartender.png"));
        } catch (IOException e) {
        }
        try {
            character[1].characterAnimationFrames[1] = ImageIO.read(new File("bartender2.png"));
        } catch (IOException e) {
        }

        try {
            character[2].characterAnimationFrames[0] = ImageIO.read(new File("bard.png"));
        } catch (IOException e) {
        }
        try {
            character[2].characterAnimationFrames[1] = ImageIO.read(new File("bard2.png"));
        } catch (IOException e) {
        }



    



        // }

        /*
         * //
         * //START JPanel
         * //
         * //
         */








        //  SwingUtilities.invokeLater(() -> {
        //     // JFrame frame = new JFrame("Clickable Image Buttons");
        //     // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //     // frame.setSize(400, 400);

        //     ButtonPanel buttonPanel = new ButtonPanel();
        //     gamePanel.add(buttonPanel);
        //     gamePanel.setVisible(true);
           
        // });
       

         

        // Set up the game panel
        gamePanel = new JPanel() {

 


           

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw the dungeon walls based on player position
                // int roomNumber = playerX * 3 + playerY + 1;
                // ImageIcon icon = new ImageIcon("room" + roomNumber + ".png");
                // Image image = icon.getImage();
                // g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

                // int roomNumber = playerX * 3 + playerY + 1;
                icon = new ImageIcon("sky.png");
                image = icon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                

                if (player.direction == 'e') {
                    currentNorthWall = room[playerY][playerX].getImage(room[playerY][playerX].westWall);
                    currentEastWall = room[playerY][playerX].getAngledImage(room[playerY][playerX].southWall);
                    currentSouthWall = room[playerY][playerX].getImage(0);
                    currentWestWall = room[playerY][playerX].getAngledImage(room[playerY][playerX].northWall);
                }

                try {
                    drawWallsFacingNorth(g);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // while(character[0].x < 1){
                // character[0].movement = true;
                // }

                // if (player.direction == 'n')
                // drawWallsFacingNorth(g);
                // else if (player.direction == 'e')
                // drawWallsFacingNorth(g);
                // else if (player.direction == 's')
                // drawWallsFacingNorth(g);
                // else if (player.direction == 'w')
                // drawWallsFacingNorth(g);

                // Draw the GUI
                image = room[playerY][playerX].gui;
                g.drawImage(image, 0, 0, 800, 900, this);


                //g.drawImage(sprite, spriteX, spriteY, this);
                
                     for (int i = 0; i < sprites.length; i++) {
                g.drawImage(sprites[i], spritePositions[i][0], spritePositions[i][1], this);
            }
                
            // button1 = createImageButton(button1Icon1, 1);
            // button2 = createImageButton(button2Icon1, 2);
            // button3 = createImageButton(button3Icon1, 3);
    

            //g.drawImage((Image)button1.getIcon(),300,300, this);
            // gamePanel.add(button1);
            // gamePanel.add(button2);
            // gamePanel.add(button3);


      
            }

           
            


        };

       //Graphics g;
        //paintComponent(     );
        
        gamePanel.setPreferredSize(new Dimension(ROOM_SIZE, ROOM_SIZE));
       
        add(gamePanel);
        
      //add(buttons9.button1);
        gamePanel.add(buttons9);
        
      //buttons9.setVisible(true);
        
        //buttons = new ClickableImageButtons( gamePanel);




        //super("Image Move Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //gamePanel = panel;
        gamePanel.setLayout(null);

        
        //imageBounds = new Rectangle(0, 0, 800, 600);
       

        // getContentPane().add(gamePanel, BorderLayout.CENTER);
        // setSize(800, 600);
        // setLocationRelativeTo(null);
        // gamePanel.setPreferredSize(new Dimension(800, 600));

//gamePanel.add(buttons);
//add(buttons);



        //frame = new ImageMoveFrame(gamePanel);
        gamePanel.setVisible(true);
        loadFile();
        mouseClickSprite(imageLabel2, gamePanel, imageBounds);


        
        
//gamePanel.add(buttons);
//gamePanel.setVisible(true);
        setFocusable(true);
        requestFocus();

       // buttons = new ClickableImageButtons(gamePanel);
        
        // COLLAPSED KEY LISTENER






        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                if (player.direction == 'n') {
                    switch (key) {
                        case KeyEvent.VK_W:
                            movePlayer(-1, 0);
                            break;
                        case KeyEvent.VK_A:
                            movePlayer(0, -1);
                            break;
                        case KeyEvent.VK_S:
                            movePlayer(1, 0);
                            break;
                        case KeyEvent.VK_D:
                            movePlayer(0, 1);
                            break;
                        case KeyEvent.VK_E:
                            movePlayer(0, 0);
                            player.direction = 'e';
                            break;
                        case KeyEvent.VK_Q:
                            movePlayer(0, 0);
                            player.direction = 'w';
                            break;

                    }
                } else if (player.direction == 'e') {
                    switch (key) {
                        case KeyEvent.VK_W:
                            movePlayer(0, 1);
                            break;
                        case KeyEvent.VK_A:
                            movePlayer(-1, 0);
                            break;
                        case KeyEvent.VK_S:
                            movePlayer(0, -1);
                            break;
                        case KeyEvent.VK_D:
                            movePlayer(1, 0);
                            break;
                        case KeyEvent.VK_E:
                            movePlayer(0, 0);
                            player.direction = 's';
                            break;
                        case KeyEvent.VK_Q:
                            movePlayer(0, 0);
                            player.direction = 'n';
                            break;

                    }
                } else if (player.direction == 's') {
                    switch (key) {

                        case KeyEvent.VK_W:
                            movePlayer(1, 0);
                            break;
                        case KeyEvent.VK_A:
                            movePlayer(0, 1);
                            break;
                        case KeyEvent.VK_S:
                            movePlayer(-1, 0);
                            break;
                        case KeyEvent.VK_D:
                            movePlayer(0, -1);
                            break;
                        case KeyEvent.VK_E:
                            movePlayer(0, 0);
                            player.direction = 'w';
                            break;
                        case KeyEvent.VK_Q:
                            movePlayer(0, 0);
                            player.direction = 'e';
                            break;

                    }

                } else if (player.direction == 'w') {
                    switch (key) {

                        case KeyEvent.VK_W:
                            movePlayer(0, -1);
                            break;
                        case KeyEvent.VK_A:
                            movePlayer(1, 0);
                            break;
                        case KeyEvent.VK_S:
                            movePlayer(0, 1);
                            break;
                        case KeyEvent.VK_D:
                            movePlayer(-1, 0);
                            break;
                        case KeyEvent.VK_E:
                            movePlayer(0, 0);
                            player.direction = 'n';
                            break;
                        case KeyEvent.VK_Q:
                            movePlayer(0, 0);
                            player.direction = 's';
                            break;

                    }

                }

            }

        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void movePlayer(int dx, int dy) {

int newX = playerX + dx;
int newY = playerY + dy;

        if(this.room[newX][newY].walkable == true){

        newX = playerX + dx;
        newY = playerY + dy;

        }else{
            newX = playerX;
            newY = playerY;

        }


        // Check if the new position is within the room bounds
        if (newX >= 0 && newX < LoadRooms.MAP_X_WIDTH && newY >= 0 && newY < LoadRooms.MAP_Y_HEIGHT) {
            playerX = newX;
            playerY = newY;

            player.playerX = playerX;
            player.playerY = playerY;

            playY = playerX; // added to swap to make readable z4
            playX = playerY;
            // gamePanel.repaint();
            System.out.println("drawX: " + character[0].drawX);
            System.out.println("X: " + playerY + "Y: " + playerX);
            printGrid();
        }
    }

    private void printGrid() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print(grid[i][j] + "P");
                } else
                    System.out.print(grid[i][j] + ".");
            }
            System.out.println();
        }
        System.out.println();
    }

    int XzeroOffset = 0;
    int XoneOffset = 1;
    int XtwoOffset = 2;
    int XleftOffset = -1;
    int XrightOffset = 1;

    int YleftOffset = -1;
    int YrightOffset = 1;
    int YzeroOffset = 0;
    int YoneOffset = -1;
    int YtwoOffset = -2;

    public void drawWallsFacingNorth(Graphics g) throws IOException {

        icon = new ImageIcon("sky.png");
        image = icon.getImage();

        if (player.direction == 'n') {

            XzeroOffset = 0;
            XoneOffset = 0;
            XtwoOffset = 0;

            XleftOffset = -1;
            XrightOffset = 1;
            XzeroOffset = 0;
            YoneOffset = -1;
            YtwoOffset = -2;

            YleftOffset = 0;
            YrightOffset = 0;

        }

        else if (player.direction == 'e') {

            XzeroOffset = 0;
            XoneOffset = 1;
            XtwoOffset = 2;

            XleftOffset = 0;
            XrightOffset = 0;

            YleftOffset = -1;
            YrightOffset = 1;
            YoneOffset = 0;
            YtwoOffset = 0;

        }

        else if (player.direction == 's') {
            XzeroOffset = 0;
            XoneOffset = 0;
            XtwoOffset = 0;

            XleftOffset = 1;
            XrightOffset = -1;
            XzeroOffset = 0;
            YoneOffset = 1;
            YtwoOffset = 2;

            YleftOffset = 0;
            YrightOffset = 0;

        }

        else if (player.direction == 'w') {

            XzeroOffset = 0;
            XoneOffset = -1;
            XtwoOffset = -2;

            XleftOffset = 0;
            XrightOffset = 0;

            YleftOffset = 1;
            YrightOffset = -1;
            YoneOffset = 0;
            YtwoOffset = 0;

        }

        // Draw the wall that exists 2 grid spaces in front of you
        if (room[playX][playY].getRelativeNorthWall(player.direction) == INVISIBLE
                && room[playX + XoneOffset][playY + YoneOffset].getRelativeNorthWall(player.direction) == INVISIBLE) {
            image = room[playX + XtwoOffset][playY + YtwoOffset]
                    .getImage(room[playX + XtwoOffset][playY + YtwoOffset].getRelativeNorthWall(player.direction));

            g.drawImage(image, 270, 230, 100, 100, this);

            if (player.direction == 'n' || player.direction == 's') {
                try {
                    image = room[playX + XtwoOffset][playY].getImage(
                            room[playX + XleftOffset][playY + YtwoOffset].getRelativeNorthWall(player.direction));
                    g.drawImage(image, 150, 230, 100, 100, this);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("CAUGHT ARRAY OUT OF BOUNDS!!");
                }
                try {
                    image = room[playX + XtwoOffset][playY].getImage(
                            room[playX + XrightOffset][playY + YtwoOffset].getRelativeNorthWall(player.direction));
                    g.drawImage(image, 400, 230, 100, 100, this);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("CAUGHT ARRAY OUT OF BOUNDS!!");
                }
            }
            if (player.direction == 'e' || player.direction == 'w') {
                try {
                    image = room[playX + XtwoOffset][playY].getImage(
                            room[playX + XtwoOffset][playY + YleftOffset].getRelativeNorthWall(player.direction));
                    g.drawImage(image, 150, 230, 100, 100, this);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("CAUGHT ARRAY OUT OF BOUNDS!!");
                }
                try {
                    image = room[playX + XtwoOffset][playY].getImage(
                            room[playX + XtwoOffset][playY + YrightOffset].getRelativeNorthWall(player.direction));
                    g.drawImage(image, 400, 230, 100, 100, this);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("CAUGHT ARRAY OUT OF BOUNDS!!");
                }
            }

            if (player.direction == 'n') {
                image = room[playX][playY].getAngledImage(room[playX][playY + YtwoOffset].getRelativeNorthWall('e'));
                g.drawImage(image, 400, 210, -30, 135, this);
                image = room[playX][playY].getAngledImage(room[playX][playY + YtwoOffset].getRelativeNorthWall('w'));
                g.drawImage(image, 230, 200, 45, 150, this);
            } else if (player.direction == 's') {
                image = room[playX][playY].getAngledImage(room[playX][playY + YtwoOffset].getRelativeNorthWall('w'));
                g.drawImage(image, 400, 210, -30, 135, this);
                image = room[playX][playY].getAngledImage(room[playX][playY + YtwoOffset].getRelativeNorthWall('e'));
                g.drawImage(image, 230, 200, 45, 150, this);
            } else if (player.direction == 'e') {
                image = room[playX][playY].getAngledImage(room[playX + XtwoOffset][playY].getRelativeNorthWall('s'));
                g.drawImage(image, 400, 210, -30, 135, this);
                image = room[playX][playY].getAngledImage(room[playX + XtwoOffset][playY].getRelativeNorthWall('n'));
                g.drawImage(image, 230, 200, 45, 150, this);
            }

            // Draw the floor 2 rooms away:
            image = room[playX + XtwoOffset][playY].getFloorImage(room[playX + XtwoOffset][playY].floor);
            g.drawImage(image, 0, 330, 950, 30, this);

            // //Draw NPC characters
            // if (room[playX][playY + YtwoOffset].character. == playX &&
            // room[playX][playY + YtwoOffset].character.y == playY-2) {
            // image = room[playX][playY + YoneOffset].character.characterImage ;
            // g.drawImage(image, 280, 250, 100, 100, this);
            // }

            for (int i = 0; i < 3; i++) {
                // Draw NPC characters
                if (character[i].x == playX + XtwoOffset
                        && character[i].y == playY + YtwoOffset) {
                    image = character[i].characterImage;
                    g.drawImage(image, 280, 250, 100, 100, this);
                }
            }

        }

        // Draw the wall that exists 2 grid spaces in front of you
        if (room[playX][playY].getRelativeNorthWall(player.direction) == INVISIBLE) {
            image = room[playX + XoneOffset][playY + YoneOffset]
                    .getImage(room[playX + XoneOffset][playY + YoneOffset].getRelativeNorthWall(player.direction));
            g.drawImage(image, 250, 200, 150, 150, this);

            if (player.direction == 'n' || player.direction == 's') {
                // Get the North West wall diagonal from you and display it. Check that the wall
                // exists in the array[] or you'll get an out of bounds error
                try {
                    image = room[playX][playY].getImage(
                            room[playX + XleftOffset][playY + YoneOffset].getRelativeNorthWall(player.direction));
                    g.drawImage(image, 100, 200, 150, 150, this);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("CAUGHT ARRAY OUT OF BOUNDS!!");
                }
                // Get the North East wall diagonal from you and display it.Check that the wall
                // exists in the array[] or you'll get an out of bounds error

                try {
                    image = room[playX][playY].getImage(
                            room[playX + XrightOffset][playY + YoneOffset].getRelativeNorthWall(player.direction));
                    g.drawImage(image, 420, 200, 150, 150, this);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("CAUGHT ARRAY OUT OF BOUNDS!!");
                }
            }
            if (player.direction == 'e' || player.direction == 'w') {
                // Get the North West wall diagonal from you and display it. Check that the wall
                // exists in the array[] or you'll get an out of bounds error
                try {
                    image = room[playX][playY].getImage(
                            room[playX + XoneOffset][playY + YleftOffset].getRelativeNorthWall(player.direction));
                    g.drawImage(image, 100, 200, 150, 150, this);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("CAUGHT ARRAY OUT OF BOUNDS!!");
                }
                // Get the North East wall diagonal from you and display it.Check that the wall
                // exists in the array[] or you'll get an out of bounds error

                try {
                    image = room[playX][playY].getImage(
                            room[playX + XoneOffset][playY + YrightOffset].getRelativeNorthWall(player.direction));
                    g.drawImage(image, 420, 200, 150, 150, this);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("CAUGHT ARRAY OUT OF BOUNDS!!");
                }

            }

            // Draw the floor one room away:
            image = room[playX][playY + YoneOffset].getFloorImage(room[playX][playY + YoneOffset].floor);
            g.drawImage(image, 0, 350, 850, 100, this);

            image = room[playX][playY]
                    .getAngledImage(room[playX + XoneOffset][playY + YoneOffset].getRelativeEastWall(player.direction));
            g.drawImage(image, 500, 150, -100, 250, this);
            image = room[playX][playY]
                    .getAngledImage(room[playX + XoneOffset][playY + YoneOffset].getRelativeWestWall(player.direction));
            g.drawImage(image, 200, 150, 50, 250, this);

            // //Draw NPC characters
            // if (room[playX][playY + YoneOffset].character. == playX &&
            // room[playX][playY + YoneOffset].character.y == playY-1) {
            // image = room[playX][playY + YoneOffset].character.characterImage ;
            // g.drawImage(image, 240, 230, 180, 200, this);
            // }

            for (int i = 0; i < 3; i++) {
                // Draw NPC characters one room away

                if (character[i].x == playX + XoneOffset
                        && character[i].y == playY + YoneOffset) {
                    image = character[i].characterImage;
                    g.drawImage(image, 270, 220, 150, 180, this);
                }
            }

            // for(int i = 0; i < 3; i++){
            // //Draw NPC characters
            // if ( character[i]. + XtwoOffset == playX+XtwoOffset &&
            // character[i].y == playY+YtwoOffset) {
            // image = character[i].characterImage ;
            // g.drawImage(image, 280, 250, 100, 100, this);
            // }
            // }

        }
        // Draw immediate wall in front of you
        if (room[playX][playY].getRelativeNorthWall(player.direction) > INVISIBLE) {

            image = room[playX][playY].getImage(room[playX][playY].getRelativeNorthWall(player.direction));
            g.drawImage(image, 200, 150, 300, 300, this);

            if (room[playX][playY].getRelativeWestWall(player.direction) > 0) {
                // Draw the adjacent walls

            } else {

                image = room[playX][playY].getImage(
                        room[playX + XleftOffset][playY + YleftOffset].getRelativeNorthWall(player.direction));
                g.drawImage(image, -100, 150, 300, 300, this);

            }

            if (room[playX][playY].getRelativeEastWall(player.direction) > INVISIBLE) {
                // Draw the adjacent walls

            } else {

                image = room[playX][playY].getImage(
                        room[playX + XrightOffset][playY + YrightOffset].getRelativeNorthWall(player.direction));
                g.drawImage(image, 500, 150, 300, 300, this);

            }

        }

        // Draw the immediate floor:
        image = room[playX][playY].getFloorImage(room[playX][playY].floor);
        g.drawImage(image, -30, 410, 700, 200, this);
        // Draw immediate east and west walls

        image = room[playX][playY].getAngledImage(room[playX][playY].getRelativeEastWall(player.direction));
        g.drawImage(image, 600, 0, -100, 550, this);
        image = room[playX][playY].getAngledImage(room[playX][playY].getRelativeWestWall(player.direction));
        g.drawImage(image, 100, 0, 100, 550, this);

        boolean drawCharacter = false;

        // System.out.println("JesterX is: " + character[0].x);
        if (character[0].x < 2)
            character[0].movement = true;

            character[1].movement = false;
            character[2].movement = false;
            character[1].y = 2;
            character[2].y = 0;

            character[0].x = 0;
        for (int i = 0; i < 3; i++) {
            // // Draw NPC characters one room away

            if (character[i].movement == true) {

                character[i].moveWestToEast();

            }

            if (character[i].x == playX && character[i].y == playY) {

                if (character[i].movement == true && player.direction == 'n') {
                    character[i].render(g);
                    character[i].moveWestToEastRender();

                }else if (character[i].movement == false) {
                   
                    character[i].drawX = 200;
                    //character[i].moveWestToEast();
                    
                    //image = character[i].characterImage;
                    //g.drawImage(image, 250, 210, 250, 250, this);

                }
                character[i].render(g);
        

            }
            
        }

    }



    private void loadImage(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            ImageIcon icon = new ImageIcon(image);
            int width = 800; //icon.get.getIconWidth();
            int height = 600;//icon.getIconHeight();
            int x = (800 - width) / 2; // center the image horizontally
            int y = (600 - height) / 2; // center the image vertically
            imageLabel = new JLabel(icon);
            imageBounds = new Rectangle(0, 0, 1400, 600);
            imageLabel.setBounds(imageBounds);
            gamePanel.add(imageLabel);
            pack();
        } catch (IOException ex) {
            System.err.println("Error loading image: " + file.getName());
        }
    }

    public void loadFile() {
        charTemp2 = new File("bard.png");
        loadImage(charTemp2);

    }


    public void mouseClickSprite( JLabel imageLabel9, JPanel gamePanel9, Rectangle imageBounds9  ){
       // private Image[] sprites;
       // private int[][] spritePositions;
       // private boolean[] dragging;
       // private int dragOffsetX, dragOffsetY;
        //private int draggedSpriteIndex = -1;

        boolean draggableSprite[] = {false, false,true, true};
        boolean isButton[] = {true, true, false, false};
       //boolean isVisible[] = {true, false, false, false};

    Image[] tempImage =  new Image[] {
        new ImageIcon("buttonON.png").getImage(),
        new ImageIcon("buttonOFF.png").getImage()
    };

       // public SpritePanel() {
            // Load the sprite images
            sprites = new Image[] {
                new ImageIcon("buttonON.png").getImage(),
                new ImageIcon("buttonOFF.png").getImage(),
                new ImageIcon("sword.png").getImage(),
                new ImageIcon("gold.png").getImage()
            };
    
            // Initial positions for the sprites
            spritePositions = new int[][] {
                { 200, 250 },
                { -200, -100 },
                { 280, 500 },
                { 300, 500 }
            };
    
            // Dragging state for each sprite
            dragging = new boolean[sprites.length];
    
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    for (int i = 0; i < sprites.length; i++) {
                        if (isInsideSprite(e.getX(), e.getY(), i)  ) {
                            
                            if(draggableSprite[i]){
                            dragging[i] = true;
                            draggedSpriteIndex = i;
                            dragOffsetX = e.getX() - spritePositions[i][0];
                            dragOffsetY = e.getY() - spritePositions[i][1];
                            }

                            if(isButton[i] && buttonON[i] ){
                                tempImage[0] = sprites[0];
                                tempImage[1] = sprites[1];
                                 sprites[0] = tempImage[1]; // this will change switch the button from ON to OFF
                                 room[2][2].walkable = true; //door unlocked
                             buttonON[i] = false;   
                             }
                                else if(isButton[i] && buttonON[i] == false ){
     
                                     sprites[0] = tempImage[0];
                                     room[2][2].walkable = false; //door locked
                                     buttonON[i] = true;
                                 }
                            
                            //buttonON[i] = false;  
                     

                            break;
                        }
                    }
                }
    
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (draggedSpriteIndex != -1) {
                        dragging[draggedSpriteIndex] = false;
                        draggedSpriteIndex = -1;

                        
                    }
                }
            });
    
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (draggedSpriteIndex != -1) {
                        spritePositions[draggedSpriteIndex][0] = e.getX() - dragOffsetX;
                        spritePositions[draggedSpriteIndex][1] = e.getY() - dragOffsetY;
                        repaint();
                    }
                }
            });
        }
    
        private boolean isInsideSprite(int x, int y, int index) {
            return x >= spritePositions[index][0] && x <= spritePositions[index][0] + sprites[index].getWidth(this)
                    && y >= spritePositions[index][1] && y <= spritePositions[index][1] + sprites[index].getHeight(this)+20;
        }
    
        // @Override
        // protected void paintComponent(Graphics g) {
        //     super.paintComponent(g);
        //     for (int i = 0; i < sprites.length; i++) {
        //         g.drawImage(sprites[i], spritePositions[i][0], spritePositions[i][1], this);
        //     }
        // }
    
    


    


    private boolean isInsideSprite(int x, int y) {
        return x >= spriteX && x <= spriteX + sprite.getWidth(this)
                && y >= spriteY && y <= spriteY + sprite.getHeight(this);
    }







}






