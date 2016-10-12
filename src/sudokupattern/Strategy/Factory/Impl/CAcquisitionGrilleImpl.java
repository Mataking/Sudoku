package sudokupattern.Strategy.Factory.Impl;

import sudokupattern.Strategy.Factory.ManuelGrille;
import sudokupattern.Strategy.Factory.PictureGrille;

/**
 * Created by Mata on 12/10/2016.
 */

public interface CAcquisitionGrilleImpl {
    FileGrilleImpl getFileGrille();
    AutoGrilleImpl getAutoGrille();
    ManuelGrille getManualGrille();
    PictureGrille getPictureGrille();
}
