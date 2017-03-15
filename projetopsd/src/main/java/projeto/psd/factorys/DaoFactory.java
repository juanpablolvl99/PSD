package projeto.psd.factorys;

import projeto.psd.interfaces.DaoFactoryIf;

public class DaoFactory {
    
    public DaoFactory(){}
    
    public DaoFactoryIf getDaoFactory(){
        return DaoFactoryDB.getInstance();
    }
    
}
