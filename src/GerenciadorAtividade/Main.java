package GerenciadorAtividade;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var s = new Scanner(System.in);
        var gerenciador = new GerenciadorTarefas(0, "", "", "", "");


        int escolha = 0;
        while (escolha != 7) {
            System.out.println("""
                    \n=-=-=-=-=-=-=-=-=-=-
                    [1] Adicionar tarefa.
                    [2] Editar tarefa.
                    [3] Remover tarefa.
                    [4] Listar tarefa.
                    [5] Filtrar por status.
                    [6] Gerar relatório.
                    [7] Sair.
                    =-=-=-=-=-=-=-=-=-=-""");
            escolha = s.nextInt();
            switch (escolha) {
                case 1: {
                    var rand = new Random();

                    rand.nextInt(100, 600);
                    Scanner sc = new Scanner(System.in);

                    System.out.println("Insira o título: ");
                    String titulo = sc.nextLine();

                    System.out.println("Insira o descricao: ");
                    String descricao = sc.nextLine();

                    System.out.println("Insira a prioridade: (baixa/média/alta)");
                    String prioridade = sc.nextLine();

                    System.out.println("Insira a categoria: ");
                    String categoria = sc.nextLine();

                    var tarefa = new Tarefa(rand.nextInt(100, 600), titulo, descricao, prioridade, categoria, "PENDENTE");
                    gerenciador.getListaTarefas().add(tarefa);
                    break;
                }

                case 2: {
                    System.out.println("Insira o ID da tarefa que será editada: ");
                    int id = s.nextInt();

                    System.out.println("""
                            Selecione o que deseja editar
                            =-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                            [1] Titulo
                            [2] Descrição
                            [3] Prioridade
                            [4] Categoria
                            [5] Status
                            =-=-=-=-=-=-=-=-=-=-=-=-=-=-=""");
                    int opcao = s.nextInt();
                    s.nextLine();


                    for (Tarefa tarefa : gerenciador.getListaTarefas()) {
                        if (tarefa.getId() == id) {

                            switch (opcao) {
                                case 1: {
                                    System.out.println("Digite o novo título:");
                                    tarefa.setTitulo(s.nextLine());
                                    break;
                                }

                                case 2: {
                                    System.out.println("Digite a nova descricao:");
                                    tarefa.setDescricao(s.nextLine());
                                    break;
                                }
                                case 3: {
                                    System.out.println("Digite a nova prioridade:");
                                    tarefa.setPrioridade(s.nextLine());
                                    break;
                                }
                                case 4: {
                                    System.out.println("Digite a nova categoria:");
                                    tarefa.setCategoria(s.nextLine());
                                    break;
                                }
                                case 5: {
                                    System.out.println("Digite o novo status:");
                                    tarefa.setStatus(s.nextLine());
                                    break;
                                }
                                default: {
                                    System.out.println("opção inválida");
                                }
                                System.out.println("Tarefa editada com sucesso!");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Insira o ID da tarefa que será removida: ");
                    int id = s.nextInt();

                    Iterator<Tarefa> it = gerenciador.getListaTarefas().iterator();
                    boolean removido = false;

                    while (it.hasNext()) {
                        Tarefa tarefa = it.next();
                        if (id == tarefa.getId()) {
                            it.remove();
                            removido = true;
                            System.out.println("Tarefa removida com sucesso!");
                            break;
                        }
                    }
                    if (!removido) {
                        System.out.println("Nenhuma tarefa encontrada com esse ID.");
                    }
                    break;
                }

                case 4: {
                    System.out.println("""
                            =-=-=-=-=-=-=-=-=-=-=-=-
                            [1] Buscar por título.
                            [2] Buscar por descrição.
                            [3] Buscar por categoria.
                            [4] Buscar por prioridade.
                            [5] Buscar por ID.
                            =-=-=-=-=-=-=-=-=-=-=-=-""");
                    int buscar = s.nextInt();
                    s.nextLine();

                    switch (buscar) {
                        case 1: {
                            System.out.println("Digite o titulo: ");
                            String tituloBusca = s.nextLine();
                            boolean encontrado = false;

                            for (Tarefa tarefa : gerenciador.getListaTarefas()) {
                                if (tarefa.getTitulo().equalsIgnoreCase(tituloBusca)) {
                                    System.out.println(tarefa);
                                    encontrado = true;
                                }
                            }
                            if (!encontrado){
                                System.out.println("Valor inválido. Digite novamente.");
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Digite a descrição: ");
                            String descricaoBusca = s.nextLine();
                            boolean encontrado = false;

                            for (Tarefa tarefa : gerenciador.getListaTarefas()) {
                                if (tarefa.getDescricao().equalsIgnoreCase(descricaoBusca)) {
                                    System.out.println(tarefa);
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("Valor inválido. Digite novamente.");
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Digite a categoria: ");
                            String categoria = s.nextLine();
                            boolean encontrado = false;

                            for (var tarefa : gerenciador.getListaTarefas()) {
                                if (tarefa.getCategoria().equalsIgnoreCase(categoria)) {
                                    System.out.println(tarefa);
                                    encontrado = true;
                                }
                                if (!encontrado) {
                                    System.out.println("Valor inválido. Digite novamente.");
                                }
                                break;
                            }

                            break;
                        }
                        case 4: {
                            System.out.println("Digite a prioridade: ");
                            String prioridade = s.nextLine();
                            boolean encontrado = false;

                            for (var tarefa : gerenciador.getListaTarefas()) {
                                if (tarefa.getPrioridade().equalsIgnoreCase(prioridade)) {
                                    System.out.println(tarefa);
                                    encontrado = true;
                                }
                                if (!encontrado) {
                                    System.out.println("Valor inválido. Digite novamente.");
                                }
                            }
                            break;
                        }
                        case 5: {
                            System.out.println("Digite o ID: ");
                            int id = s.nextInt();
                            boolean encontrado = false;

                            for (var tarefa : gerenciador.getListaTarefas()) {
                                if (tarefa.getId() == id) {
                                    System.out.println(tarefa);
                                    encontrado = true;
                                }
                                if (!encontrado) {
                                    System.out.println("Valor inválido. Digite novamente.");
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Selecione o filtro");
                    System.out.println("""
                            =-=-=-=-=-=-=-=-=-=-=-=-
                            [1] PENDENTE
                            [2] EM ANDAMENTO
                            [3] CONCLUÍDO
                            [4] CANCELADO
                            =-=-=-=-=-=-=-=-=-=-=-=-""");

                    int filtro = s.nextInt();
                    s.nextLine();
                    boolean encontrado = false;

                    switch (filtro) {
                        case 1: {
                            for (var tarefa : gerenciador.getListaTarefas()) {
                                if (tarefa.getStatus().equalsIgnoreCase("PENDENTE")){
                                    encontrado = true;
                                    System.out.println(tarefa);
                                }
                            }
                            break;
                        }
                        case 2: {
                            for (var tarefa : gerenciador.getListaTarefas()) {
                                if (tarefa.getStatus().equalsIgnoreCase("EM ANDAMENTO")){
                                    encontrado = true;
                                    System.out.println(tarefa);
                                }
                            }
                            break;
                        }
                        case 3: {
                            for (var tarefa : gerenciador.getListaTarefas()) {
                                if (tarefa.getStatus().equalsIgnoreCase("CONCLUÍDO")){
                                    encontrado = true;
                                    System.out.println(tarefa);
                                }
                            }
                            break;
                        }
                        case 4: {
                            for (var tarefa : gerenciador.getListaTarefas()) {
                                if (tarefa.getStatus().equalsIgnoreCase("CANCELADO")){
                                    encontrado = true;
                                    System.out.println(tarefa);
                                }
                            }
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Não há tarefas com esse status. Tente novamente.");
                    }
                    break;
                }
                case 6: {
                    System.out.println(gerenciador.getListaTarefas());
                    break;
                }
                case 7: {
                    System.out.println("Saindo...");
                    break;
                }
                default: {
                    System.out.println("Valor não encontrado. Digite novamente.");
                }
            }
        }
    }
}
