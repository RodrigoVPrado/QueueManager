package main.domain;

import java.util.Arrays;

import main.exception.EmptyQueueException;
import main.exception.FullQueueException;

public class CicleQueueManagement {

	private String[] queue;
	private int inicio, fim, size;

	public String[] getQueue() {
		return this.queue;

	}

	public CicleQueueManagement(String[] filaCiruclar) {
		this.queue = filaCiruclar;
		this.inicio = this.fim = 0;
		this.size = queue.length;
	}

	public void addCicleQueue(String data) throws FullQueueException {

		if (cicleQueueCheia()) {
			throw new FullQueueException("Fila cheia");
		}
		if (queue[inicio] == null) { //fila vazia
			inicio = -1;
			fim = -1;
		}

		if (fim == size -1){
			fim = - 1;
		}
		if (fim == -1 && inicio == -1) {
			inicio = 0;
			fim = 0;
			queue[fim] = data;
		} else {
			fim++;
			queue[fim] = data;
		}

		System.out.println(Arrays.toString(queue));
	}

	public void removeCicleQueue() throws EmptyQueueException{

		if (queue[inicio] == null) {
			throw new EmptyQueueException("Fila vazia");

		} else if (inicio != size - 1){
			queue[inicio] = null;
			inicio++;

		} else if (inicio == size -1){
			queue[inicio] = null;
			inicio = 0;

		}

		System.out.println(Arrays.toString(queue));
	}

	public boolean cicleQueueCheia() {

		int cont = 0;

		for (String queue: queue) {
			if (queue != null){
				cont++;

			}
		}

		if (cont == queue.length){
			return true;

		}
		return false;

	}

}
