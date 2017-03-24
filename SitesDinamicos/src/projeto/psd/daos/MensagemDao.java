package projeto.psd.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto.psd.factorys.ConFactory;
import projeto.psd.interfaces.MensagemDaoIf;

public class MensagemDao implements MensagemDaoIf{

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
    public boolean add(String userDeEmail, String userParaEmail, String mensagem) throws SQLException{
        PreparedStatement pstmt = conn.prepareStatement("insert into mensagem(de, para, mensagem) value(?,?,?)");
        pstmt.setString(1, userDeEmail);
        pstmt.setString(2, userParaEmail);
        pstmt.setString(3, mensagem);
        
        int vrf = pstmt.executeUpdate();
        
        pstmt.close();
        
        return vrf > 0;
    }
    
    @Override
    public List<String> listar(String userDeEmail, String userParaEmail) throws SQLException{
        
        PreparedStatement pstmt = conn.prepareStatement("select mensagem from mensagem where de = " + userDeEmail + " para = " +
        userParaEmail);
        
        List<String> mensagens = new ArrayList();
        
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            mensagens.add(rs.getString(1));
        }
        
        pstmt.close();
        rs.close();
        
        return mensagens;
    }

}