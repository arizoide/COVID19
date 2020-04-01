package thomazini.com.br.covid_19.model;

public class Paciente {
    private Integer id;
    private String nome;
    private Integer idade;
    private String cidade;
    private String estado;

    public Paciente(String nome, Integer idade, String cidade, String estado) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Paciente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
