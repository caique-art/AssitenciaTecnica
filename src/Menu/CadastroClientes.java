package Menu;

import java.util.ArrayList;
import java.util.Scanner;
import Clientes.Clientes;

public class CadastroClientes {
	ArrayList<Clientes> listaClientes;

	public CadastroClientes(ArrayList<Clientes> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void CadastrarClientes() {

		Scanner sc = new Scanner(System.in);

			Clientes cliente = new Clientes();
			ConsoleVisual.titulo("CADASTRAR CLIENTE", "ASSISTÊNCIA TÉCNICA | Atendimento");
			ConsoleVisual.pedir("Nome completo");
			String nome = sc.nextLine();
			ConsoleVisual.pedir("CPF");
			String cpf = sc.nextLine();
			if (cpfExistent(cpf) == false) {
				ConsoleVisual.pedir("Telefone");
				String telefone = sc.nextLine();

				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setTelefone(telefone);
				listaClientes.add(cliente);
				ConsoleVisual.sucesso("Cliente cadastrado com sucesso.");
			} else {
				ConsoleVisual.aviso("Cpf já existe!");
			}
		
	}

	private boolean cpfExistent(String cpf) {
		for (Clientes x : listaClientes) {
			if (cpf.equals(x.getCpf())) {
				return true;
			}

		}
		return false;
	}

}
