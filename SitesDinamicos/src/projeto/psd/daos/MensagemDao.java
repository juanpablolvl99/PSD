package projeto.psd.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto.psd.entidades.Mensagem;
import projeto.psd.factorys.ConFactory;
import projeto.psd.interfaces.MensagemDaoIf;

public class MensagemDao implements MensagemDaoIf {

    private String username;
    private String password;
    private String url;
    private Connection conn;

    public MensagemDao() throws ClassNotFoundException, SQLException {
        this.username = "postgres";
        this.password = "123";
        this.url = "jdbc:postgresql://127.0.0.1:5432/threadlove";
        this.conn = ConFactory.getConnection(url, username, password);
    }

    @Override
    public boolean add(Mensagem msg) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("insert into mensagem(de, para, mensagem) values(?,?,?)");
        pstmt.setString(1, msg.getDeEmail());
        pstmt.setString(2, msg.getParaEmail());
        pstmt.setString(3, msg.getMensagem());

        int vrf = pstmt.executeUpdate();

        pstmt.close();
        
        return vrf > 0;
    }

    @Override
    public List<Mensagem> listar(String userParaEmail) throws SQLException {

        PreparedStatement pstmt = conn.prepareStatement("select * from mensagem where para = '"
                + userParaEmail + "'");

        List<Mensagem> mensagens = new ArrayList();

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Mensagem msg = new Mensagem();
            msg.setId(rs.getInt(1));
            msg.setDeEmail(rs.getString(2));
            msg.setParaEmail(rs.getString(3));
            msg.setMensagem(rs.getString(4));
            mensagens.add(msg);
        }

        pstmt.close();
        rs.close();

        return mensagens;
    }
    
    @Override
    public boolean remove(int id) throws SQLException {
        
        PreparedStatement pstmt = conn.prepareStatement("delete from mensagem where id = '" + id + "'");
        int vrf = pstmt.executeUpdate();
        
        return vrf > 0;
    }

    @Override
    public void closeConexao() throws SQLException {
        conn.close();
    }

}
