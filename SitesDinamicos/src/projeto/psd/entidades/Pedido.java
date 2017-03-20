
package projeto.psd.entidades;

public class Pedido {
    
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
