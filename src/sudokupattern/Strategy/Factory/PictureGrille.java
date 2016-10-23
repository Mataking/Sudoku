package sudokupattern.Strategy.Factory;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import sudokupattern.Observer.CGrille9x9;
import sudokupattern.Strategy.Factory.Abstract.AbstractPictureGrille;

/**
 * Created by Mata on 04/10/2016.
 */
public class PictureGrille extends AbstractPictureGrille {
    
	private static final int IMG_WIDTH = 620;
	private static final int IMG_HEIGHT = 620;

    public BufferedImage loadPicture(File filePicture) {
        BufferedImage picture = null;
        // lire l'image
        try {
            picture = ImageIO.read(filePicture);

            if (picture.getHeight() != 620 || picture.getWidth() != 620) {
                picture = resize(picture);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return picture;
    }

    @Override
    public CGrille9x9 getFromPicture() {
        BufferedImage picture = null;

        File filePicture = new File("src//sudokupattern//grille1.png");
        picture = loadPicture(filePicture);


        return null;
    }

    public BufferedImage resize(BufferedImage pictureLoad) {
        BufferedImage resizeImageJpg = null;
        try{
                int type = pictureLoad.getType() == 0? BufferedImage.TYPE_INT_ARGB : pictureLoad.getType();

                resizeImageJpg = resizeImage(pictureLoad, type);
                ImageIO.write(resizeImageJpg, "jpg", new File("src//sudokupattern//pictureResize.jpg"));

            /**
             * Peut améliorer la qualité de l'image si la grille n'est pas lisible
             */
                /*BufferedImage resizeImageHintJpg = resizeImageWithHint(pictureLoad, type);
                ImageIO.write(resizeImageHintJpg, "jpg", new File("src//sudokupattern//picture2.jpg"));*/

        }catch(IOException e){
                System.out.println(e.getMessage());
        }
        return resizeImageJpg;
    }


    /**
     * Redimensionne l'image
     *
     * @param originalImage
     * @param type
     * @return
     */
    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

	    return resizedImage;
    }

    /**
     * Peut améliorer la qualité de l'image si la grille n'est pas lisible
     *
     * @param originalImage
     * @param type
     * @return
     */
    private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type){
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

        System.out.println(g);
	return resizedImage;
    }
    
}