package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projeto.psd.entidades.Amizade;
import projeto.psd.entidades.Recomendacao;
import projeto.psd.gerenciadores.GerenciadorAmizade;
import projeto.psd.gerenciadores.GerenciadorRecom;
import projeto.psd.interfaces.Command;

public class RecomendarController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        boolean condicao = true;

        String emailRecomendado = req.getParameter("emailRecomendado");
        String emailPara = req.getParameter("emailPara");
        String userEmail;

        List<Recomendacao> listaRec;
        List<Amizade> listAmz;
        
        HttpSession sessao = req.getSession(false);

        synchronized (sessao) {
            userEmail = (String) sessao.getAttribute("emailUsuario");
        }

        Recomendacao rec = new Recomendacao();

        rec.setParaEmail(emailPara);
        rec.setRecomendadoEmail(emailRecomendado);
        rec.setUserEmail(userEmail);

        
        GerenciadorRecom gr = new GerenciadorRecom();
        
        //Verifica se ja existe essa recomendacao no banco, caso sim, nao sera persistido a recomendacao
        listaRec = gr.listAll(emailPara);

        for (Recomendacao reco : listaRec) {
            if (reco.getRecomendadoEmail().equals(rec.getRecomendadoEmail())
                    && reco.getParaEmail().equals(rec.getParaEmail())) {
                condicao = false;
            }
        }
        //fim
        
        GerenciadorAmizade ga = new GerenciadorAmizade(); //guardian angel
        
        //Verifica se na recomendacao os usuarios ja sao amigos, caso sim, nao sera persistido a recomendacao
        listAmz = ga.listAll(emailPara);
        
        for (Amizade amizade : listAmz) {    
            if(amizade.getUserEmail().equals(emailPara)){
            
                if(amizade.getAmigoEmail().equals(emailRecomendado))
                    condicao = false;
           
            }else{
                
                if(amizade.getUserEmail().equals(emailRecomendado))
                    condicao = false;
            
            }               
        }
        
        if(condicao){
            if(gr.add(rec)){    
                gr.closeConexao();
                res.sendRedirect("Inicial.jsp");
            }else{
                gr.closeConexao();
                res.sendError(333);
            }
        }else{
            res.sendRedirect("Inicial.jsp");            
        }    
   
    }

}
