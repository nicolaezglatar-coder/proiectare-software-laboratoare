package ro.ulbs.proiectaresoftware.lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ApplicationLab3 {
    public static void main(String[] args) {
        try {
            String text = Files.readString(Path.of("in.txt"));

            List<String> linii = Arrays.asList(text.split("\\R"));

            StringBuilder rezultatA = new StringBuilder();
            StringBuilder rezultatB = new StringBuilder();

            for (String linie : linii) {
                rezultatA.append(linie).append("\n");
            }

            System.out.println("a)");
            System.out.println(rezultatA);

            for (String linie : linii) {
                rezultatB.append(linie.replace(".", ".\n")).append("\n");
            }

            System.out.println("b)");
            System.out.println(rezultatB);

            String rezultatFinal = "a)\n" + rezultatA + "\n" + "b)\n" + rezultatB;
            Files.writeString(Path.of("out.txt"), rezultatFinal);

            System.out.println("Rezultatul a fost salvat in out.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}