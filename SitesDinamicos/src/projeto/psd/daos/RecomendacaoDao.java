package projeto.psd.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto.psd.entidades.Recomendacao;
import projeto.psd.factorys.ConFactory;
import projeto.psd.interfaces.RecomendacaoDaoIf;

public class RecomendacaoDao implements RecomendacaoDaoIf{

    private Connection conn;
    
    public RecomendacaoDao() throws ClassNotFoundException, SQLException{
        conn = ConFactory.getConnection("jdbc:postgresql://127.0.0.1:5432/threadlove", "postgres", "123");
    }
    
    @Override
    public boolean add(Recomendacao rec) throws ClassNotFoundException, SQLException {
        PreparedStatement pstmt = conn.prepareStatement("insert into recomendacao values(?, ?, ?)");
        pstmt.setString(1, rec.getUserEmail());
        pstmt.setString(2, rec.getRecomendadoEmail());
        pstmt.setString(3, rec.getParaEmail());
        
        boolean vrf = pstmt.executeUpdate() > 0; 
        
        pstmt.close();
        
        return vrf;
    }
    
    @Override
    public boolean remove(String recomendadoEmail, String paraEmail) throws ClassNotFoundException, SQLException {
        PreparedStatement pstmt = conn.prepareStatement("delete from recomendacao where amigo = '"+recomendadoEmail+"' and"
                + " recomendarpara = '"+paraEmail+"'");
        
        boolean vrf = pstmt.executeUpdate() > 0;
        
        pstmt.close();
        
        return vrf;
    }

    @Override
    public List listAll(String email) throws ClassNotFoundException, SQLException {
    
        PreparedStatement pstmt = conn.prepareStatement("select * from recomendacao where recomendarpara = '"+email+"'");
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Recomendacao> lista = new ArrayList<>();
        
        while(rs.next()){
            Recomendacao rec = new Recomendacao();
            rec.setUserEmail(rs.getString(1));
            rec.setRecomendadoEmail(rs.getString(2));
            rec.setParaEmail(rs.getString(3));
            lista.add(rec);
        }
    
        return lista;
    }

    @Override
    public void closeConexao() throws SQLException {
        conn.close();
    }
    
}
