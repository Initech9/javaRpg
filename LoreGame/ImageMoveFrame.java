import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageMoveFrame extends JFrame {

    private final JPanel mainPanel;
    private JLabel imageLabel;
    private Rectangle imageBounds;
    public File charTemp;

    public ImageMoveFrame(JPanel panel) {
        super("Image Move Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = panel;
        mainPanel.setLayout(null);
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                imageLabel.setBounds(0,0, 800,600);
                if (imageLabel != null && imageBounds.contains(e.getPoint())) {
                    //imageLabel.setLocation(e.getPoint());
                    imageLabel.setLocation((int)e.getPoint().getX()+600, (int)e.getPoint().getY());
                    
                    mainPanel.repaint();
                }

                
            }
        });

        mainPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (imageLabel != null && imageBounds.contains(e.getPoint())) {
                    imageLabel.setLocation((int)e.getPoint().getX()-400, (int)e.getPoint().getY()-300);
                    //imageLabel.setLocation(e.getPoint());
                    mainPanel.repaint();
                }
            }
        });

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        setSize(800, 600);
        setLocationRelativeTo(null);
        mainPanel.setPreferredSize(new Dimension(800, 600));
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
            imageBounds = new Rectangle(0, 0, 800, 600);
            imageLabel.setBounds(imageBounds);
            mainPanel.add(imageLabel);
            pack();
        } catch (IOException ex) {
            System.err.println("Error loading image: " + file.getName());
        }
    }

    public void loadFile() {
        charTemp = new File("jester.png");
        loadImage(charTemp);

    }


}
