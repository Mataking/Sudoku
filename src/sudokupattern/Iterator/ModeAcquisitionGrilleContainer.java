package sudokupattern.Iterator;

import sudokupattern.Iterator.Impl.ModeAcquisitionGrilleContainerImpl;
import sudokupattern.Iterator.Impl.ModeAcquisitionGrilleIteratorImpl;

/**
 * Created by Mata on 12/10/2016.
 */
public class ModeAcquisitionGrilleContainer implements ModeAcquisitionGrilleContainerImpl {

    public String typeAcquisitionGrille[] = {"Manuel" , "Automatique" ,"Image" , "Fichier"};

    @Override
    public ModeAcquisitionGrilleIteratorImpl getModeAcquisitionGrilleIterator() {
        return new ModeAcquisitionGrilleIterator();
    }

    private class ModeAcquisitionGrilleIterator implements ModeAcquisitionGrilleIteratorImpl {

        int index;

        @Override
        public boolean hasNext() {

            if(index < typeAcquisitionGrille.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return typeAcquisitionGrille[index++];
            }
            return null;
        }
    }
}

