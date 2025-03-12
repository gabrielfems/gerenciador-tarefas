package GerenciadorAtividade;

import java.util.ArrayList;
import java.util.List;


public class GerenciadorTarefas implements Comparable<GerenciadorTarefas>{
    public List<Tarefa> listaTarefas;



    public GerenciadorTarefas(int id, String titulo, String descricao, String prioridade, String categoria){
        this.listaTarefas = new ArrayList<>();

    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }


    @Override
    public int compareTo(GerenciadorTarefas o) {
        return 0;
    }
}
