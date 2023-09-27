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

        while (opc != 1 && opc != 2 && opc != 3 && opc != 4) {
            System.out.println("|- Opção inválida! Digite outro número. -|");
            System.out.printf("|--------------------------------------> ");
            opc = sc.nextInt();
        }

        switch (opc) {
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

        System.out.println("|  - Visualizar eventos ");
        System.out.println("|  Selecione uma opção:");
        System.out.println("| 1 - Procura por data.");
        System.out.println("| 2 - Procura por dia. ");
        System.out.println("| 3 - Procura por mês. ");
        System.out.println("| 4 - Procura por ano. ");
        System.out.println("| 5 - Voltar ao menu.  ");
        opc = sc.nextInt();

        while (opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5) {
            System.out.println("Digite uma opção válida!");
            opc = sc.nextInt();
        }

        switch (opc) {
            case 1:
                System.out.println("| Digite a data (dd/mm/aaaa): ");
                sc.nextLine();
                auxt = sc.nextLine().trim();
                procuraData(auxt);
                break;

            case 2:
                System.out.println("| Digite o dia: ");
                aux = sc.nextInt();
                procuraDia(aux);
                visuEventos();
                break;

            case 3:
                System.out.println("| Digite o mês: ");
                aux = sc.nextInt();
                procuraMes(aux);
                visuEventos();
                break;

            case 4:
                System.out.println("| Digite o ano: ");
                aux = sc.nextInt();
                procuraAno(aux);
                visuEventos();
                break;

            case 5:
                menu();
        }
    }

    public static void procuraData(String data) {
        //Eventos
        if (listaEventos.isEmpty()) {
            System.out.println("| Não há eventos na sua agenda.");
        } else {
            boolean temEvento = false;
            System.out.println("| * Eventos");
            for (Evento e : listaEventos) {
                if (data.equals(e.getDataInicio())) {
                    System.out.println("| + " + e.getNome());
                    System.out.println("| Começa às: " + e.getHorarioInicio());
                    System.out.println("| Termina no dia: " + e.getDataFim() + " às: " + e.getHorarioFim());
                    System.out.println("|");
                    temEvento = true;
                } else if (data.equals(e.getDataFim())) {
                    System.out.println("| + " + e.getNome());
                    System.out.println("| Começa no dia: " + e.getDataInicio() + " às: " + e.getHorarioInicio());
                    System.out.println("| Termina às" + e.getHorarioFim());
                    System.out.println("|");
                    temEvento = true;
                }
            }
            if (!temEvento) {
                System.out.println("| Não há um Evento com a data digitada.");
            }
        }

        //Lembretes
        if (listaLembretes.isEmpty()) {
            System.out.println("| A lista de Lembretes está vazia.");
        } else {
            boolean temLembrete = false;
            System.out.println("| * Lembretes");
            for (Lembrete l : listaLembretes) {
                if (data.equals(l.getData())) {
                    System.out.println("| + " + l.getNome());
                    System.out.println("| Está marcado para: " + l.getHorario());
                    System.out.println("|");
                    temLembrete = true;
                    break;
                }
            }
            if (!temLembrete) {
                System.out.println("| Não há um Lembrete com a data digitada.");
            }
        }

        //Tarefas
        if (listaTarefas.isEmpty()) {
            System.out.println("| A lista de Tarefas está vazia.");
        } else {
            boolean temTarefa = false;
            System.out.println("| * Tarefas");
            for (Tarefa t : listaTarefas) {
                if (data.equals(t.getData())) {
                    System.out.println("| + " + t.getNome());
                    System.out.println("|");
                    temTarefa = true;
                    break;
                }
            }
            if (!temTarefa) {
                System.out.println("| Não há uma Tarefa com a data digitada.");
            }
        }

        visuEventos();
    }

    public static void procuraDia(int dia) {
        if (listaEventos.isEmpty()) {
            System.out.println("| Não há Eventos na sua agenda.");
        } else {
            boolean temEvento = false;
            System.out.println("| * Eventos");
            for (Evento e : listaEventos) {
                if (dia == e.getDia()) {
                    System.out.println("| + " + e.getNome());
                    System.out.println("| Começa no dia: " + e.getDataInicio() + " às: " + e.getHorarioInicio());
                    System.out.println("| Termina no dia: " + e.getDataFim() + " às: " + e.getHorarioFim());
                    System.out.println("|");
                    temEvento = true;
                }
            }
            if (!temEvento) {
                System.out.println("| Não há um Evento com o dia digitado.");
            }
        }

        if (listaLembretes.isEmpty()) {
            System.out.println("| Não há Lembretes na sua agenda.");
        } else {
            boolean temLembrete = false;
            System.out.println("| * Lembretes");
            for (Lembrete l : listaLembretes) {
                if (dia == l.getDia()) {
                    System.out.println("| + " + l.getNome());
                    System.out.println("| Data: " + l.getData());
                    System.out.println("| Horário: " + l.getHorario());
                    System.out.println("|");
                    temLembrete = true;
                    break;
                }
            }
            if (!temLembrete) {
                System.out.println("| Não há um Lembrete com o dia digitado.");
            }
        }

        if (listaTarefas.isEmpty()) {
            System.out.println("| Não há Tarefas na sua agenda.");
        } else {
            boolean temTarefa = false;
            System.out.println("| * Tarefas");
            for (Tarefa t : listaTarefas) {
                if (dia == t.getDia()) {
                    System.out.println("| + " + t.getNome());
                    System.out.println("| Dia: " + t.getData());
                    temTarefa = true;
                    break;
                }
            }
            if (!temTarefa) {
                System.out.println("| Não há uma Tarefa com o dia digitado.");
            }
        }
    }

    public static void procuraMes(int mes) {
        if (listaEventos.isEmpty()) {
            System.out.println("| Não há Eventos na sua agenda.");
        } else {
            boolean temEvento = false;
            System.out.println("| * Eventos");
            for (Evento e : listaEventos) {
                if (mes == e.getMes()) {
                    System.out.println("| + " + e.getNome());
                    System.out.println("| Começa no dia: " + e.getDataInicio() + " às: " + e.getHorarioInicio());
                    System.out.println("| Termina no dia: " + e.getDataFim() + " às: " + e.getHorarioFim());
                    System.out.println("|");
                    temEvento = true;
                }
                if (!temEvento) {
                    System.out.println("| Não há um Evento com o mês digitado.");
                }
            }

            if (listaLembretes.isEmpty()) {
                System.out.println("| Não há Lembretes na sua agenda.");
            } else {
                boolean temLembrete = false;
                System.out.println("| * Lembretes");
                for (Lembrete l : listaLembretes) {
                    if (mes == l.getMes()) {
                        System.out.println("| + " + l.getNome());
                        System.out.println("| Data: " + l.getData());
                        System.out.println("| Horário: " + l.getHorario());
                        System.out.println("|");
                        temLembrete = true;
                        break;
                    }
                }
                if (!temLembrete) {
                    System.out.println("| Não há um Lembrete com o mês digitado.");
                }
            }

            if (listaTarefas.isEmpty()) {
                System.out.println("| Não há Tarefas na sua agenda.");
            } else {
                boolean temTarefa = false;
                System.out.println("| * Tarefas");
                for (Tarefa t : listaTarefas) {
                    if (mes == t.getMes()) {
                        System.out.println("| + " + t.getNome());
                        System.out.println("| Dia: " + t.getData());
                        temTarefa = true;
                        break;
                    }
                }
                if (!temTarefa) {
                    System.out.println("| Não há uma Tarefa com o mês digitado.");
                }
            }
        }
    }

    public static void procuraAno(int ano) {
        if (listaEventos.isEmpty()) {
            System.out.println("| Não há Eventos na sua agenda.");
        } else {
            boolean temEvento = false;
            System.out.println("| * Eventos");
            for (Evento e : listaEventos) {
                if (ano == e.getAno()) {
                    System.out.println("| + " + e.getNome());
                    System.out.println("| Começa no dia: " + e.getDataInicio() + " às: " + e.getHorarioInicio());
                    System.out.println("| Termina no dia: " + e.getDataFim() + " às: " + e.getHorarioFim());
                    System.out.println("|");
                    temEvento = true;
                }
                if (!temEvento) {
                    System.out.println("| Não há um Evento com o dia digitado.");
                }
            }

            if (listaLembretes.isEmpty()) {
                System.out.println("| Não há Lembretes na sua agenda.");
            } else {
                boolean temLembrete = false;
                System.out.println("| * Lembretes");
                for (Lembrete l : listaLembretes) {
                    if (ano == l.getAno()) {
                        System.out.println("| + " + l.getNome());
                        System.out.println("| Data: " + l.getData());
                        System.out.println("| Horário: " + l.getHorario());
                        System.out.println("|");
                        temLembrete = true;
                        break;
                    }
                }
                if (!temLembrete) {
                    System.out.println("| Não há um Lembrete com o dia digitado.");
                }
            }

            if (listaTarefas.isEmpty()) {
                System.out.println("| Não há Tarefas na sua agenda.");
            } else {
                boolean temTarefa = false;
                System.out.println("| * Tarefas");
                for (Tarefa t : listaTarefas) {
                    if (ano == t.getAno()) {
                        System.out.println("| + " + t.getNome());
                        System.out.println("| Dia: " + t.getData());
                        temTarefa = true;
                        break;
                    }
                }
                if (!temTarefa) {
                    System.out.println("| Não há uma Tarefa com o dia digitado.");
                }
            }
        }
    }

    public static void criarEvento() {
        int in;
        System.out.println("|----------------------------------------|");
        System.out.println("|              Criar evento              |");
        System.out.println("| *      Escolha o tipo de evento:     * |");
        System.out.println("| 1 - Evento | 2 - Lembrete | 3 - Tarefa |");
        System.out.print("| 4 - Voltar para menu. -------------->  ");
        in = sc.nextInt();

        while (in != 1 && in != 2 && in != 3 && in != 4) {
            System.out.println("* -------------------------------------- *");
            System.out.println("|   Digite uma opção válida, por favor   |");
            System.out.print("| ------------------------------------>  ");
            in = sc.nextInt();
        }

        switch (in) {
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
                if (mesE == 2 && diaE > 29) {
                    System.out.println("| * Fevereiro tem apenas 28 ou 29 dias. Por favor corrija.");
                    diaE = Dia(auxE);
                    if (diaE > 29) {
                        while (diaE > 29) {
                            System.out.printf("| * Digite um dia válido. ->");
                            diaE = Dia(auxE);
                        }
                    }
                } else if (mesE == 4 || mesE == 6 || mesE == 9 || mesE == 11 && diaE > 30) {
                    System.out.println("| * Seu mês tem 30 dias. Por favor corrija.");
                    diaE = Dia(auxE);
                    if (diaE > 30) {
                        while (diaE > 30) {
                            System.out.printf("| * Digite um dia válido. ->");
                            diaE = Dia(auxE);
                        }
                    }
                }

                int anoE = Ano(auxE);

                char opc;
                System.out.println("| - A data do fim do evento é a mesma? Digite S para Sim");
                opc = sc.next().charAt(0);
                if (opc == 'S') {
                    diaEF = diaE;
                    mesEF = mesE;
                    anoEF = anoE;
                } else {
                    diaEF = Dia(auxE);
                    mesEF = Mes(auxE);
                    if (mesEF == 2 && diaEF > 29) {
                        System.out.println("| * Fevereiro tem apenas 28 ou 29 dias, por favor corrija.");
                        diaEF = Dia(auxE);
                        if (diaEF > 29) {
                            while (diaEF > 29) {
                                System.out.printf("| * Digite um dia válido. ->");
                                diaEF = Dia(auxE);
                            }
                        }
                    } else if (mesEF == 4 || mesEF == 6 || mesEF == 9 || mesEF == 11 && diaEF > 30) {
                        System.out.println("| * Seu mês tem 30 dias. Por favor corrija.");
                        diaEF = Dia(auxE);
                        if (diaEF > 30) {
                            while (diaEF > 30) {
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
                if (mesL == 2 && diaL > 29) {
                    System.out.println("| * Fevereiro tem apenas 28 ou 29 dias, por favor corrija.");
                    diaL = Dia(auxL);
                    if (diaL > 29) {
                        while (diaL > 29) {
                            System.out.printf("| * Digite um dia válido. ->");
                            diaL = Dia(auxL);
                        }
                    }
                } else if (mesL == 4 || mesL == 6 || mesL == 9 || mesL == 11 && diaL > 30) {
                    System.out.println("| * Seu mês tem 30 dias. Por favor corrija.");
                    diaL = Dia(auxL);
                    if (diaL > 30) {
                        while (diaL > 30) {
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
                if (mesT == 2 && diaT > 29) {
                    System.out.println("| * Fevereiro tem apenas 28 ou 29 dias, por favor corrija.");
                    diaT = Dia(auxT);
                    if (diaT > 29) {
                        while (diaT > 29) {
                            System.out.printf("| * Digite um dia válido. ->");
                            diaT = Dia(auxT);
                        }
                    }
                } else if (mesT == 4 || mesT == 6 || mesT == 9 || mesT == 11 && diaT > 30) {
                    System.out.println("| * Seu mês tem 30 dias. Por favor corrija.");
                    diaT = Dia(auxT);
                    if (diaT > 30) {
                        while (diaT > 30) {
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
        System.out.println("| Digite o ID do evento que você quer editar. Caso não saiba, digite 'N' ou 'n'");
    }

    public static void excluirEvento() {
        System.out.println("- Excluir evento.");
    }
}
