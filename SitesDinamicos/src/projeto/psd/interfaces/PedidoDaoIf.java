package projeto.psd.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Pedido;

public interface PedidoDaoIf {

    public boolean add(String userEmail, String userParaEmail) throws SQLException;

    public boolean remove(String userEmail, String userParaEmail) throws SQLException;

    public List<Pedido> listAll() throws SQLException;

    public List<Pedido> vrfPedido(String email, String paraEmail) throws SQLException;

    public List<Pedido> listAll(String email) throws SQLException;
    
    // Pedido Relacionamento
    
    public boolean addRelacionamento(String userEmail, String userParaEmail, String status) throws SQLException;

    public boolean removeRelacionamento(String userEmail, String userParaEmail) throws SQLException;

    public List<Pedido> listRelacionamento(String email) throws SQLException;
    
    public List<Pedido> listAllRelacionamento(String email) throws SQLException;
    
    public void closeConexao() throws SQLException;
}
