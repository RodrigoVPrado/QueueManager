package main.domain;

import main.exception.EmptyQueueException;
import main.exception.FullQueueException;

import java.util.Arrays;

public class PrioritayQueueManagement {

    private String[] queue;
    private int inicio, fim,fimPrioridade, size;

    public String[] getQueue() {
        return this.queue;

    }

    public PrioritayQueueManagement(String[] prioritayQueue) {
        this.queue = prioritayQueue;
        this.fim = this.fimPrioridade = -1;
        this.inicio = 0;
        this.size = queue.length;
    }

    public void addQueue(String data) {

        if (prioritayQueueCheia()) {
            throw new FullQueueException("Fila cheia");
        }
//        if (fim == size -1){
//            fim = - 1;
//        }
//        if (fim == -1 && inicio == -1) {
//            inicio = 0;
//            fim = 0;
//            queue[fim] = data;
//        } else {
//            fim++;
//            queue[fim] = data;
//        }

            fim++;
            queue[fim] = data;

        System.out.println(Arrays.toString(queue));
    }

    public void addPrioritayQueue(String data) {

        if (prioritayQueueCheia()) {
            throw new FullQueueException("Fila cheia");
        }


        if (fim == -1) {
            fimPrioridade++;
            queue[fimPrioridade] = data;
            fim++;

        } else if (queue[fimPrioridade + 1] != null){
            for (int i = 0; i < fim + 1; i++) {
                queue[fim + 1 - i] = queue[fim - i];

            }
            fimPrioridade++;
            queue[fimPrioridade] = data;
            fim++;
        }

        System.out.println(Arrays.toString(queue));
    }

    public void removePrioritayQueue() throws EmptyQueueException{
        if (queue[inicio] == null) {
            throw new EmptyQueueException("Fila vazia");
        } else {
            queue[inicio] = null;
            inicio++;
        }

        System.out.println(Arrays.toString(queue));
    }

    public boolean prioritayQueueCheia() {

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
