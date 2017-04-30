package projeto.psd.appcontroller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;
import projeto.psd.interfaces.Command;

public class CadastroUsuarioController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException,
            ServletException {

        Usuario usu = new Usuario();

        List<Part> lista = (List) req.getParts();
        // Sera usado para verificar se possui outro usuario com esse msm login
        String login = req.getParameter("login");

        usu.setLogin(retornaComEncode(login));
        usu.setSenha(retornaComEncode(req.getParameter("senha")));
        usu.setNome(retornaComEncode(req.getParameter("nome")));
        usu.setApelido(retornaComEncode(req.getParameter("apelido")));
        usu.setDataDeNascimento(retornaComEncode(req.getParameter("dataDeNascimento")));
        usu.setCidade(retornaComEncode(req.getParameter("cidade")));
        usu.setEmail(retornaComEncode(req.getParameter("email")));
        usu.setProfissao(retornaComEncode(req.getParameter("profissao")));
        usu.setDescricao(retornaComEncode(req.getParameter("descricao")));
        usu.setStatus(retornaComEncode(req.getParameter("status")));
        usu.setCorDoCabelo(retornaComEncode(req.getParameter("corDoCabelo")));
        usu.setPassatempos(retornaComEncode(req.getParameter("passatempos")));

        String appPath = req.getServletContext().getRealPath("");
        String uploadPath = appPath + "imagens" + File.separator + usu.getLogin();

        File uploadDirs = new File(uploadPath);

        if (!uploadDirs.exists()) {
            uploadDirs.mkdirs();
        }

        for (Part p : lista) {
            if (p.getName().equals("altura")) {
                usu.setAltura(Double.parseDouble(getValue(p)));
            }
            if (p.getName().equals("peso")) {
                usu.setPeso(Double.parseDouble(getValue(p)));
            }
            if (p.getName().equals("fotoPerfil")) {
                usu.setFotoPerfil("imagens/" + usu.getLogin() + "/" + p.getSubmittedFileName());
                p.write(uploadPath + File.separator + p.getSubmittedFileName());
            }
        }

        GerenciadorUsuario ger;

        ger = new GerenciadorUsuario();
        List<Usuario> listaUsu = ger.listAll();
        boolean verificaUsu = true;
        if (!listaUsu.isEmpty()) {
            for (Usuario auxiliar : listaUsu) {
                if (auxiliar.getLogin().equals(login) || auxiliar.getEmail().equals(req.getParameter("email"))) {
                    verificaUsu = false;
                    break;
                }
            }
        }
        if (verificaUsu) {
            ger.add(usu);
            ger.closeConexao();
            res.sendRedirect("Index.htm");
        } else {
            ger.closeConexao();
            res.getWriter().print("<script>alert('Email ja cadastrado');</script>");
            res.sendRedirect("Cadastro.htm");
        }

    }

    private String getValue(Part part) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(part.getInputStream()))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

    private String retornaComEncode(String value) throws UnsupportedEncodingException {
        return new String(value.getBytes(), "UTF-8");
    }
}
