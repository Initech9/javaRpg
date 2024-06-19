import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapReader {
    
    public MapReader() {
        String fileName = "map.txt"; // The file name or path to the file

        try {
            boolean[][] grid = readGridFromFile(fileName);
            printGrid(grid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean[][] readGridFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int rows = 0;
        int cols = -1;
        
        // First, determine the size of the grid
        while ((line = reader.readLine()) != null) {
            rows++;
            if (cols == -1) {
                cols = line.split(",").length;
            }
        }
        reader.close();
        
        boolean[][] grid = new boolean[rows][cols];
        reader = new BufferedReader(new FileReader(fileName));
        int currentRow = 0;

        // Read the grid values into the 2D array
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            for (int col = 0; col < values.length; col++) {
                grid[currentRow][col] = values[col].trim().equals("1");
            }
            currentRow++;
        }
        reader.close();

        return grid;
    }

    private static void printGrid(boolean[][] grid) {
        for (boolean[] row : grid) {
            for (boolean cell : row) {
                System.out.print((cell ? 1 : 0) + " ");
            }
            System.out.println();
            System.out.println("HARHAR");
        }
    }
}
