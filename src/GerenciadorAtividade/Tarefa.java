package GerenciadorAtividade;

public class Tarefa {
    protected int id;
    protected String titulo;
    protected String descricao;
    protected String status;
    protected String prioridade;
    protected String categoria;


    public Tarefa(int id, String titulo, String descricao, String prioridade, String categoria, String status){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }



    @Override
    public String toString() {
        return  "\n Id: "+this.id+
                "\n Titulo: "+this.titulo+
                "\n Descrição: "+this.descricao+
                "\n Prioridade: "+this.prioridade+
                "\n Categoria: "+this.categoria+
                "\n Status: "+this.status+ "\n";
    }
}
