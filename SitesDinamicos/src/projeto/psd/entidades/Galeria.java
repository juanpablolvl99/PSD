package projeto.psd.entidades;

import java.io.Serializable;
import java.util.List;

public class Galeria implements Serializable{

    private String userEmail;
    private List<String> galeria;
    
    public Galeria(){} // "padrão" - nascimento, cap

    public String getUserEmail() {
        return userEmail;
    }

    public List<String> getGaleria(){
        return this.galeria;
    }
    
    public boolean addImagem(int usuarioId, String imagem){
        return this.galeria.add("/imagens/" + usuarioId + imagem);
    }
    
}
