package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Pedido;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.PedidoDaoIf;

public class GerenciadorPedido {

    private DaoFactory fabricaDao;
    private PedidoDaoIf cad;
    
    public GerenciadorPedido() throws SQLException, ClassNotFoundException{
        this.fabricaDao = new DaoFactory();
        this.cad = this.fabricaDao.getDaoFactory().criaDaoPedido();   
    }
    
    public boolean add(String userEmail, String userParaEmail) throws SQLException{
        return this.cad.add(userEmail, userParaEmail);
    
    }
    
    public boolean remove(String userEmail, String userParaEmail) throws SQLException{
        return this.cad.remove(userEmail, userParaEmail);
    }
    
    public List<Pedido> listAll() throws SQLException{
        return this.cad.listAll();
    }
    
}
