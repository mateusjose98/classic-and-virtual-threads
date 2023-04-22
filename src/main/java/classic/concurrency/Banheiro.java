package classic.concurrency;

public class Banheiro {

    private boolean sujo = true;

    public void fazNumero1() {
        synchronized (this){
            String name = Thread.currentThread().getName();

            System.out.println(name +" espia o banheiro");
            while (sujo) {
                esperaForaSeBanheiroSujo(name);
            }
            System.out.println(name +" entrando no banheiro");


            System.out.println(name +" Numero 1 sendo feito");
            try {
                Thread.sleep(1_500);
            }catch (Exception e) {

            }
            System.out.println(name +" deu a escarga no mijo");
            System.out.println(name +" Saindo");
            this.sujo = true;


        }


    }

    public void limpar() {
        synchronized (this){
            String name = Thread.currentThread().getName();
            System.out.println(name +" entrando no banheiro");
            if(!this.sujo){
                System.out.println("Não está sujo! Saindo ....");
            }
            System.out.println(name +" limpando!!!");
            try {
                Thread.sleep(5000);
            }catch (Exception e) {

            }
            this.sujo = false;
            this.notifyAll();
            System.out.println(name +" Saindo, alguém já pode usar");
        }
    }

    private void esperaForaSeBanheiroSujo(String name) {

            System.out.println("Eca, Banheiro sujo!!! " + name);
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }

    public void fazNumero2() {
        synchronized (this) {

            String name = Thread.currentThread().getName();
            System.out.println(name +" espia o banheiro");
            while (sujo) {
                esperaForaSeBanheiroSujo(name);
            }
            System.out.println(name + " entrando no banheiro");
            System.out.println(name + " Numero 2 sendo feito");
            try {
                Thread.sleep(3_000);
            } catch (Exception e) {

            }
            System.out.println(name + " deu a descarga.. na merda");
            System.out.println(name + " Saindo");
            this.sujo = true;
        }
    }

}
