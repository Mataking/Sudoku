package sudokupattern.Strategy;

import sudokupattern.Observer.CGrille9x9;

public class CAcquisitionGrille {

	public FileGrille fileGrille = new FileGrille();

	public ManuelGrille manuelGrille = new ManuelGrille();

	public PictureGrille pictureGrille = new PictureGrille();

	public AutoGrille autoGrille = new AutoGrille();
}
