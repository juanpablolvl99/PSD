    package projeto.psd.entidades;

public class Recomendacao {
    
    private String userEmail, recomendadoEmail, paraEmail;

    public Recomendacao(){}; // "padrão" - nascimento, cap
    
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRecomendadoEmail() {
        return recomendadoEmail;
    }

    public void setRecomendadoEmail(String recomendadoEmail) {
        this.recomendadoEmail = recomendadoEmail;
    }

    public String getParaEmail() {
        return paraEmail;
    }

    public void setParaEmail(String paraEmail) {
        this.paraEmail = paraEmail;
    }
    
}
