package projeto.psd.entidades;

public class Amizade {
 
    private String userEmail;
    private String amigoEmail;
    
    public Amizade(){} // "padrão" - nascimento, cap

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAmigoEmail() {
        return amigoEmail;
    }
    
    public void setAmigoEmail(String amigoEmail) {
        this.amigoEmail = amigoEmail;
    }

}
