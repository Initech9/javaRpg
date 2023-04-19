import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.sound.midi.*;

public class GridDungeonGame extends JFrame {
    
    public DrawGraphics drawGraphics;
   
    
    
    public GridDungeonGame() {
        
       drawGraphics = new DrawGraphics();
       
    }
    public static void main(String[] args) {
        
        
        MidiPlayer player = new MidiPlayer("opera.mid");
        Thread thread = new Thread(player);
        //thread.start();


        SwingUtilities.invokeLater(GridDungeonGame::new);

        
    
    }
    
}