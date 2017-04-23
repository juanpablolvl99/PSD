package projeto.psd.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto.psd.entidades.Pedido;
import projeto.psd.factorys.ConFactory;
import projeto.psd.interfaces.PedidoDaoIf;

public class PedidoDao implements PedidoDaoIf {

    private String username;
    private String url;
    private String password;
    private Connection con;

    public PedidoDao() throws ClassNotFoundException, SQLException {
        this.username = "postgres";
        this.password = "123";
        this.url = "jdbc:postgresql://127.0.0.1:5432/threadlove";
        this.con = ConFactory.getConnection(url, username, password);
    }

    @Override
    public boolean add(String userEmail, String userParaEmail) throws SQLException {
        String sql = "INSERT INTO pedidosAmizade VALUES(?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, userEmail);
        stmt.setString(2, userParaEmail);
        int vrf = stmt.executeUpdate();
        stmt.close();

        return vrf > 0;
    }

    @Override
    public boolean remove(String userEmail, String userParaEmail) throws SQLException {
        String sql = "DELETE FROM pedidosAmizade WHERE userEmail = '" + userEmail + "' AND userParaEmail = '" + userParaEmail + "'";
        PreparedStatement stmt = con.prepareStatement(sql);
        int vrf = stmt.executeUpdate();
        stmt.close();

        return vrf > 0;
    }

    @Override
    public List<Pedido> listAll() throws SQLException {
        String sql = "SELECT * FROM pedidosAmizade";
        PreparedStatement stmt = con.prepareStatement(sql);
        List<Pedido> lista = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Pedido p = new Pedido();
            p.setUserEmail(rs.getString(1));
            p.setUserParaEmail(rs.getString(2));
            lista.add(p);
        }
        stmt.close();
        rs.close();

        return lista;
    }

    @Override
    public void closeConexao() throws SQLException {
        con.close();
    }

    @Override
    public List<Pedido> listAll(String email) throws SQLException {
            String sql = "SELECT * FROM pedidosAmizade where userParaEmail='"+email+"'";
        PreparedStatement stmt = con.prepareStatement(sql);
        List<Pedido> lista = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Pedido p = new Pedido();
            p.setUserEmail(rs.getString(1));
            p.setUserParaEmail(rs.getString(2));
            lista.add(p);
        }
        stmt.close();
        rs.close();

        return lista;
    }

}
