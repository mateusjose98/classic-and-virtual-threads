package classic.firstthread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class AcaoBotao implements ActionListener {

    private JTextField primeiro;
    private JTextField segundo;
    private JLabel resultado;

    public AcaoBotao(JTextField primeiro, JTextField segundo, JLabel resultado) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.resultado = resultado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().threadId());
                    System.out.println(Thread.currentThread().isAlive());
                    long valor1 = Long.parseLong(primeiro.getText());
                    long valor2 = Long.parseLong(segundo.getText());
                    BigInteger calculo = new BigInteger("0");

                    for (int i = 0; i < valor1; i++) {
                        for (int j = 0; j < valor2; j++) {
                            calculo = calculo.add(new BigInteger("1"));
                        }
                    }

                    resultado.setText(calculo.toString());
                }, "MyThread"
        ).start();


    }
}