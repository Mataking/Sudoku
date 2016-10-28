package sudokupattern.Strategy.Factory;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

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

        String path = "src/sudokupattern/Sudoku44.jpg";
        //String path = "src/sudokupattern/sudoku-le-monde-9.png";
        File filePicture = new File(path);
        BufferedImage imgSource = null;

        try{
            imgSource = ImageIO.read(filePicture);
        } catch (IOException e) {
            e.printStackTrace();
        }

     /*   if (imgSource.getHeight() != 620 || imgSource.getWidth() != 620) {
            int type = imgSource.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : imgSource.getType();

            imgSource = resizeImage(imgSource, type);
        }*/

    /*    System.out.println(new Color(imgSource.getRGB(1,1)));
        if(new Color(imgSource.getRGB(1,1)).getRed() != 0) {
            System.out.println("coucou");
            imgSource = detectValuePixel(imgSource);
        }*/

       /* if (imgSource.getHeight() != 620 || imgSource.getWidth() != 620) {
            int type = imgSource.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : imgSource.getType();

            imgSource = resizeImage(imgSource, type);
        }*/

        //else{
        //    System.out.println("55");
            imgSource = contour(imgSource);
        //}

        System.out.println(imgSource);

        try {
            ImageIO.write(imgSource, "jpg", new File("src/sudokupattern/withoutBlack.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //resizeImageWithoutBlack();
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

    public static BufferedImage contour(BufferedImage src) {

        BufferedImage dst = new BufferedImage(src.getWidth(), src.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        // Definition du masque de convolution utilisé pour la détéction des contours de
        // l'image
        float[] mask = { -0.1F, -0.1F, -0.1F, -0.1F, 0.8F, -0.1F, -0.1F, -0.1F, -0.1F};
        Kernel kernel = new Kernel(3, 3, mask);
        // On creer notre outils de convolution
        ConvolveOp convo = new ConvolveOp(kernel);
        // On effectue la convolution
        convo.filter(src, dst);
        // On retourne l'image convoluée
        return dst;
    }

    public BufferedImage detectValuePixel(BufferedImage image){
        BufferedImage dst = new BufferedImage(image.getWidth(), image.getHeight(),
                BufferedImage.TYPE_INT_ARGB);

        BufferedImage carroty;

        int pixelXHautGauche = 0;
        int pixelYHautGauche = 0;
        int pixelXBasDroit = 0;
        int pixelYBasDroit = 0;

        //ArrayList<String> get = new ArrayList<>();
        for (int j = 0; j < image.getHeight(); j++) {
            for (int i = 0; i < image.getWidth(); i++) {
                Color mycolor = new Color(image.getRGB(i, j));
                //System.out.println(mycolor.getRed());
                if(mycolor.getRed() < 150 || mycolor.getBlue() < 150 || mycolor.getGreen() < 150){
                    dst.setRGB(i, j, Color.BLACK.getRGB());
                }
            }
        }

        try {
            ImageIO.write(dst, "jpg", new File("src/sudokupattern/color.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int j = 0; j < dst.getHeight(); j++) {
            for (int i = 0; i < dst.getWidth(); i++) {
                Color mycolor2 = new Color(dst.getRGB(i, j));
                if(mycolor2.getRed() != 0 || mycolor2.getBlue() != 0 || mycolor2.getGreen() != 0)
                {
                    pixelXHautGauche = i;
                    pixelYHautGauche = j;
                    i = dst.getWidth();
                    j = dst.getHeight();
                }
            }
        }

        for (int k = dst.getWidth()-1; k > 0; k--) {
            for (int m = dst.getHeight()-1; m > 0; m--) {
                Color mycolor3 = new Color(dst.getRGB(k, m));
                //System.out.println(mycolor3);
                if(mycolor3.getRed() != 0 || mycolor3.getBlue() != 0 || mycolor3.getGreen() != 0)
                {
                    pixelXBasDroit = m;
                    pixelYBasDroit = k;
                    m = 0;
                    k = 0;
                }
            }
        }

        System.out.println(pixelXBasDroit);
        System.out.println(pixelYBasDroit);
        System.out.println(pixelXHautGauche);
        System.out.println(pixelYHautGauche);

        carroty = dst.getSubimage(pixelXHautGauche, pixelYHautGauche, (dst.getWidth()-pixelXHautGauche)-(dst.getWidth()-pixelYBasDroit), (dst.getHeight()-pixelYHautGauche)-(dst.getHeight()-pixelXBasDroit));
        /*try {
            ImageIO.write(carroty, "jpg", new File("src/sudokupattern/color.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(get);*/

        return carroty;
    }
}