package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Pedido;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.PedidoDaoIf;

public class GerenciadorPedido {

    private DaoFactory fabricaDao;
    private PedidoDaoIf ifc;

    public GerenciadorPedido() throws SQLException, ClassNotFoundException {
        this.fabricaDao = new DaoFactory();
        this.ifc = this.fabricaDao.getDaoFactory().criaDaoPedido();
    }

    public void closeConexao() throws SQLException {
        this.ifc.closeConexao();
    }

    public boolean add(String userEmail, String userParaEmail) throws SQLException {

        return this.ifc.add(userEmail, userParaEmail);

    }

    public boolean remove(String userEmail, String userParaEmail) throws SQLException {

        return this.ifc.remove(userEmail, userParaEmail);

    }

    public List<Pedido> listAll() throws SQLException {

        return this.ifc.listAll();
    }
    
    public List<Pedido> listAll(String email) throws SQLException {

        return this.ifc.listAll(email);
    }

}
