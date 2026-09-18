package Menu;

import java.util.ArrayList;
import java.util.Scanner;
import Clientes.Clientes;
import OrdemServico.OrdemServico;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Clientes cliente = new Clientes();
	OrdemServico os = new OrdemServico();
	ArrayList<OrdemServico> lista = new ArrayList<>();

	public void CadastrarClientes() {
		ConsoleVisual.titulo("CADASTRAR CLIENTE", "ASSISTÊNCIA TÉCNICA | Atendimento");
		ConsoleVisual.pedir("Nome completo");
		String nome = sc.nextLine();
		ConsoleVisual.pedir("CPF");
		String cpf = sc.nextLine();
		ConsoleVisual.pedir("Telefone");
		String telefone = sc.nextLine();

		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setTelefone(telefone);
		ConsoleVisual.sucesso("Cliente cadastrado com sucesso.");
	}

	public void CadastrarEquipamento() {
		ConsoleVisual.titulo("CADASTRAR EQUIPAMENTO", "ASSISTÊNCIA TÉCNICA | Atendimento");
		if (cliente.getCpf() == null || cliente.getNome() == null) {
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
				lista.add(os2);
				ConsoleVisual.sucesso("Equipamento cadastrado com sucesso.");
			}
		}
	}

	public void AbrirOS() {
		ConsoleVisual.titulo("ABRIR ORDEM DE SERVIÇO", "ASSISTÊNCIA TÉCNICA | Atendimento");
		if (lista.isEmpty()) {
			ConsoleVisual.aviso("Cadastre um equipamento primeiro.");
			return;
		}

		for (int i = 0; i < lista.size(); i++) {
			exibirEquipamento(i, lista.get(i));
		}
		ConsoleVisual.pedir("Número do equipamento");
		int opcao = sc.nextInt();
		sc.nextLine();
		if (opcao < 1 || opcao > lista.size()) {
			ConsoleVisual.aviso("Opção inválida.");
			return;
		}
		OrdemServico selecionada = lista.get(opcao - 1);
		ConsoleVisual.menuServico();
		int escolha = sc.nextInt();
		sc.nextLine();

		switch (escolha) {
		case 1:
			String servico = "Limpeza";
			selecionada.setServico(servico);
			break;
		case 2:
			ConsoleVisual.menuDefeito();
			int escolha1 = sc.nextInt();
			sc.nextLine();

			switch(escolha1){
			case 1:
				servico = "Manutenção Preventiva";
				selecionada.setServico(servico);
				selecionada.setStatus("Aberta");
				ConsoleVisual.sucesso("Ordem de serviço aberta com sucesso.");
				break;
			case 2:
				servico = null;
				reparo(servico);
				selecionada.setServico(servico);
				selecionada.setStatus("Aberta");
				ConsoleVisual.sucesso("Ordem de serviço aberta com sucesso.");
				break;
			default:
				ConsoleVisual.aviso("Digite uma opção válida!!!");
				break;
			}
			break;
		case 3:
			ConsoleVisual.pedir("Defeito relatado:");
			servico="defeito";
			selecionada.setServico(servico);
			String defeito = sc.nextLine();
			selecionada.setDefeito(defeito);
			selecionada.setStatus("Aberta");
			ConsoleVisual.sucesso("Ordem de serviço aberta com sucesso.");
			break;
		}

	}

	public void ConsultarOS() {
		ConsoleVisual.titulo("CONSULTAR ORDENS DE SERVIÇO", "ASSISTÊNCIA TÉCNICA | Atendimento");
		if (lista.isEmpty()) {
			ConsoleVisual.aviso("Cadastre um equipamento primeiro.");
			return;
		}

		ConsoleVisual.secao("CLIENTE");
		ConsoleVisual.campo("Nome", cliente.getNome());
		ConsoleVisual.campo("CPF", cliente.getCpf());
		ConsoleVisual.campo("Telefone", cliente.getTelefone());
		ConsoleVisual.linha();

		for (int i = 0; i < lista.size(); i++) {
			OrdemServico selecionada = lista.get(i);
			exibirEquipamento(i, selecionada);

		}
	}

	public void AlterarStatus() {
		ConsoleVisual.titulo("ALTERAR STATUS DA OS", "ASSISTÊNCIA TÉCNICA | Atendimento");
		if (lista.isEmpty()) {
			ConsoleVisual.aviso("Cadastre um equipamento primeiro.");
			return;
		}
		ConsoleVisual.pedir("Senha de acesso");
		os.setSenha(sc.nextInt());
		sc.nextLine();
		if (os.getSenha() != 123) {
			ConsoleVisual.aviso("Senha errada. Somente pessoas autorizadas podem fazer isso.");

		} else {
			for (int i = 0; i < lista.size(); i++) {
				exibirEquipamento(i, lista.get(i));
			}

			ConsoleVisual.pedir("Número do equipamento");
			int opcao = sc.nextInt();
			sc.nextLine();
			if (opcao < 1 || opcao > lista.size()) {
				ConsoleVisual.aviso("Opção inválida.");
				return;
			}

			OrdemServico selecionada = lista.get(opcao - 1);

			if (selecionada.getStatus() == null) {
				ConsoleVisual.aviso("Essa ordem de serviço ainda não foi aberta.");
				return;
			}
			ConsoleVisual.pedir("Novo status da OS");
			String status = sc.nextLine();
			selecionada.setStatus(status);
			ConsoleVisual.sucesso("Status atualizado com sucesso.");
		}
	}

	private void exibirEquipamento(int indice, OrdemServico equipamento) {
		ConsoleVisual.secao("EQUIPAMENTO [" + (indice + 1) + "]");
		ConsoleVisual.campo("Produto", equipamento.getProduto());
		ConsoleVisual.campo("Marca", equipamento.getMarca());
		ConsoleVisual.campo("Modelo", equipamento.getModelo());
		ConsoleVisual.campo("Serviço pedido:", equipamento.getServico());
		ConsoleVisual.campo("Defeito:", equipamento.getDefeito()== null ? "Nenhum defeito informado": equipamento.getDefeito());
		ConsoleVisual.campo("Status",
				equipamento.getStatus() == null ? "OS ainda não aberta" : equipamento.getStatus());
		ConsoleVisual.linha();
	}

	public String reparo(String defeito) {
		ConsoleVisual.pedir("Defeito relatado:");
		defeito = sc.nextLine();
		return defeito;
	}
}
