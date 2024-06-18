import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Room {

    private BufferedImage[] images; // Array to store the images
    private BufferedImage[] imagesAngle; // Array to store the images
    private BufferedImage[] floorImage; // Array to store the images
    public BufferedImage gui;
    public BufferedImage charTemp;

    //public Character character[] = new Character[3];

    public int northWall = 0;
    public int southWall = 0;
    public int eastWall = 0;
    public int westWall = 0;

    public int floor = 0;

    public char direction = 'n'; //NORTH

    public int northWallIndex;

    public Room() {
        images = new BufferedImage[10]; // Initialize the array with size 
        imagesAngle = new BufferedImage[10]; // Initialize the array with size
        floorImage = new BufferedImage[10]; // Initialize the array with size
        try {
            gui = ImageIO.read(new File("inventoryScreen.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        loadImages(); // Load the images during object instantiation
    }

    // Method to load the PNG images from files
    private void loadImages() {
        try {

            //imageGUI =  ImageIO.read(new File("inventoryScreen.png"));
            // Load the images from files and store them in the array
            images[0] = ImageIO.read(new File("invisible.png"));
            images[1] = ImageIO.read(new File("room1.png"));
            images[2] = ImageIO.read(new File("room2.png"));
            images[3] = ImageIO.read(new File("room3.png"));
            images[4] = ImageIO.read(new File("room4.png"));
            images[5] = ImageIO.read(new File("room5.png"));
            images[6] = ImageIO.read(new File("room6.png"));
            images[7] = ImageIO.read(new File("room7.png"));
            images[8] = ImageIO.read(new File("room8.png"));
            images[9] = ImageIO.read(new File("room9.png"));




            imagesAngle[0] = ImageIO.read(new File("invisible.png"));
            imagesAngle[1] = ImageIO.read(new File("room1z.png"));
            imagesAngle[2] = ImageIO.read(new File("room2z.png"));
            imagesAngle[3] = ImageIO.read(new File("room3z.png"));
            imagesAngle[4] = ImageIO.read(new File("room4z.png"));
            imagesAngle[5] = ImageIO.read(new File("room5z.png"));
            imagesAngle[6] = ImageIO.read(new File("room6z.png"));
            imagesAngle[7] = ImageIO.read(new File("room7z.png"));
            imagesAngle[8] = ImageIO.read(new File("room8z.png"));
            imagesAngle[9] = ImageIO.read(new File("room9z.png"));


            floorImage[0] = ImageIO.read(new File("invisible.png"));
            floorImage[1] = ImageIO.read(new File("floor1z.png"));
            floorImage[2] = ImageIO.read(new File("floor2z.png"));
            floorImage[3] = ImageIO.read(new File("floor3z.png"));
            floorImage[4] = ImageIO.read(new File("floor4z.png"));
            floorImage[5] = ImageIO.read(new File("floor5z.png"));
            floorImage[6] = ImageIO.read(new File("floor6z.png"));
            floorImage[7] = ImageIO.read(new File("floor7z.png"));
            floorImage[8] = ImageIO.read(new File("floor8z.png"));
            floorImage[9] = ImageIO.read(new File("floor9z.png"));


            // charTemp = ImageIO.read(new File("bard.png"));
            // character[0] = new Character( charTemp, 0, 0);
            // charTemp = ImageIO.read(new File("bartender.png"));
            // character[1] = new Character( charTemp, 2, 1);
            // charTemp = ImageIO.read(new File("jester.png"));
            // character[2] = new Character( charTemp, 1, 2);

            
            //character[2].movement = true;


            // northWall = images[0];
            // southWall = images[1];
            // eastWall = images[2];
            // westWall = images[3];


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getRelativeNorthWall(char playerDirection){

        if(playerDirection == 'n')
        return this.northWall;
        else if(playerDirection == 's')
        return this.southWall;
        else if(playerDirection == 'e')
        return this.eastWall;
        else if(playerDirection == 'w')
        return this.westWall;
        else{return -1;}

    } 


    public int getRelativeEastWall(char playerDirection){

        if(playerDirection == 'n')
        return this.eastWall;
        else if(playerDirection == 's')
        return this.westWall;
        else if(playerDirection == 'e')
        return this.southWall;
        else if(playerDirection == 'w')
        return this.northWall;
        else{return -1;}

    } 


    public int getRelativeWestWall(char playerDirection){

        if(playerDirection == 'n')
        return this.westWall;
        else if(playerDirection == 's')
        return this.eastWall;
        else if(playerDirection == 'e')
        return this.northWall;
        else if(playerDirection == 'w')
        return this.southWall;
        else{return -1;}

    } 
    public int getRelativeSouthWall(char playerDirection){

        if(playerDirection == 'n')
        return this.southWall;
        else if(playerDirection == 's')
        return this.northWall;
        else if(playerDirection == 'e')
        return this.westWall;
        else if(playerDirection == 'w')
        return this.eastWall;
        else{return -1;}

    } 

    // Method to retrieve a specific image from the array
    public BufferedImage getImage(int index) {
        if (index >= 0 && index < images.length) {
            return images[index];
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }


    // Method to retrieve a specific image from the array
    public BufferedImage getAngledImage(int index) {
        if (index >= 0 && index < imagesAngle.length) {
            return imagesAngle[index];
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }


    // Method to retrieve a specific FLOOR image from the array
    public BufferedImage getFloorImage(int index) {
        if (index >= 0 && index < imagesAngle.length) {
            return floorImage[index];
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }






}
