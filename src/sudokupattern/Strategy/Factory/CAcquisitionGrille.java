package sudokupattern.Strategy.Factory;

import sudokupattern.Strategy.Factory.Abstract.AbstractAutoGrille;
import sudokupattern.Strategy.Factory.Abstract.AbstractFileGrille;
import sudokupattern.Strategy.Factory.Impl.*;
import sudokupattern.Strategy.Singleton.FactorySingleton;

public class CAcquisitionGrille implements CAcquisitionGrilleImpl{

    public CAcquisitionGrille(FactorySingleton instance) {
    }

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
