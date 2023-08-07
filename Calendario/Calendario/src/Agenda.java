import Acontecimentos.*;

import java.util.Scanner;

public class Agenda {
    static Scanner sc = new Scanner(System.in);

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
        System.out.println("- Visualizar evento.");
    }

    public static void criarEvento() {
        System.out.println("- Criar evento.");
    }

    public static void editarEvento() {
        System.out.println("- Editar evento.");
    }

    public static void excluirEvento() {
        System.out.println("- Excluir evento.");
    }
}
