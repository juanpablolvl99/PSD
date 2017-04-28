package projeto.psd.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto.psd.entidades.Amizade;
import projeto.psd.factorys.ConFactory;
import projeto.psd.interfaces.AmizadeDaoIf;

public class AmizadeDao implements AmizadeDaoIf {

    private String username;
    private String password;
    private String url;
    private Connection con;

    public AmizadeDao() throws ClassNotFoundException, SQLException {
        this.username = "postgres";
        this.password = "123";
        this.url = "jdbc:postgresql://127.0.0.1:5432/threadlove";
        this.con = ConFactory.getConnection(url, username, password);
    }

    @Override
    public boolean add(String userEmail, String amigoEmail) throws SQLException {
        String sql = "INSERT INTO amizade VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, userEmail);
        stmt.setString(2, amigoEmail);
        int vrf = stmt.executeUpdate();
        stmt.close();
        return vrf > 0;
    }

    @Override
    public boolean remove(String userEmail, String amigoEmail) throws SQLException {
        String sql = "DELETE FROM amizade WHERE usuario = '" + userEmail + "' AND amigo = '" + amigoEmail + "' or"
                + " usuario = '" + amigoEmail + "' AND amigo = '" + userEmail + "'";
        PreparedStatement stmt = con.prepareStatement(sql);
        int vrf = stmt.executeUpdate();
        stmt.close();

        return vrf > 0;
    }

    @Override
    public List<Amizade> listAll(String email) throws SQLException {
        String sql = "SELECT * FROM amizade where usuario = '"+email+"' or amigo='"+email+"'";
        PreparedStatement stmt = con.prepareStatement(sql);

        List<Amizade> lista = new ArrayList<Amizade>();
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Amizade a = new Amizade();
            a.setUserEmail(rs.getString(1));
            a.setAmigoEmail(rs.getString(2));
            lista.add(a);
        }
        stmt.close();
        rs.close();

        return lista;
    }

    @Override
    public List<Amizade> listAll() throws SQLException {
        String sql = "SELECT * FROM amizade";
        PreparedStatement stmt = con.prepareStatement(sql);

        List<Amizade> lista = new ArrayList<Amizade>();
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Amizade a = new Amizade();
            a.setUserEmail(rs.getString(1));
            a.setAmigoEmail(rs.getString(2));
            lista.add(a);
        }
        stmt.close();
        rs.close();

        return lista;
    }

    @Override
    public void closeConexao() throws SQLException {
        this.con.close();
    }

}
