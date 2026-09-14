import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        OrdemServico os = new OrdemServico();
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
                    System.out.print("Digite seu nome: ");
                    String nome=sc.nextLine();
                    System.out.print("Digite seu CPF: ");
                    String cpf=sc.nextLine();
                    System.out.print("Digite seu telefone: ");
                    String telefone=sc.nextLine();

                    os.setNome(nome);
                    os.setCpf(cpf);
                    os.setTelefone(telefone);
                    break;

                case 2:
                    System.out.print("Digite o seu produto: ");
                    String produto=sc.nextLine();
                    System.out.print("Digite a marca de seu produto: ");
                    String marca=sc.nextLine();
                    System.out.print("Digite o modelo de seu produto: ");
                    String modelo=sc.nextLine();

                    os.setProduto(produto);
                    os.setMarca(marca);
                    os.setModelo(modelo);
                    break;


                case 3:
                    System.out.print("Descreva o defeito do equipamento: ");
                    String defeito = sc.nextLine();
                    os.setDefeito(defeito);
                    os.setStatus("Aberta");
                    System.out.println("Ordem de serviço aberta com sucesso.");
                    break;

                case 4:
                    if (os.getStatus() == null) {
                        System.out.println("Nenhuma ordem de serviço aberta.");
                        break;
                    }
                    System.out.println("Nome: " + os.getNome());
                    System.out.println("CPF: " + os.getCpf());
                    System.out.println("Telefone: " + os.getTelefone());
                    System.out.println("Produto: " + os.getProduto());
                    System.out.println("Marca: " + os.getMarca());
                    System.out.println("Modelo: " + os.getModelo());
                    System.out.println("Defeito: " + os.getDefeito());
                    System.out.println("Status: " + os.getStatus());
                    break;

                case 5:
                    System.out.println("Digite a senha: ");
                    os.setSenha(sc.nextInt());
                    sc.nextLine();
                    if (os.getSenha() != 123) {
                        System.out.println("Somente pessoas autorizadas podem fazer isso.");
                        break;
                    }else {
                        System.out.print("Digite o novo status da OS: ");
                        String status = sc.nextLine();
                        os.setStatus(status);
                        System.out.println("Status atualizado com sucesso.");
                    }
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