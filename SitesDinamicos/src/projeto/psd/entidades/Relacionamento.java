package projeto.psd.entidades;

import java.io.Serializable;

public class Relacionamento implements Serializable{
    
    private String userEmail;
    private String userParaEmail;
    private String status;

    public Relacionamento() {
    }

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
