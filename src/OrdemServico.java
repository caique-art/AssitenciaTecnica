public class OrdemServico {
    private String nome;
    private String cpf;
    private String telefone;
    private String produto;
    private String marca;
    private String modelo;
    private String defeito;
    private String status;
    private int senha;


    public OrdemServico() {
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDefeito() {
        return defeito;
    }
    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getSenha(){
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;
    }
}
