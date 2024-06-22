import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageButtonsPanel extends JPanel {
    public Image image1, image2, image3;
    public Image clickedImage1, clickedImage2, clickedImage3;
    public boolean[] clickedFlags = new boolean[3];
    public JButton button1, button2, button3;

    public ImageButtonsPanel() {
        // setTitle("Image Buttons Panel");
        // setSize(600, 400);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLocationRelativeTo(null);

        // Load images
        try {
            image1 = ImageIO.read(new File("buttonON.png"));
            image2 = ImageIO.read(new File("buttonON.png"));
            image3 = ImageIO.read(new File("buttonON.png"));
            clickedImage1 = ImageIO.read(new File("buttonOFF.png"));
            clickedImage2 = ImageIO.read(new File("buttonOFF.png"));
            clickedImage3 = ImageIO.read(new File("buttonOFF.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create buttons with images
        button1 = new JButton(new ImageIcon(image1));
        button2 = new JButton(new ImageIcon(image2));
        button3 = new JButton(new ImageIcon(image3));

        // Add action listeners to buttons
        button1.addActionListener(new ButtonClickListener(0, button1, clickedImage1));
        button2.addActionListener(new ButtonClickListener(1, button2, clickedImage2));
        button3.addActionListener(new ButtonClickListener(2, button3, clickedImage3));

        // Create a panel and add buttons to it
        // JPanel panel = new JPanel();
        // panel.add(button1);
        // panel.add(button2);
        // panel.add(button3);

        // // Add panel to frame
        // add(panel, BorderLayout.NORTH);

        // Create a custom panel for drawing images
        ImagePanel imagePanel = new ImagePanel();
        add(imagePanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        private int index;
        private JButton button;
        private Image clickedImage;

        public ButtonClickListener(int index, JButton button, Image clickedImage) {
            this.index = index;
            this.button = button;
            this.clickedImage = clickedImage;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            clickedFlags[index] = true;
            button.setIcon(new ImageIcon(clickedImage));
            //JOptionPane.showMessageDialog(null, "Button clicked: " + index);
        }
    }

    private class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the images using Graphics
            if (image1 != null) g.drawImage(image1, 10, 10, this);
            if (image2 != null) g.drawImage(image2, 210, 10, this);
            if (image3 != null) g.drawImage(image3, 410, 10, this);
        }
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         ImageButtonsPanel frame = new ImageButtonsPanel();
    //         frame.setVisible(true);
    //     });
    // }
}
