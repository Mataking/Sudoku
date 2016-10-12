package sudokupattern.Strategy.Factory;

import sudokupattern.Strategy.Factory.Impl.AutoGrilleImpl;
import sudokupattern.Strategy.Factory.Impl.CAcquisitionGrilleImpl;
import sudokupattern.Strategy.Factory.Impl.FileGrilleImpl;

public class CAcquisitionGrille implements CAcquisitionGrilleImpl {

	@Override
	public FileGrilleImpl getFileGrille() {
		return new FileGrille();
	}

	@Override
	public AutoGrilleImpl getAutoGrille() {
		return new AutoGrille();
	}

	@Override
	public ManuelGrille getManualGrille() {
		return new ManuelGrille();
	}

	@Override
	public PictureGrille getPictureGrille() {
		return new PictureGrille();
	}
}
