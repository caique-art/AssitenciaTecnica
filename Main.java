package Main;
import java.util.Locale;
import java.util.Scanner;
import Menu.Menu;


public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Menu menu=new Menu();
        int escolha;

        do {
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar equipamento");
            System.out.println("3 - Abrir ordem de serviço");
            System.out.println("4 - Consultar ordem de serviço");
            System.out.println("5 - Alterar status da OS");
            System.out.println("0 - Sair");
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
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(escolha !=0);
        sc.close();
    }
}