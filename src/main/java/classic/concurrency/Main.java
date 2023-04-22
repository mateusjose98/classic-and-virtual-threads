package classic.concurrency;

public class Main {

    public static void main(String[] args) {

        Banheiro banheiro = new Banheiro();
        new Thread(tarefa1(banheiro), "João").start();
        new Thread(tarefa2(banheiro), "Pedro").start();
        Thread lim = new Thread(limpeza(banheiro), "Limpeza");
        lim.setDaemon(true);
        lim.start();

    }

    private static Runnable limpeza(Banheiro banheiro) {
        return () -> {
            while(true) {
                banheiro.limpar();
                try {
                    Thread.sleep(20_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        };
    }

    private static Runnable tarefa1(Banheiro banheiro) {
        return () -> {
            banheiro.fazNumero1();
        };
    }

    private static Runnable tarefa2(Banheiro banheiro) {
        return () -> {
            banheiro.fazNumero2();
        };
    }
}
