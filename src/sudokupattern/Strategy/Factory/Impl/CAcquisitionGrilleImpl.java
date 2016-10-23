package sudokupattern.Strategy.Factory.Impl;

import sudokupattern.Strategy.Factory.Abstract.AbstractAutoGrille;
import sudokupattern.Strategy.Factory.Abstract.AbstractFileGrille;
import sudokupattern.Strategy.Factory.ManuelGrille;
import sudokupattern.Strategy.Factory.PictureGrille;

/**
 * Created by Mata on 12/10/2016.
 */

public interface CAcquisitionGrilleImpl {
    AbstractFileGrille getFileGrille();
    AbstractAutoGrille getAutoGrille();
    ManuelGrille getManualGrille();
    PictureGrille getPictureGrille();
}
