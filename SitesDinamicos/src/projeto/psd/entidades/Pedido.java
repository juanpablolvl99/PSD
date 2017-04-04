
package projeto.psd.entidades;

import java.io.Serializable;

public class Pedido implements Serializable{
    
    private String userEmail;
    private String userParaEmail;
    
    public Pedido(){}; // "padrão" - nascimento, cap

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserParaEmail() {
        return userParaEmail;
    }

    public void setUserParaEmail(String userParaEmail) {
        this.userParaEmail = userParaEmail;
    }
    
    
    
}
