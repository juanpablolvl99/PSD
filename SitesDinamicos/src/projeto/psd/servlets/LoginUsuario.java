package projeto.psd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;

public class LoginUsuario extends HttpServlet{
    
    @Override
    public void init (ServletConfig config) throws ServletException{
        super.init(config);
        log("Servlet Iniciado");
    }
    
    @Override
    public void destroy(){
        super.destroy();
        log("Servlet Finalizado");
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html; charset=UTF-8");
        
        PrintWriter pw = resp.getWriter();
        
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        GerenciadorUsuario ger;
        List<Usuario> lista;
        Usuario auxiliar = new Usuario();
        HttpSession sessao = req.getSession(true);
        
        try {
            ger = new GerenciadorUsuario();
            lista = ger.listAll();
            boolean condicao = false;
            
            for (Usuario u: lista){
                if(u.getLogin().equals(login) && u.getSenha().equals(senha)){
                    auxiliar.setNome(u.getNome());
                    auxiliar.setApelido(u.getApelido());
                    auxiliar.setDataDeNascimento(u.getDataDeNascimento());
                    auxiliar.setCidade(u.getCidade());
                    auxiliar.setEmail(u.getEmail());
                    auxiliar.setProfissao(u.getProfissao());
                    auxiliar.setDescricao(u.getDescricao());
                    auxiliar.setStatus(u.getStatus());
                    auxiliar.setAltura(u.getAltura());
                    auxiliar.setPeso(u.getPeso());
                    auxiliar.setCorDoCabelo(u.getCorDoCabelo());
                    auxiliar.setPassatempos(u.getPassatempos());
                    auxiliar.setFotoPerfil(u.getFotoPerfil());
                    condicao = true;
                    break;
                }
            }
            if (condicao){
                synchronized(sessao){
                    sessao.setAttribute("emailUsuario", auxiliar.getEmail());
                    sessao.setAttribute("loginUsuario", login);
                    sessao.setAttribute("senhaUsuario", senha);
                    sessao.setAttribute("dadosUsu", auxiliar);
                }
                String url = resp.encodeRedirectURL("inicial.jsp");
                resp.sendRedirect(url);
            } else {
                resp.sendRedirect("index.htm");
            }
        } catch (ClassNotFoundException ex) {
            pw.print(ex.getMessage());
        } catch (SQLException ex) {
            pw.print(ex.getMessage());
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        
    }
    
}
