package sudokupattern.Strategy.Impl;

import sudokupattern.Strategy.ManuelGrille;
import sudokupattern.Strategy.PictureGrille;

/**
 * Created by Mata on 12/10/2016.
 */
public interface CAcquisitionGrilleImpl {
    FileGrilleImpl getFileGrille();
    AutoGrilleImpl getAutoGrille();
    ManuelGrille getManualGrille();
    PictureGrille getPictureGrille();
}
