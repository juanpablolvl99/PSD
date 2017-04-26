package projeto.psd.entidades;

import java.io.Serializable;

public class Mensagem implements Serializable{
    
    private String deEmail;
    private String paraEmail;
    private String mensagem;
    private int id;
    
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
        return this.mensagem;
    }
    
    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
