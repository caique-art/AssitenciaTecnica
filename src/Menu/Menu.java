package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Clientes.Clientes;
import OrdemServico.OrdemServico;

public class Menu {
	Scanner sc = new Scanner(System.in);
	OrdemServico os;
	Clientes clienteEncontradado = null;
	ArrayList<OrdemServico> listaOrdens;
	ArrayList<Clientes> listaClientes;
	CadastroClientes cadastroClientes;
	
	public Menu(ArrayList<OrdemServico> listaOrdens, ArrayList<Clientes> listaClientes) {
		this.listaOrdens = listaOrdens;
		this.listaClientes = listaClientes;
	}
	
	public void AbrirOS() {
		boolean cpfExist = false;
		ConsoleVisual.titulo("ABRIR ORDEM DE SERVIÇO", "ASSISTÊNCIA TÉCNICA | Atendimento");
		ConsoleVisual.texto("Digite o seu cpf: ");
		String cpf = sc.nextLine();

		for (OrdemServico x : listaOrdens) {

			if (cpf.equals(x.getCliente().getCpf())) {
				cpfExist = true;
			}

		}
		if (!cpfExist) {
			ConsoleVisual.aviso("CPF inválido!!!!");
		} else {
			if (listaOrdens.isEmpty()) {
				ConsoleVisual.aviso("Cadastre um equipamento primeiro.");
				return;
			}

			for (int i = 0; i < listaOrdens.size(); i++) {
				exibirEquipamento(i, listaOrdens.get(i));
			}
			ConsoleVisual.pedir("Número do equipamento");
			int opcao = sc.nextInt();
			sc.nextLine();
			if (opcao < 1 || opcao > listaOrdens.size()) {
				ConsoleVisual.aviso("Opção inválida.");
				return;
			}
			OrdemServico selecionada = listaOrdens.get(opcao - 1);
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

				switch (escolha1) {
				case 2:
					servico = "Manutenção Preventiva";
					selecionada.setServico(servico);
					selecionada.setStatus("Aberta");
					ConsoleVisual.sucesso("Ordem de serviço aberta com sucesso.");
					break;
				case 1:
					servico = "defeito";
					selecionada.setServico(servico);
					ConsoleVisual.pedir("Qual o defeito ?");
					String defeito = sc.nextLine();
					selecionada.setDefeito(defeito);
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
				servico = "defeito";
				selecionada.setServico(servico);
				String defeito = sc.nextLine();
				selecionada.setDefeito(defeito);
				selecionada.setStatus("Aberta");
				ConsoleVisual.sucesso("Ordem de serviço aberta com sucesso.");
				break;
			}

		}
	}

	public void ConsultarOS() {
		ConsoleVisual.titulo("CONSULTAR ORDENS DE SERVIÇO", "ASSISTÊNCIA TÉCNICA | Atendimento");
		ConsoleVisual.pedir("Digite o seu cpf: ");
		String cpf = sc.nextLine();
		Clientes clienteEncontrado = null;

		for (Clientes x : listaClientes) { // percorre toda a lista atrás de um cpf válido da lista

			if (cpf.equals(x.getCpf())) {
				clienteEncontrado = x;
			}

		}
		if (listaOrdens.isEmpty()) {
			ConsoleVisual.aviso("Cadastre um equipamento primeiro.");
			return;
		}
		if (clienteEncontrado == null) {
			ConsoleVisual.aviso("CPF inválido!!!!");
		} else {
			ConsoleVisual.secao("CLIENTE");
			ConsoleVisual.campo("Nome", clienteEncontrado.getNome());
			ConsoleVisual.campo("CPF", clienteEncontrado.getCpf());
			ConsoleVisual.campo("Telefone", clienteEncontrado.getTelefone());
			ConsoleVisual.linha();

			for (int i = 0; i < listaOrdens.size(); i++) {
				OrdemServico selecionada = listaOrdens.get(i);
				if (cpf.equals(selecionada.getCliente().getCpf())) {
					exibirEquipamento(i, selecionada);
				}

			}
		}
	}

	public void AlterarStatus() {
		ConsoleVisual.titulo("ALTERAR STATUS DA OS", "ASSISTÊNCIA TÉCNICA | Atendimento");
		if (listaOrdens.isEmpty()) {
			ConsoleVisual.aviso("Cadastre um equipamento primeiro.");
			return;
		}
		ConsoleVisual.pedir("Senha de acesso");
		os.setSenha(sc.nextInt());
		sc.nextLine();
		if (os.getSenha() != 123) {
			ConsoleVisual.aviso("Senha errada. Somente pessoas autorizadas podem fazer isso.");

		} else {
			for (int i = 0; i < listaOrdens.size(); i++) {
				exibirEquipamento(i, listaOrdens.get(i));
			}

			ConsoleVisual.pedir("Número do equipamento");
			int opcao = sc.nextInt();
			sc.nextLine();
			if (opcao < 1 || opcao > listaOrdens.size()) {
				ConsoleVisual.aviso("Opção inválida.");
				return;
			}

			OrdemServico selecionada = listaOrdens.get(opcao - 1);

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
		ConsoleVisual.campo("Defeito:",
				equipamento.getDefeito() == null ? "Nenhum defeito informado" : equipamento.getDefeito());
		ConsoleVisual.campo("Status",
				equipamento.getStatus() == null ? "OS ainda não aberta" : equipamento.getStatus());
		ConsoleVisual.linha();
	}

	}


