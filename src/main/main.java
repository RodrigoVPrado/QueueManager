package main;

import java.util.Scanner;

import main.domain.QueueManagement;

public class main {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("insira o tamanho da fila");
		final var size = scanner.nextInt();
		String[] filaCiruclar = new String[size];
		QueueManagement queueManagement = new QueueManagement(filaCiruclar);

		while (true) {
			if (queueManagement.getQueue().length > 1) {
				System.out.println("Deseja adicionar ou remover um elemento da fila?(Adicionar/remover/N)");
			} else {
				System.out.println("Deseja adicionar na fila?(Adicionar/N)");
			}
			String decision = scanner.next();
			if ("n".equalsIgnoreCase(decision)) {
				break;
			} else if ("adicionar".equalsIgnoreCase(decision)) {
					System.out.println("digite o valor da fila");
					queueManagement.addCicleQueue(scanner.next());
					 
			} else if("remover".equalsIgnoreCase(decision)) {
				queueManagement.removeCicleQueue();

			}

		}

	}

}
