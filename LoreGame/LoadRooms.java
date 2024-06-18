import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LoadRooms {

    Room room[][] = new Room[3][3];
    

    public BufferedImage northWall;

    public LoadRooms(Room room[][]){

        room[0][0] = new Room();
        room[0][1] = new Room();
        room[0][2] = new Room();
        room[1][0] = new Room();
        room[1][1] = new Room();
        room[1][2] = new Room();
        room[2][0] = new Room();
        room[2][1] = new Room();
        room[2][2] = new Room();



        room[0][0].northWall = 7;
        room[0][1].northWall = 0;
        room[0][2].northWall = 0;
        room[1][0].northWall = 8;
        room[1][1].northWall = 0;
        room[1][2].northWall = 0;
        room[2][0].northWall = 9;
        room[2][1].northWall = 0;
        room[2][2].northWall = 0;



  
        room[0][0].eastWall = 0;
        room[0][1].eastWall = 0;
        room[0][2].eastWall = 0;
        room[1][0].eastWall = 0;
        room[1][1].eastWall = 0;
        room[1][2].eastWall = 0;
        room[2][0].eastWall = 1;
        room[2][1].eastWall = 2;
        room[2][2].eastWall = 3;
  
        room[0][0].westWall = 6;
        room[0][1].westWall = 5;
        room[0][2].westWall = 4;
        room[1][0].westWall = 0;
        room[1][1].westWall = 0;
        room[1][2].westWall = 0;
        room[2][0].westWall = 0;
        room[2][1].westWall = 0;
        room[2][2].westWall = 0;
  
        room[0][0].southWall = 0;
        room[0][1].southWall = 0;
        room[0][2].southWall = 6;
        room[1][0].southWall = 0;
        room[1][1].southWall = 0;
        room[1][2].southWall = 7;
        room[2][0].southWall = 0;
        room[2][1].southWall = 0;
        room[2][2].southWall = 8;

        room[0][0].floor = 9;
        room[0][1].floor = 9;
        room[0][2].floor = 9;
        room[1][0].floor = 9;
        room[1][1].floor = 9;
        room[1][2].floor = 9;
        room[2][0].floor = 9;
        room[2][1].floor = 9;
        room[2][2].floor = 9;


    }



    
}
