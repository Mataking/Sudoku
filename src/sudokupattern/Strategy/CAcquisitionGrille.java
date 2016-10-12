package sudokupattern.Strategy;

import sudokupattern.Strategy.Impl.AutoGrilleImpl;
import sudokupattern.Strategy.Impl.CAcquisitionGrilleImpl;
import sudokupattern.Strategy.Impl.FileGrilleImpl;

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
