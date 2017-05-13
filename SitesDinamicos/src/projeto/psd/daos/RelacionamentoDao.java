package projeto.psd.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto.psd.entidades.Relacionamento;
import projeto.psd.factorys.ConFactory;
import projeto.psd.interfaces.RelacionamentoDaoIf;

public class RelacionamentoDao implements RelacionamentoDaoIf {

    private String username;
    private String url;
    private String password;
    private Connection con;

    public RelacionamentoDao() throws ClassNotFoundException, SQLException {
        this.username = "postgres";
        this.password = "123";
        this.url = "jdbc:postgresql://127.0.0.1:5432/threadlove";
        this.con = ConFactory.getConnection(url, username, password);
    }

    @Override
    public boolean add(Relacionamento r) throws SQLException {
        String sql = "INSERT INTO relacionamento VALUES(?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, r.getUserEmail());
        stmt.setString(2, r.getUserParaEmail());
        stmt.setString(3, r.getStatus());
        int vrf = stmt.executeUpdate();
        stmt.close();
        return vrf > 0;
    }

    @Override
    public boolean remove(String userEmail, String userPara) throws SQLException {
        String sql = "DELETE FROM relacionamento WHERE userEmail = ? AND userParaEmail = ? OR userEmail = ? AND userParaEmail = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, userEmail);
        stmt.setString(2, userPara);
        stmt.setString(3, userPara);
        stmt.setString(4, userEmail);
        int vrf = stmt.executeUpdate();
        
        sql = "update usuario set status = 'Solteiro' where email = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, userEmail);
        stmt.executeUpdate();
        
        stmt.setString(1, userPara);
        stmt.executeUpdate();
        
        stmt.close();
        return vrf > 0;

    }

    @Override
    public Relacionamento retornaRelac(String email) throws SQLException {
        String sql = "SELECT * FROM relacionamento WHERE userEmail = ? OR userParaEmail = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, email);
        ResultSet rs = stmt.executeQuery();
        Relacionamento r = new Relacionamento();
        if (rs.next()) {
            r.setUserEmail(rs.getString("userEmail"));
            r.setUserParaEmail(rs.getString("userParaEmail"));
            r.setStatus(rs.getString("status"));
        }
        return r;
    }
    
    @Override
    public boolean verificaRelacionamento(String email, String paraEmail) throws SQLException {
        String sql = "SELECT * FROM relacionamento WHERE userEmail = ? and userParaEmail = ? or userEmail = ? and userParaEmail = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, paraEmail);
        stmt.setString(3, paraEmail);
        stmt.setString(4, email);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            return true;
        }
        stmt.close();
        rs.close();
        return false;
    }

    @Override
    public void closeConexao() throws SQLException {
        this.con.close();
    }

}
