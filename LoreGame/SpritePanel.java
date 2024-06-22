import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



class SpritePanel extends JLabel {
    private Image sprite;
    private int spriteX, spriteY;
    private boolean dragging = false;
    private int dragOffsetX, dragOffsetY;

    public SpritePanel() {
        // Load the sprite image
        sprite = new ImageIcon("bard.png").getImage();
        spriteX = 100;
        spriteY = 100;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isInsideSprite(e.getX(), e.getY())) {
                    dragging = true;
                    dragOffsetX = e.getX() - spriteX;
                    dragOffsetY = e.getY() - spriteY;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    spriteX = e.getX() - dragOffsetX;
                    spriteY = e.getY() - dragOffsetY;
                    repaint();
                }
            }
        });
    }

    private boolean isInsideSprite(int x, int y) {
        return x >= spriteX && x <= spriteX + sprite.getWidth(this)
                && y >= spriteY && y <= spriteY + sprite.getHeight(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sprite, spriteX, spriteY, this);
    }
}
