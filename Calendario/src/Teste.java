import Acontecimentos.*;

public class Teste {
    public static void main(String[] args) {
        Lembrete primeiroLembrete = new Lembrete(21, 10, 2023, 12, 00, "Contagem regressiva.");
        System.out.println("Seu primeiro lembrete: ");
        System.out.println("Dia: " + primeiroLembrete.getData());
        System.out.println("Horário: " + primeiroLembrete.getHorario());
        System.out.println("Descrição: " + primeiroLembrete.getDescricao());

        System.out.println();

        Tarefa primeiraTarefa = new Tarefa(27, 10, 2023, "Arrumar as coisas para o aniversário.");
        System.out.println("Sua primeira tarefa: ");
        System.out.println("Dia: " + primeiraTarefa.getData());
        System.out.println("Descrição: " + primeiraTarefa.getDescricao());

        System.out.println();

        Evento primeiroEvento = new Evento(28, 10, 2023, 29, 10, 2023, 16,
                30, 00, 30, "Minha festa de aniversário!");
        System.out.println("Seu primeiro evento: ");
        System.out.println("Data de Início: " + primeiroEvento.getDataInicio());
        System.out.println("Horário de Início: " + primeiroEvento.getHorarioInicio());
        System.out.println("Data de Fim: " + primeiroEvento.getDataFim());
        System.out.println("Horário de Fim: " + primeiroEvento.getHorarioFim());
        System.out.println("Descrição: " + primeiroEvento.getDescricao());
    }
}
