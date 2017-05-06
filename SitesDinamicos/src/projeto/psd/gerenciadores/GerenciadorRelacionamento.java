
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
    
    public boolean remove(String userEmail, String userPara) throws SQLException{
        
        return this.ifc.remove(userEmail, userPara);
        
    }
    
    public Relacionamento retornaRelac(String email) throws SQLException{
        
        return this.ifc.retornaRelac(email);
        
    }
    
    public boolean verificaRelacionamento(String email, String paraEmail) throws SQLException{
        
        return this.ifc.verificaRelacionamento(email, paraEmail);
        
    }
    
    public void closeConexao() throws SQLException{
        
        this.ifc.closeConexao();
        
    }
    
}
