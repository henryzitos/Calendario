import Acontecimentos.*;
import java.util.*;

public class Agenda extends Funcoes {
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
        String auxt;
        int opc, aux;

        System.out.println("- Visualizar eventos ");
        System.out.println(" Selecione uma opção:");
        System.out.println("1 - Procura por data.");
        System.out.println("2 - Procura por dia. ");
        System.out.println("3 - Procura por mês. ");
        System.out.println("4 - Procura por ano. ");
        System.out.println("5 - Voltar ao menu.  ");
        opc = sc.nextInt();

        while (opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5){
            System.out.println("Digite uma opção válida!");
            opc = sc.nextInt();
        }

        switch(opc){
            case 1:
                System.out.println("| Digite a data (dd/mm/yyyy): ");
                sc.nextLine();
                auxt = sc.nextLine().trim();
                System.out.println("| * Eventos");
                for(Evento evento: listaEventos){
                    if (auxt == evento.getDataInicio()) {
                        System.out.println("| + " + evento.getNome());
                        System.out.println("| Começa às: " + evento.getHorarioInicio());
                        System.out.println("| Termina no dia: " + evento.getDataFim() + " às: " + evento.getHorarioFim());
                        System.out.println("|");
                    } else if (auxt == evento.getDataFim()) {
                        System.out.println("| + " + evento.getNome());
                        System.out.println("| Começa no dia: " + evento.getDataInicio() + " às: " + evento.getHorarioInicio());
                        System.out.println("| Termina às" + evento.getHorarioFim());
                        System.out.println("|");
                    }
                }

                System.out.println("| * Lembretes");
                for (Lembrete lembrete: listaLembretes) {
                    if(auxt == lembrete.getData()){
                        System.out.println("| + " + lembrete.getNome());
                        System.out.println("| Está marcado para: " + lembrete.getHorario());
                        System.out.println("|");
                    }
                }

                System.out.println("| * Tarefas");
                for (Tarefa tarefa: listaTarefas) {
                    if(auxt.equals(tarefa.getData())){
                        System.out.println("| + " + tarefa.getNome());
                        System.out.println("|");
                    }
                }
                visuEventos();
                break;

            case 2:
                System.out.println("| Digite o dia: ");
                aux = sc.nextInt();
                //Adicionar função para percorrer as listas baseada no dia
                visuEventos();
                break;

            case 3:
                System.out.println("| Digite o mês: ");
                aux = sc.nextInt();
                //Adicionar função para percorrer as listas baseada no mês
                visuEventos();
                break;

            case 4:
                System.out.println("| Digite o ano: ");
                aux = sc.nextInt();
                //Adicionar função para percorrer as listas baseada no ano
                visuEventos();
                break;

            case 5:
                menu();
        }
    }

    public static void criarEvento() {
        int in;
        System.out.println("|----------------------------------------|");
        System.out.println("|              Criar evento              |");
        System.out.println("| *      Escolha o tipo de evento:     * |");
        System.out.println("| 1 - Evento | 2 - Lembrete | 3 - Tarefa |");
        System.out.printf("| 4 - Voltar para menu. -------------->  ");
        in = sc.nextInt();

        while (in != 1 && in != 2 && in != 3 && in != 4){
            System.out.println("* -------------------------------------- *");
            System.out.println("|   Digite uma opção válida, por favor   |");
            System.out.printf("| ------------------------------------>  ");
            in = sc.nextInt();
        }

        switch (in){
//Marcador
            case 1:
                int auxE = 0;
                int diaEF, mesEF, anoEF;
                System.out.println("* -------------------------------------- *");

                System.out.println("| - Digite o nome do Evento: ");
                sc.nextLine();
                String nomeE = sc.nextLine();
                int diaE = Dia(auxE);

                int mesE = Mes(auxE);
                if (mesE == 2 && diaE > 29){
                    System.out.println("| * Fevereiro tem apenas 28 ou 29 dias. Por favor corrija.");
                    diaE = Dia(auxE);
                    if (diaE > 29){
                       while (diaE > 29){
                           System.out.printf("| * Digite um dia válido. ->");
                           diaE = Dia(auxE);
                       }
                    }
                } else if (mesE == 4 || mesE == 6 || mesE == 9 || mesE == 11 && diaE > 30){
                    System.out.println("| * Seu mês tem 30 dias. Por favor corrija.");
                    diaE = Dia(auxE);
                    if (diaE > 30){
                        while (diaE > 30){
                            System.out.printf("| * Digite um dia válido. ->");
                            diaE = Dia(auxE);
                        }
                    }
                }

                int anoE = Ano(auxE);

                char opc;
                System.out.println("| - A data do fim do evento é a mesma? Digite S para Sim");
                opc = sc.next().charAt(0);
                if(opc == 'S'){
                    diaEF = diaE;
                    mesEF = mesE;
                    anoEF = anoE;
                } else {
                    diaEF = Dia(auxE);
                    mesEF = Mes(auxE);
                    if (mesEF == 2 && diaEF > 29){
                        System.out.println("| * Fevereiro tem apenas 28 ou 29 dias, por favor corrija.");
                        diaEF = Dia(auxE);
                        if (diaEF > 29){
                            while (diaEF > 29){
                                System.out.printf("| * Digite um dia válido. ->");
                                diaEF = Dia(auxE);
                            }
                        }
                    } else if (mesEF == 4 || mesEF == 6 || mesEF == 9 || mesEF == 11 && diaEF > 30){
                        System.out.println("| * Seu mês tem 30 dias. Por favor corrija.");
                        diaEF = Dia(auxE);
                        if (diaEF > 30){
                            while (diaEF > 30){
                                System.out.printf("| * Digite um dia válido. ->");
                                diaEF = Dia(auxE);
                            }
                        }
                    }
                    anoEF = Ano(auxE);
                }

                System.out.println("| - Horário de início");
                int horaI = Hora(auxE);
                int minutoI = Minuto(auxE);

                System.out.println("| - Horário de fim");
                int horaF = Hora(auxE);
                int minutoF = Minuto(auxE);

                Evento evento = new Evento(nomeE, diaE, mesE, anoE, diaEF, mesEF, anoEF, horaI, minutoI, horaF, minutoF);
                listaEventos.add(evento);

                System.out.println("| * Evento criado com sucesso!");
                System.out.println("* -------------------------------------- *");
                criarEvento();
                break;
//Marcador
            case 2:
                int auxL = 0;
                System.out.println("* -------------------------------------- *");
                System.out.println("| - Digite o nome do Lembrete:");
                sc.nextLine();
                String nomeL = sc.nextLine();

                int diaL = Dia(auxL);
                int mesL = Mes(auxL);
                if (mesL == 2 && diaL > 29){
                    System.out.println("| * Fevereiro tem apenas 28 ou 29 dias, por favor corrija.");
                    diaL = Dia(auxL);
                    if (diaL > 29){
                        while (diaL > 29){
                            System.out.printf("| * Digite um dia válido. ->");
                            diaL = Dia(auxL);
                        }
                    }
                } else if (mesL == 4 || mesL == 6 || mesL == 9 || mesL == 11 && diaL > 30){
                    System.out.println("| * Seu mês tem 30 dias. Por favor corrija.");
                    diaL = Dia(auxL);
                    if (diaL > 30){
                        while (diaL > 30){
                            System.out.printf("| * Digite um dia válido. ->");
                            diaL = Dia(auxL);
                        }
                    }
                }
                int anoL = Ano(auxL);
                int horaL = Hora(auxL);
                int minutoL = Minuto(auxL);

                Lembrete lembrete = new Lembrete(nomeL, diaL, mesL, anoL, horaL, minutoL);
                listaLembretes.add(lembrete);

                System.out.println("| * Lembrete criado com sucesso!");
                System.out.println("* -------------------------------------- *");
                criarEvento();
                break;
//Marcador
            case 3:
                int auxT = 0;
                System.out.println("* -------------------------------------- *");
                System.out.println("| - Digite o nome da Tarefa: ");
                sc.nextLine();
                String nomeT = sc.nextLine();

                int diaT = Dia(auxT);
                int mesT = Mes(auxT);
                if (mesT == 2 && diaT > 29){
                    System.out.println("| * Fevereiro tem apenas 28 ou 29 dias, por favor corrija.");
                    diaT = Dia(auxT);
                    if (diaT > 29){
                        while (diaT > 29){
                            System.out.printf("| * Digite um dia válido. ->");
                            diaT = Dia(auxT);
                        }
                    }
                } else if (mesT == 4 || mesT == 6 || mesT == 9 || mesT == 11 && diaT > 30){
                    System.out.println("| * Seu mês tem 30 dias. Por favor corrija.");
                    diaT = Dia(auxT);
                    if (diaT > 30){
                        while (diaT > 30){
                            System.out.printf("| * Digite um dia válido. ->");
                            diaT = Dia(auxT);
                        }
                    }
                }
                int anoT = Ano(auxT);

                Tarefa tarefa = new Tarefa(nomeT, diaT, mesT, anoT);
                listaTarefas.add(tarefa);

                System.out.println("| * Tarefa criada com sucesso!");
                System.out.println("* -------------------------------------- *");
                criarEvento();
                break;
//Marcador
            case 4:
                System.out.println("* -------------------------------------- *");
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
