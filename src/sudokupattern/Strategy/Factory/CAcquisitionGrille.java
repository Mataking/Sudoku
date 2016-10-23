package sudokupattern.Strategy.Factory;

import sudokupattern.Strategy.Factory.Abstract.AbstractAutoGrille;
import sudokupattern.Strategy.Factory.Abstract.AbstractFileGrille;
import sudokupattern.Strategy.Factory.Impl.*;

public class CAcquisitionGrille implements CAcquisitionGrilleImpl{

    public AbstractFileGrille getFileGrille() {
        return new FileGrille();
    }

    public AbstractAutoGrille getAutoGrille() {
        return new AutoGrille();
    }

	public ManuelGrille getManualGrille() {
		return new ManuelGrille();
	}

	public PictureGrille getPictureGrille() {
		return new PictureGrille();
	}
}
