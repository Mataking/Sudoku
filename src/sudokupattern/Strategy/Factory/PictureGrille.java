package sudokupattern.Strategy.Factory;

import java.awt.*;
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
            BufferedImage resizeImageJpg = picture;

            if (picture.getHeight() != 620 || picture.getWidth() != 620) {
                int type = picture.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : picture.getType();

                resizeImageJpg = resizeImage(picture, type);

                /**
                 * Peut améliorer la qualité de l'image si la grille n'est pas lisible
                 */
                /*BufferedImage resizeImageHintJpg = resizeImageWithHint(pictureLoad, type);
                ImageIO.write(resizeImageHintJpg, "jpg", new File("src//sudokupattern//picture2.jpg"));*/
            }
            return resizeImageJpg;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CGrille9x9 getFromPicture() {
       /* String path = "src/sudokupattern/sudoku-le-monde-12.jpg";
        String pathImageResize = "src/sudokupattern/sudoku-le-monde-15.jpg";

        BufferedImage picture = null;

        File filePicture = new File(path);
        picture = loadPicture(filePicture);


        try {
            ImageIO.write(picture, "jpg", new File(pathImageResize));

            cutPicture(path);
        } catch (IOException fromPicture) {
            System.out.println(fromPicture);
        }*/
        resizeImageWithoutBlack();
        return null;
    }


    /**
     * Redimensionne l'image
     *
     * @param originalImage
     * @param type
     * @return
     */
    private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
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
    private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type) {
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

    private void cutPicture(String pathPictureToCut) throws IOException {

        BufferedImage image = ImageIO.read(new File(pathPictureToCut));
        int nb = 0;
        int x;
        int y;
        int w = image.getWidth() / 9;
        int h = image.getHeight() / 9;

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                nb = nb + 1;
                x = i * 68;
                y = j * 68;
                BufferedImage out = image.getSubimage(x, y, w, h);

                ImageIO.write(out, "jpg", new File("src/sudokupattern/sudoku-le-monde-12" + nb + ".jpg"));

            }
        }
    }

    public void resizeImageWithoutBlack(){
        try {
            String path = "src/sudokupattern/sudoku-le-monde-9.png";

            BufferedImage picture;

            BufferedImage nouvellimage;

            File filePicture = new File(path);
            picture = ImageIO.read(filePicture);

                for (int j = 0; j < picture.getHeight(); j++) {
                    for (int i = 0; i < picture.getWidth(); i++) {
                        Color mycolor = new Color(picture.getRGB(i, j));

                        System.out.println("pixel : " + j +" +" + i + " : " +mycolor);
                        System.out.println(picture.getRGB(i, j));
                    }
                }
        }catch (Exception e){

        }

    }
}