import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.print("1 - Cadastrar cliente");
            System.out.print("2 - Cadastrar equipamento");
            System.out.print("3 - Abrir ordem de serviço");
            System.out.print("4 - Consultar ordem de serviço");
            System.out.print("5 - Alterar status da OS");
            System.out.print("0 - Sair");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite seu nome: ");
                    String nome=sc.nextLine();
                    System.out.print("Digite seu CPF: ");
                    String cpf=sc.nextLine();
                    System.out.print("Digite seu telefone: ");
                    int telefone=sc.nextInt();

                    sc.nextLine();

                case 2:
                    System.out.print("Digite o seu produto: ");
                    String produto=sc.nextLine();
                    System.out.print("Digite a marca de seu produto: ");
                    String marca=sc.nextLine();

            }
        }while(escolha !=0);
        sc.close();
    }
}