package AppContaCorrente;

import java.util.Scanner;

public class AppAC {
	private String name, account, agency, id, password;
	private char sexo = 'M';
	private double balance;
	ACusers dataUsers;
	private boolean especialAccess = false;
	private boolean normalAccess = false;
	private int op = 0;
	Scanner sc;

	AppAC() {

	}

	/**
	 * @param account Conta Corrente para acesso ao APP
	 * @param agency  Agencia da conta Corrente
	 */
	AppAC(String account, String agency) {
		this.agency = agency;
		this.account = account;
		dataUsers = new ACusers();
		sc = new Scanner(System.in);
		access();
		if (normalAccess == true) {
			System.out.print(
					"--- BEM VINDO AO BANCO ISRAELENSE ---\n--- ESCOLHA ABAIXO A OPERAÇÃO QUE DESEJA REALIZAR --- \n\n");
			while (op != 5) {
				System.out.println("\n1 - EXTRATO/SALDO\n" + "2 - DEPOSITO  \n" + "3 - SACAR \n"
						+ "4 - ALTERAR DADOS CADASTRADOS \n" + "5 - SAIR");
				op = sc.nextInt();
				operations(op);
			}
		} else {
			System.out.println("Acesso não permitido!");
		}
	}

	/**
	 * Construtor para o banco de dados ficticio, vetor que idealiza um banco de
	 * dados.
	 * 
	 * @param name
	 * @param account
	 * @param agency
	 * @param id
	 * @param password
	 * @param balance
	 * @param sexo
	 */
	AppAC(String name, String account, String agency, String id, String password, double balance, char sexo) {
		this.name = name;
		this.account = account;
		this.agency = agency;
		this.id = id;
		this.password = password;
		this.balance = balance;
		this.sexo = sexo;
	}

	/**
	 * Método para realizar as operações, extrato, deposito, saque e alteração
	 * cadastral
	 * 
	 * @param int op = valor de acordo com a operação solicitada
	 */
	private void operations(int op) {
		switch (op) {
			case 1:
				System.out.println(extract());
				break;
			case 2:
				System.out.println("VALOR PARA DEPÓSITO: ");
				double deposit = sc.nextDouble();
				if (deposit <= 0) {
					System.out.println("Não é possível depositar o valor informado!");
				} else {
					balance += deposit;
					System.out.println(extract());
				}
				break;
			case 3:
				System.out.println("VALOR PARA SAQUE: ");
				double withdraw = sc.nextDouble();
				if (withdraw > balance) {
					System.out.println("Não foi possível sacar o valor informado!");
				} else {
					balance -= withdraw;
				}
				break;
			case 4:
				int attempts = 0;
				do {
					System.out.println(accessEspecial());
					System.out.println();
					attempts++;
					if (attempts == 3) {
						op = 5;
					}
				} while (attempts < 3 && especialAccess == false);
				if (especialAccess == true) {
					int change = 0;
					especialAccess = false;
					System.out.println("ALTERAÇÃO CADASTRAL: " + "\n 1 - PARA ALTERAR O NOME "
							+ "\n 2 - PARA ALTERAR O ID DE ACESSO ESPECIAL ");
					change = sc.nextInt();

					switch (change) {
						case 1:
							System.out.println("INFORME O NOVO NOME: ");
							sc.nextLine();
							String changeName = sc.nextLine();
							this.name = changeName;
							break;
						case 2:
							System.out.println();
							System.out.println("INFORME O NOVO ID PARA ACESSO: ");
							sc.nextLine();
							String changeId = sc.nextLine();
							this.id = changeId;
							break;
						default:
							break;

					}
				}
				break;
			default:
				System.out.println("OBRIGADO POR USAR NOSSO APP");
				break;
		}
	}

	/**
	 * Verifica se a agência e conta informadas estão de acordo com o banco de dados
	 * ficticio.
	 * 
	 * @return void
	 */
	public void access() {
		for (int i = 0; i < ACusers.users.length; i++) {
			if (this.agency.equals(ACusers.users[i].agency)) {
				if (this.account.equals(ACusers.users[i].account)) {
					normalAccess = true;
					this.name = ACusers.users[i].name;
					this.account = ACusers.users[i].account;
					this.agency = ACusers.users[i].agency;
					this.balance = ACusers.users[i].balance;
					this.id = ACusers.users[i].id;
					this.password = ACusers.users[i].password;
				}
			}
		}
		// System.out.println("Agencia incorreta, acesso não permitido!");
	}

	/**
	 * Verifica se o ID e Senha para o acesso especial estão de acordo com o banco
	 * de dados
	 */
	private String accessEspecial() {
		String especialId = "", especialPassword = "";
		System.out.println("INFORME O SEU ID DE ACESSO ESPECIAL: ");
		especialId = sc.next();
		System.out.println("INFORME SUA SENHA: ");
		especialPassword = sc.next();
		for (int i = 0; i < ACusers.users.length; i++) {
			if (this.id.equals(especialId)) {
				if (this.password.equals(especialPassword)) {
					especialAccess = true;
					return "ACESSO ESPECIAL CONCEDIDO!";
				} else {
					especialAccess = false;
				}
			}

		}
		return "ID E/OU SENHA INCORRETA!";
	}

	/**
	 * @return String formatada com dados sobre o cliente selecionado
	 */
	private String extract() {
		return "Cliente: " + name + " | Sexo: " + sexo + "\nAgencia nº :" + agency + " | Conta Corrente nº :" + account
				+ String.format("\nSaldo em R$: %.2f", balance);
	}

	public String getAccount() {
		return account;
	}

	public String getAgency() {
		return agency;
	}

	public String getId() {
		return id;
	}

	public String getPasswword() {
		return password;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPasswword(String passwword) {
		this.password = passwword;
	}
}
