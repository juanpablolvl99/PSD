
package projeto.psd.entidades;

import java.io.Serializable;

public class Pedido implements Serializable{
    
    private String userEmail;
    private String userParaEmail;
    private String status;
    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
