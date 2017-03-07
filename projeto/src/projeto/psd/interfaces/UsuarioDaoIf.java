
package projeto.psd.interfaces;

import java.util.List;
import projeto.psd.entidades.Usuario;

public interface UsuarioDaoIf {
    
    public void add(Usuario u);
    public void remove(String login, String senha);
    public void update(Usuario u);
    public List<Usuario> listAll();
    
}
