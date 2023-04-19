import java.awt.image.BufferedImage;

public class Character {

    public int characterLocationX;
    public int characterLocationY;

    public BufferedImage characterImage;

    public Character(BufferedImage image, int x, int y){

        this.characterImage = image;
        this.characterLocationX = x;
        this.characterLocationY = y;

    }


        // Method to retrieve a specific image from the array
        public BufferedImage getImage() {
            
                return characterImage;
          
        }

    
}
