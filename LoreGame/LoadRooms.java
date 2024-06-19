import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LoadRooms {

    MapReader map = new MapReader();

    int x;
    int y;

    public static int MAP_X_WIDTH = 4;
    public static int MAP_Y_HEIGHT = 4;

    Room room[][] = new Room[MAP_X_WIDTH][MAP_Y_HEIGHT];

    //public BufferedImage northWall;

    ReadNorthWalls northWall = new ReadNorthWalls();
    ReadEastWalls eastWall = new ReadEastWalls();
    ReadSouthWalls southWall = new ReadSouthWalls();
    ReadWestWalls westWall = new ReadWestWalls();

    public LoadRooms(Room room[][]) {

        // map.printGrid("map.txt");

        // room[0][0] = new Room();
        // room[0][1] = new Room();
        // room[0][2] = new Room();
        // room[1][0] = new Room();
        // room[1][1] = new Room();
        // room[1][2] = new Room();
        // room[2][0] = new Room();
        // room[2][1] = new Room();
        // room[2][2] = new Room();

        // this creates a new room on x, y and a collision detection if the Room is
        // walkable
        for (int x = 0; x < MAP_X_WIDTH; x++) {
            room[x][y] = new Room();
            room[x][y].walkable = map.grid[x][y];

            for (int y = 0; y < MAP_Y_HEIGHT; y++) {
                room[x][y] = new Room();
                room[x][y].walkable = map.grid[x][y];
            }

        }

        for(int x = 0; x < MAP_X_WIDTH; x++){
        room[x][y].northWall = northWall.grid[y][x];
        for(int y = 0; y < MAP_Y_HEIGHT; y++){
        room[x][y].northWall = northWall.grid[y][x];
        }
    }

        // room[0][0].northWall = 7;
        // room[0][1].northWall = 0;
        // room[0][2].northWall = 0;
        // room[1][0].northWall = 8;
        // room[1][1].northWall = 0;
        // room[1][2].northWall = 0;
        // room[2][0].northWall = 9;
        // room[2][1].northWall = 0;
        // room[2][2].northWall = 0;
        for(x = 0; x < MAP_X_WIDTH; x++){
            room[x][y].eastWall = eastWall.grid[y][x];
            for(int y = 0; y < MAP_Y_HEIGHT; y++){
            room[x][y].eastWall = eastWall.grid[y][x];
            }
        }
        // room[0][0].eastWall = 0;
        // room[0][1].eastWall = 0;
        // room[0][2].eastWall = 0;
        // room[1][0].eastWall = 0;
        // room[1][1].eastWall = 0;
        // room[1][2].eastWall = 0;
        // room[2][0].eastWall = 1;
        // room[2][1].eastWall = 2;
        // room[2][2].eastWall = 3;
        for(x = 0; x < MAP_X_WIDTH; x++){
            room[x][y].westWall = westWall.grid[y][x];
            for(int y = 0; y < MAP_Y_HEIGHT; y++){
            room[x][y].westWall = westWall.grid[y][x];
            }
        }
        // room[0][0].westWall = 6;
        // room[0][1].westWall = 5;
        // room[0][2].westWall = 4;
        // room[1][0].westWall = 0;
        // room[1][1].westWall = 0;
        // room[1][2].westWall = 0;
        // room[2][0].westWall = 0;
        // room[2][1].westWall = 0;
        // room[2][2].westWall = 0;

        for(x = 0; x < MAP_X_WIDTH; x++){
            room[x][y].southWall = southWall.grid[y][x];
            for(int y = 0; y < MAP_Y_HEIGHT; y++){
            room[x][y].southWall = southWall.grid[y][x];
            }
        }
        
        // room[0][0].southWall = 0;
        // room[0][1].southWall = 0;
        // room[0][2].southWall = 6;
        // room[1][0].southWall = 0;
        // room[1][1].southWall = 0;
        // room[1][2].southWall = 7;
        // room[2][0].southWall = 0;
        // room[2][1].southWall = 0;
        // room[2][2].southWall = 8;

        room[0][0].floor = 9;
        room[0][1].floor = 9;
        room[0][2].floor = 9;
        room[1][0].floor = 9;
        room[1][1].floor = 9;
        room[1][2].floor = 9;
        room[2][0].floor = 9;
        room[2][1].floor = 9;
        room[2][2].floor = 9;

        // Collision detection, tells if a room is walkable 1 if yes, 0 if no
        // for(int x = 0; x < MAP_X_WIDTH; x++){
        // room[x][y].walkable = map.grid[x][y];
        // for(int y = 0; y < MAP_Y_HEIGHT; y++){
        // room[x][y].walkable = map.grid[x][y];
        // }

        // }
        // room[1][1].walkable = false;

        // room[2][2].walkable = false;

    }

    }

