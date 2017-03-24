package projeto.psd.entidades;

public class Mensagem {
    
    private String deEmail;
    private String paraEmail;
    private String menssgem;
    
    public Mensagem(){} // "padrão" - nascimento, cap
    
    public String getDeEmail(){
        return this.deEmail;
    }
    
    public void setDeEmail(String email){
        this.deEmail = email;
    }
    
    public String getParaEmail(){
        return this.paraEmail;
    }
    
    public void setParaEmail(String email){
        this.paraEmail = email;
    }
    
    public String getMensagem(){
        return this.menssgem;
    }
    
    public void setMensagem(String mensagem){
        this.menssgem = mensagem;
    }
    
}
