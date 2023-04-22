package classic.collections;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // usando Lista
//        Lista lista = new Lista();
//
//        for (int i =0; i < 10; i++) {
//            new Thread(add(lista, i)).start();
//        }
//
//        Thread.sleep(2_000);
//
//        for(int i =0; i < lista.tamanho(); i++) {
//            System.out.println(lista.pegaElemento(i));
//        }

        // usando List<T>

        List<String> lista = new Vector<>();

        for (int i =0; i < 10; i++) {
            new Thread(addList(lista, i)).start();
        }

        Thread.sleep(2_000);

        for(int i =0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    private static Runnable addList( List lista, int threadNumber) {
        return () -> {
            for (int i =0; i < 10; i++) {
                lista.add("Thread: "+ threadNumber + " - v:" + i);
            }
        };
    }

    private static Runnable add( Lista lista, int threadNumber) {
        return () -> {
            for (int i =0; i < 100; i++) {
                lista.adicionaElementos("Thread: "+ threadNumber + " - v:" + i);
            }
        };
    }
}
