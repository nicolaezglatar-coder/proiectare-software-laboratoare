package ro.ulbs.proiectaresoftware.lab3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApplicationLab3 {
    public static void main(String[] args) {
        Path inputPath = Path.of("in.txt");
        Path outputPath = Path.of("out.txt");

        List<String> liniiInitiale = Arrays.asList(
                "Ana are mere",
                "Ion are pere",
                "Maria invata Java",
                "Proiectare software laborator trei"
        );

        try {
            // Scriere in fisier
            Files.write(inputPath, liniiInitiale);
            System.out.println("Fisierul in.txt a fost creat.");

            // Citire din fisier
            List<String> liniiCitite = Files.readAllLines(inputPath);

            System.out.println("\n=== Continut fisier ===");
            for (String linie : liniiCitite) {
                System.out.println(linie);
            }

            // Split pe cuvinte
            List<String> cuvinte = new ArrayList<>();

            for (String linie : liniiCitite) {
                String[] parti = linie.split("\\s+");
                cuvinte.addAll(Arrays.asList(parti));
            }

            System.out.println("\n=== Cuvinte nesortate ===");
            System.out.println(cuvinte);

            // Sortare
            Collections.sort(cuvinte);

            System.out.println("\n=== Cuvinte sortate ===");
            System.out.println(cuvinte);

            // Scriere rezultat sortat in out.txt
            try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
                writer.write("Cuvinte sortate:");
                writer.newLine();

                for (String cuvant : cuvinte) {
                    writer.write(cuvant);
                    writer.newLine();
                }
            }

            System.out.println("\nFisierul out.txt a fost creat.");

        } catch (IOException e) {
            System.out.println("A aparut o eroare la lucrul cu fisierele.");
            e.printStackTrace();
        }
    }
}