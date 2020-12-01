package br.edu.univas.main;

import java.util.Scanner;

import br.edu.univas.vo.Conta;

public class StartApp {
	public static Scanner leitura = new Scanner(System.in);
	
	public static void main(String[] args) {
		Conta[] contas = new Conta[100];
		
		int contador = 0;	
		int escolha = 0;
		
		do { 
			imprimeMenu();	
			escolha = leitura.nextInt();
			leitura.nextLine();
			
			if (escolha == 1) {
				
				cadastrarContas(contas, contador);
				contador++;	
				
			}
			
			else if (escolha == 2) {
				
				mostrarSaldo(contas);			
				
			}
									
		} while (escolha != 3);
			
		leitura.close();
	}
	public static void imprimeMenu() {
		
		System.out.println("Cadastro de contas");
		System.out.println();
		System.out.println("Digite o número correspondente a opção desejada:");
		System.out.println("1- Cadastrar conta");
		System.out.println("2- Ver Saldo");
		System.out.println("3- Sair");
		
		
		
	}
	
	public static void cadastrarContas(Conta[] contas, int indice  ) {
		
		Conta conta = new Conta();
		System.out.println("Digite o nome da conta");
		conta.descricao = leitura.nextLine();
		System.out.println("Digite o valor da conta");
		conta.valor = leitura.nextFloat();
		leitura.nextLine();
		System.out.println("Digite a data de vencimento");
		conta.vencimento = leitura.nextLine();
		System.out.println("Informe se sua conta vai ser despesa ou receita");
		conta.tipo = leitura.nextLine();
		contas[indice] = conta;
	
	}
	
	public static void mostrarSaldo(Conta[] contas) {
	
		
	 float despesa = 0;	
     float receita = 0;
     
		for (int i = 0; i < 100; i ++) {
			
			if (contas[i] != null && contas[i].tipo.equals("despesa")) {
				
				despesa += contas[i].valor;
					
			}
			
			if (contas[i] != null && contas[i].tipo.equals("receita")) {
							
				receita+=contas[i].valor;	
				
			}								
		}
		
	System.out.println("Seu saldo é: " + (receita - despesa));
		
	}

}
