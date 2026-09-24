package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Clientes.Clientes;
import OrdemServico.OrdemServico;

public class CadastrarEquipamento {
	Scanner sc = new Scanner(System.in);
	CadastroClientes cadastroClientes;
	ArrayList<OrdemServico> listaOrdens;
	ArrayList<Clientes> listaClientes;

	public CadastrarEquipamento(ArrayList<OrdemServico> listaOrdens, ArrayList<Clientes> listaClientes) {
		this.listaOrdens = listaOrdens;
		this.listaClientes = listaClientes;
	}

	public void CadastroEquipamento() {
		Clientes clienteEncontradado = null;
		boolean cpfExist = false;

		ConsoleVisual.titulo("CADASTRAR EQUIPAMENTO", "ASSISTÊNCIA TÉCNICA | Atendimento");
		System.out.println("Digite o seu cpf: ");
		String cpf = sc.next();
		for (Clientes x : listaClientes) {
			if (cpf.equals(x.getCpf())) {
				cpfExist = true;
				clienteEncontradado = x;
			}
		}
		if (!cpfExist) {
			ConsoleVisual.aviso("Cadastre um cliente primeiro, pela opção 1 do menu.");
		} else {
			ConsoleVisual.pedir("Quantidade de aparelhos");
			int quantidade = sc.nextInt();
			sc.nextLine();
			String produto;

			for (int i = 0; i < quantidade; i++) {
				OrdemServico os2 = new OrdemServico();
				ConsoleVisual.secao("EQUIPAMENTO " + (i + 1) + " DE " + quantidade);
				ConsoleVisual.pedir("Produto");
				produto = sc.nextLine();
				ConsoleVisual.pedir("Marca");
				String marca = sc.nextLine();
				ConsoleVisual.pedir("Modelo");
				String modelo = sc.nextLine();

				os2.setProduto(produto);
				os2.setMarca(marca);
				os2.setModelo(modelo);
				os2.setCliente(clienteEncontradado);
				listaOrdens.add(os2);
				ConsoleVisual.sucesso("Equipamento cadastrado com sucesso.");
			}
		}
	}

}
