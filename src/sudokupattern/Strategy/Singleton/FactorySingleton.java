package sudokupattern.Strategy.Singleton;

import sudokupattern.Strategy.Factory.CAcquisitionGrille;

/**
 * Created by Mata on 12/10/2016.
 */

/**
 * Make final to forbidden creation girl-class
 */
public final class FactorySingleton {

    /** Constructeur privé */
    private FactorySingleton()
    {}

    /** Holder */
    private static class FactoryHolder
    {
        /** Instance unique non préinitialisée */
        private final static FactorySingleton instance = new FactorySingleton();
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static FactorySingleton getInstance()
    {
        return FactorySingleton.FactoryHolder.instance;
    }

    public CAcquisitionGrille getCAcquisitionGrille() {

        return new CAcquisitionGrille(FactorySingleton.getInstance()) {

        };
    }
}