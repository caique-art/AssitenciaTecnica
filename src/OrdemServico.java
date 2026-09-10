public class OrdemServico {
    private String nome;
    private String cpf;
    private int telefone;
    private String produto;
    private String marca;
    private String modelo;
    private String defeito;
    private String status;


    public OrdemServico (String nome, String cpf,int telefone, String produto, String marca, String modelo, String defeito, String status){
        this.nome=nome;
        this.cpf=cpf;
        this.telefone=telefone;
        this.produto=produto;
        this.marca=marca;
        this.modelo=modelo;
        this.defeito=defeito;
        this.status=status;
    }
    public OrdemServico ( String produto, String marca, String modelo, String defeito, String status){
        this.produto=produto;
        this.marca=marca;
        this.modelo=modelo;
        this.defeito=defeito;
        this.status=status;
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
