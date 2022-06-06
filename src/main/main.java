package main;

import java.util.Scanner;

import main.domain.CicleQueueManagement;
import main.domain.PrioritayQueueManagement;
import main.exception.EmptyQueueException;

public class main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Selecione a fila que quer executar (circular/prioridade)");
		final var decision = scanner.next();
		if ("circular".equalsIgnoreCase(decision))
			circularQueueInititalizer(scanner);
		else
			prioritaryQueueInititalizer(scanner);

	}

	private static void prioritaryQueueInititalizer(Scanner scanner) throws Exception{
		System.out.println("insira o tamanho da fila");
		final var size = scanner.nextInt();
		String[] prioritayQueue = new String[size];
		PrioritayQueueManagement prioritayQueueManagement = new PrioritayQueueManagement(prioritayQueue);

		while (true) {
			if (prioritayQueueManagement.getQueue().length > 1) {
				System.out.println("Deseja adicionar ou remover um elemento da fila?(Prioridade/Adicionar/Remover/N)");
			} else {
				System.out.println("Deseja adicionar na fila?(Adicionar/N)");
			}
			String decision = scanner.next();
			if ("n".equalsIgnoreCase(decision)) {
				break;

			} else if ("adicionar".equalsIgnoreCase(decision)) {
				System.out.println("digite o valor da fila");
				prioritayQueueManagement.addQueue(scanner.next());

			} else if ("prioridade".equalsIgnoreCase(decision)){
				System.out.println("digite o valor da fila");
				prioritayQueueManagement.addPrioritayQueue(scanner.next());

			} else if("remover".equalsIgnoreCase(decision)) {
				prioritayQueueManagement.removePrioritayQueue();

			}
		}
	}

	private static void circularQueueInititalizer(Scanner scanner) throws EmptyQueueException {

		System.out.println("insira o tamanho da fila");
		final var size = scanner.nextInt();
		String[] filaCiruclar = new String[size];
		CicleQueueManagement cicleQueueManagement = new CicleQueueManagement(filaCiruclar);

		while (true) {
			if (cicleQueueManagement.getQueue().length > 1) {
				System.out.println("Deseja adicionar ou remover um elemento da fila?(Adicionar/Remover/N)");
			} else {
				System.out.println("Deseja adicionar na fila?(Adicionar/N)");
			}
			String decision = scanner.next();
			if ("n".equalsIgnoreCase(decision)) {
				break;
			} else if ("adicionar".equalsIgnoreCase(decision)) {
					System.out.println("digite o valor da fila");
					cicleQueueManagement.addCicleQueue(scanner.next());
					 
			} else if("remover".equalsIgnoreCase(decision)) {
				cicleQueueManagement.removeCicleQueue();

			}

		}

	}

}
