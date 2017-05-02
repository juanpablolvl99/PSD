
package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Relacionamento;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.RelacionamentoDaoIf;

public class GerenciadorRelacionamento {
    
    private RelacionamentoDaoIf ifc;
    private DaoFactory fabrica;
    
    public GerenciadorRelacionamento() throws SQLException, ClassNotFoundException{
        this.fabrica = new DaoFactory();
        this.ifc = fabrica.getDaoFactory().criarDaoRelacionamento();
    }
    
    public boolean add(Relacionamento r) throws SQLException {
        
        return this.ifc.add(r);
        
    }
    
    public boolean remove(Relacionamento r) throws SQLException{
        
        return this.ifc.remove(r);
        
    }
    
    public Relacionamento listAll(String email) throws SQLException{
        
        return this.ifc.listAll(email);
        
    }
    
    public void closeConexao() throws SQLException{
        
        this.ifc.closeConexao();
        
    }
    
}
