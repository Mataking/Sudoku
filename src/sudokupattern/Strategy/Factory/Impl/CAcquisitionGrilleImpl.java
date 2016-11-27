package sudokupattern.Strategy.Factory.Impl;

import sudokupattern.Strategy.Factory.Abstract.AbstractAutoGrille;
import sudokupattern.Strategy.Factory.Abstract.AbstractFileGrille;
import sudokupattern.Strategy.Factory.AutoGrille;
import sudokupattern.Strategy.Factory.FileGrille;
import sudokupattern.Strategy.Factory.ManuelGrille;
import sudokupattern.Strategy.Factory.PictureGrille;

/**
 * Created by Mata on 12/10/2016.
 */

public interface CAcquisitionGrilleImpl {
    FileGrille getFileGrille();
    AutoGrille getAutoGrille();
    ManuelGrille getManualGrille();
    PictureGrille getPictureGrille();
}
