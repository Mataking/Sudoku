package sudokupattern.Strategy.Factory.Abstract;

import sudokupattern.Observer.CGrille9x9;

import java.io.IOException;

/**
 * Created by Mata on 04/10/2016.
 */
public abstract class AbstractPictureGrille {
    public abstract CGrille9x9 getFromPicture(String path) throws IOException;
  /*  CGrille9x9 getFromPicture();

    BufferedImage loadPicture(File filePicture);

    BufferedImage resize(BufferedImage pictureLoad);*/
}
