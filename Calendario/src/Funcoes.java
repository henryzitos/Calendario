import java.util.*;

public class Funcoes {
    static Scanner sc = new Scanner(System.in);

    public static int Dia(int dia) {
        System.out.println("| Digite o dia: ");
        dia = sc.nextInt();

        while (dia <= 0 || dia >= 32) {
            System.out.println("| Dia inválido. Coloque um dia entre 1 e 31. ->");
            dia = sc.nextInt();
        }
        return dia;
    }

    public static int Mes(int mes){
        System.out.println("| Digite o mês: ");
        mes = sc.nextInt();

        while (mes <= 0 || mes >= 13) {
            System.out.println("| Mês inválido. Coloque um mês entre 1 e 12. ->");
            mes = sc.nextInt();
        }
        return mes;
    }

    public static int Ano(int ano) {
        System.out.println("| Digite o ano: ");
        ano = sc.nextInt();

        while (ano <= 2000 || ano >= 2100) {
            System.out.printf("| Por favor, digite um ano entre 2000 e 2100. -> ");
            ano = sc.nextInt();
        }
        return ano;
    }

    public static int Hora(int hora){
        System.out.println("Digite a(s) hora(s): ");
        hora = sc.nextInt();

        while (hora <= -1 || hora >= 24){
            System.out.println("Hora(s) inválida(s). Digite o horário entre 00h e 23h.");
            hora = sc.nextInt();
        }
        return hora;
    }

    public static int Minuto (int minuto){
        System.out.println("Digite o(s) minuto(s): ");
        minuto = sc.nextInt();

        while (minuto <= -1 || minuto >= 60){
            System.out.println("Minuto(s) inválido(s). Digite o(s) minuto(s) entre 00min até 59min.");
            minuto = sc.nextInt();
        }
        return minuto;
    }
}
