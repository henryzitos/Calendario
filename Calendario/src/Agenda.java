import Acontecimentos.*;
import java.util.*;

public class Agenda {
    static Scanner sc = new Scanner(System.in);
    static List<Evento> listaEventos = new ArrayList<>();
    static List<Tarefa> listaTarefas = new ArrayList<>();
    static List<Lembrete> listaLembretes = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opc;
        System.out.println("|---------------- Agenda ----------------|");
        System.out.println("|----------------- MENU -----------------|");
        System.out.println("| 1 - Visualizar eventos                 |");
        System.out.println("| 2 - Criar evento                       |");
        System.out.println("| 3 - Editar evento                      |");
        System.out.println("| 4 - Excluir evento                     |");
        System.out.println("|----------------------------------------|");
        System.out.printf("|--------------------------------------> ");
        opc = sc.nextInt();

        while(opc != 1 && opc != 2 && opc != 3 && opc != 4) {
            System.out.println("|- Opção inválida! Digite outro número. -|");
            System.out.printf("|--------------------------------------> ");
            opc = sc.nextInt();
        }

        switch(opc){
            case 1:
                visuEventos();
                break;

            case 2:
                criarEvento();
                break;

            case 3:
                editarEvento();
                break;

            case 4:
                excluirEvento();
                break;
        }
    }

    public static void visuEventos() {
        String aux;
        System.out.println("- Visualizar evento. ");
        System.out.println(" Selecione uma opção:");
        System.out.println("1 - Procura por data.");
        System.out.println("2 - Procura por dia. ");
        System.out.println("3 - Procura por mês. ");
        System.out.println("4 - Procura por ano. ");
        System.out.println("5 - Voltar ao menu.  ");
    }

    public static void criarEvento() {
        int in;
        System.out.println("- Criar evento.");
        System.out.println("Escolha o tipo de evento: ");
        System.out.println("1 - Evento | 2 - Lembrete | 3 - Tarefa");
        System.out.printf("4 - Voltar para menu. -> ");
        in = sc.nextInt();

        while (in != 1 && in != 2 && in != 3 && in != 4){
            System.out.println("Digite uma opção válida, por favor!");
            in = sc.nextInt();
        }

        switch (in){
            case 1:
                System.out.println("Em desenvolvimento!");
                break;

            case 2:
                System.out.println("Em desenvolvimento!");
                break;

            case 3:
                System.out.println("Digite o nome do Lembrete: ");
                sc.nextLine();
                String nome = sc.nextLine();

                System.out.println("Digite o dia: ");
                int dia = sc.nextInt();
                while (dia <= 0 || dia >= 32){
                    System.out.println("Dia inválido. Coloque um dia entre 1 e 31. ->");
                    dia = sc.nextInt();
                }

                System.out.println("Digite o mês: ");
                int mes = sc.nextInt();
                while (mes <= 0 || mes >= 13){
                    System.out.println("Mês inválido. Coloque um mês entre 1 e 12. ->");
                    mes = sc.nextInt();
                }

                System.out.println("Digite o ano: ");
                int ano = sc.nextInt();
                while(ano <= 2000 || ano >= 2100) {
                    System.out.println("Nossa agenda não tem capacidade de armazenar eventos");
                    System.out.println("antes de 2000 e depois de 2100. Por favor, digite um");
                    System.out.printf("ano válido. -> ");
                    ano = sc.nextInt();
                }

                Tarefa tarefa = new Tarefa(nome, dia, mes, ano);
                listaTarefas.add(tarefa);

                System.out.println("- Tarefa criada com sucesso!");
                menu();
                break;

            case 4:
                menu();
        }
    }

    public static void editarEvento() {
        System.out.println("- Editar evento.");
    }

    public static void excluirEvento() {
        System.out.println("- Excluir evento.");
    }
}
