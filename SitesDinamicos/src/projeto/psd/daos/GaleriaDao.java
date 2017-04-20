package projeto.psd.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import projeto.psd.factorys.ConFactory;
import projeto.psd.interfaces.GaleriaDaoIf;

public class GaleriaDao implements GaleriaDaoIf{
    
    private String user;
    private String password;
    private String url;
    private Connection conn;
    
    public GaleriaDao() throws ClassNotFoundException, SQLException{
        this.user = "postgres";
        this.password = "123";
        this.url = "jdbc:postgresql://127.0.0.1:5432/threadlove";
        this.conn = ConFactory.getConnection(url, user, password);
    }

    @Override
    public boolean add(String userEmail, String imagem, Date data) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("insert into galeria values(?, ?, ?)");
        pstmt.setString(1, userEmail);
        pstmt.setString(2, imagem);
        pstmt.setDate(3, data);
        
        int vrf = pstmt.executeUpdate();
        
        pstmt.close();
        
        return vrf > 0;
    }

    @Override
    public boolean delete(String userEmail, String imagem) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("delete from galeria where email = " + userEmail + " and foto = " + imagem);
        
        int vrf = pstmt.executeUpdate();
        
        pstmt.close();
        
        return vrf > 0;        
    }

    @Override
    public List<String> listar(String userEmail) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("select foto from galeria where email = ?");
        
        List<String> lista = new ArrayList();
        
        pstmt.setString(1, userEmail);
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            lista.add(rs.getString(1));
        }
        
        pstmt.close();
        rs.close();
        
        return lista;
    }
    
    @Override
    public List<String> getDatas(String userEmail) throws SQLException{
        List<String> datas = new ArrayList<>();
        
        PreparedStatement pstmt = conn.prepareStatement("select datavalue from galeria where email = ?");
        pstmt.setString(1, userEmail);
        
        ResultSet rs = pstmt.executeQuery();
        
        String data;
        DateFormat df = DateFormat.getDateInstance();
        
        while(rs.next()){
            data = df.format(rs.getDate(1));
            datas.add(data);
        }
        
        return datas;
    }
    
}
