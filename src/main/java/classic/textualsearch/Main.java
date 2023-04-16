package classic.textualsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String seachTerm = "Jo";
        long inicio = System.currentTimeMillis();
        new Thread(search(seachTerm, "C:\\Users\\pc\\IdeaProjects\\java\\classic-and-virtual-threads\\src\\main\\resources\\assinaturas1.txt")).start();
        new Thread(search(seachTerm, "C:\\Users\\pc\\IdeaProjects\\java\\classic-and-virtual-threads\\src\\main\\resources\\assinaturas2.txt")).start();
        new Thread(search(seachTerm, "C:\\Users\\pc\\IdeaProjects\\java\\classic-and-virtual-threads\\src\\main\\resources\\autores.txt")).start();

        System.out.println(System.currentTimeMillis()  - inicio);
    }

    private static Runnable search(String searchName, String fileName) {
        return () -> {
            try {
                Scanner scanner = new Scanner(new File(fileName));
                int lineNumber = 1;
                Thread.sleep(2000);
                while(scanner.hasNextLine()) {
                    if (scanner.nextLine().toLowerCase().contains(searchName.toLowerCase())){
                        System.out.printf("Encontrado! Linha: %d Arquivo: %s \n", lineNumber, fileName);
                    }
                    lineNumber++;
                }
                scanner.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
