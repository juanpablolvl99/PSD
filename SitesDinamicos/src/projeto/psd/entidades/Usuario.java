package projeto.psd.entidades;

public class Usuario {
    
    private String login;
    private String senha;
    private String nome;
    private String apelido;
    private String dataDeNascimento;
    private String cidade;
    private String email;
    private String profissao;
    private String descricao;
    private String status;
    private double altura;
    private double peso;
    private String corDoCabelo;
    private String passatempos;
    private String fotoPerfil;
    
    public Usuario(){} // "padrão" - nascimento, cap

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCorDoCabelo() {
        return corDoCabelo;
    }

    public void setCorDoCabelo(String corDoCabelo) {
        this.corDoCabelo = corDoCabelo;
    }

    public String getPassatempos() {
        return passatempos;
    }

    public void setPassatempos(String passatempos) {
        this.passatempos = passatempos;
    }
    
    
    public String getFotoPerfil(){
        return fotoPerfil;
    }
    
    public void setFotoPerfil(String imagem){
        this.fotoPerfil = "imagens/" + this.login + "/" + imagem;
    }


}
