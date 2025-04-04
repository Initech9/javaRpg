import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadEastWalls {
    public int[][] grid;
    public ReadEastWalls() {
        String fileName = "eastWalls.txt"; // The file name or path to the file

        
        try {
            grid = readGridFromFile(fileName);
            printGrid(grid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] readGridFromFile(String fileName) throws IOException {
        int[][] grid = new int[LoadRooms.MAP_X_WIDTH][LoadRooms.MAP_Y_HEIGHT]; // Assuming a fixed 4x4 grid
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int currentRow = 0;

        while ((line = reader.readLine()) != null && currentRow < 4) {
            String[] values = line.split(",");
            for (int col = 0; col < values.length && col < 4; col++) {
                grid[currentRow][col] = Integer.parseInt(values[col].trim());
            }
            currentRow++;
        }
        reader.close();

        return grid;
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

