import Acontecimentos.*;

public class Teste {
    public static void main(String[] args) {
        Lembrete primeiroLembrete = new Lembrete("Contagem regressiva", 21, 10, 2023, 12, 00);
        System.out.println("Seu primeiro lembrete: ");
        System.out.println("Dia: " + primeiroLembrete.getData());
        System.out.println("Horário: " + primeiroLembrete.getHorario());

        System.out.println();

        Tarefa primeiraTarefa = new Tarefa("Preparação para a festa", 27, 10, 2023);
        System.out.println("Sua primeira tarefa: ");
        System.out.println("Dia: " + primeiraTarefa.getData());

        System.out.println();

        Evento primeiroEvento = new Evento("Festa de aniversário", 28, 10, 2023, 29, 10, 2023, 16,
                30, 00, 30);
        System.out.println("Seu primeiro evento: ");
        System.out.println("Data de Início: " + primeiroEvento.getDataInicio());
        System.out.println("Horário de Início: " + primeiroEvento.getHorarioInicio());
        System.out.println("Data de Fim: " + primeiroEvento.getDataFim());
        System.out.println("Horário de Fim: " + primeiroEvento.getHorarioFim());
    }
}
