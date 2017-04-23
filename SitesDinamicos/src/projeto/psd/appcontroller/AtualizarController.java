package projeto.psd.appcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;
import projeto.psd.interfaces.Command;

public class AtualizarController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException,
            ServletException {

        HttpSession session = req.getSession(false);
        
        GerenciadorUsuario ger = new GerenciadorUsuario();
        Usuario user = new Usuario();
        user.setLogin((String)session.getAttribute("loginUsuario"));
        user.setNome(req.getParameter("nome"));
        user.setApelido(req.getParameter("apelido"));
        user.setCidade(req.getParameter("cidade"));
        user.setCorDoCabelo(req.getParameter("corDoCabelo"));
        user.setDataDeNascimento(req.getParameter("dataDeNascimento"));
        user.setDescricao(req.getParameter("descricao"));
        user.setEmail(req.getParameter("email"));
        user.setPassatempos(req.getParameter("passatempos"));
        user.setProfissao(req.getParameter("profissao"));
        user.setStatus(req.getParameter("status"));
        user.setSenha(req.getParameter("senha"));

        String path = req.getServletContext().getRealPath("");
        List<Part> parts = (List) req.getParts();
        for (Part part : parts) {
            switch(part.getName()){
                case "altura":
                    user.setAltura(Double.parseDouble(getValue(part)));
                    break;
                case "peso":
                    user.setPeso(Double.parseDouble(getValue(part)));
                    break;
                case "fotoPerfil":
                    String imgPath = "imagens" + '/' + user.getLogin() + '/' + part.getSubmittedFileName();
                    user.setFotoPerfil(imgPath);
                    part.write(path + imgPath);
                    break;
            }
        }
        
        if(ger.update(user)){
            synchronized(session){
                session.setAttribute("dadosUsu", user);
            }
            ger.closeConexao();
            res.sendRedirect(res.encodeRedirectURL("Inicial.jsp"));
        }else{
            ger.closeConexao();
            res.sendRedirect("AtualizarDados.jsp");
        }

    }
    
    private String getValue(Part part) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(part.getInputStream()))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

}
