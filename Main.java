package Main;
import java.util.Locale;
import java.util.Scanner;
import Menu.Menu;
import Menu.ConsoleVisual;


public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Menu menu=new Menu();
        int escolha;

        do {
            ConsoleVisual.menuPrincipal();
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                   menu.CadastrarClientes();
                    break;

                case 2:
                   menu.CadastrarEquipamento();
                    break;


                case 3:
                    menu.AbrirOS();
                    break;

                case 4:
                   menu.ConsultarOS();
                    break;

                case 5:
                   menu.AlterarStatus();
                    break;

                case 0:
                    ConsoleVisual.sucesso("Atendimento encerrado. Até a próxima!");
                    break;

                default:
                    ConsoleVisual.aviso("Opção inválida. Escolha um número de 0 a 5.");
                    break;
            }
        }while(escolha !=0);
        sc.close();
    }
}