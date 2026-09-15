package Menu;

import java.util.Scanner;

import Clientes.Clientes;
import OrdemServico.OrdemServico;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Clientes cliente = new Clientes();
	OrdemServico os = new OrdemServico();

	public void CadastrarClientes() {
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		System.out.print("Digite seu CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Digite seu telefone: ");
		String telefone = sc.nextLine();

		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setTelefone(telefone);
	}

	public void CadastrarEquipamento() {
		if (cliente.getCpf() == null || cliente.getNome() == null) {
			System.out.println("Complete o login primeiro");
		} else {
			System.out.print("Digite o seu produto: ");
			String produto = sc.nextLine();
			System.out.print("Digite a marca de seu produto: ");
			String marca = sc.nextLine();
			System.out.print("Digite o modelo de seu produto: ");
			String modelo = sc.nextLine();

			os.setProduto(produto);
			os.setMarca(marca);
			os.setModelo(modelo);
		}
	}

	public void AbrirOS() {
		System.out.print("Descreva o defeito do equipamento: ");
		String defeito = sc.nextLine();
		os.setDefeito(defeito);
		os.setStatus("Aberta");
		System.out.println("Ordem de serviço aberta com sucesso.");
	}

	public void ConsultarOS() {
		if (os.getStatus() == null) {
			System.out.println("Nenhuma ordem de serviço aberta.");

		} else {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Produto: " + os.getProduto());
			System.out.println("Marca: " + os.getMarca());
			System.out.println("Modelo: " + os.getModelo());
			System.out.println("Defeito: " + os.getDefeito());
			System.out.println("Status: " + os.getStatus());
		}
	}

	public void AlterarStatus() {
		System.out.println("Digite a senha: ");
		os.setSenha(sc.nextInt());
		sc.nextLine();
		if (os.getSenha() != 123) {
			System.out.println("Senha errada. Somente pessoas autorizadas podem fazer isso.");

		} else {
			System.out.print("Digite o novo status da OS: ");
			String status = sc.nextLine();
			os.setStatus(status);
			System.out.println("Status atualizado com sucesso.");
		}
	}

}
