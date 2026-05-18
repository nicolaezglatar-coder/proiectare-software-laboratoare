package ro.ulbs.proiectaresoftware.lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Persoana {
    private String nume;
    private int varsta;

    public Persoana(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}

public class Problema2 {
    public static void main(String[] args) {
        List<Persoana> persoane = new ArrayList<>();

        persoane.add(new Persoana("Ion", 20));
        persoane.add(new Persoana("Maria", 25));
        persoane.add(new Persoana("Andrei", 17));
        persoane.add(new Persoana("Elena", 30));
        persoane.add(new Persoana("Mihai", 16));

        System.out.println("Lista initiala:");
        persoane.forEach(System.out::println);

        System.out.println("\nPersoane majore:");
        persoane.stream()
                .filter(p -> p.getVarsta() >= 18)
                .forEach(System.out::println);

        System.out.println("\nNumele persoanelor:");
        List<String> nume = persoane.stream()
                .map(Persoana::getNume)
                .collect(Collectors.toList());

        System.out.println(nume);

        System.out.println("\nPersoane sortate dupa varsta:");
        persoane.stream()
                .sorted(Comparator.comparingInt(Persoana::getVarsta))
                .forEach(System.out::println);

        long countMajori = persoane.stream()
                .filter(p -> p.getVarsta() >= 18)
                .count();

        System.out.println("\nNumar persoane majore: " + countMajori);

        boolean existaMinor = persoane.stream()
                .anyMatch(p -> p.getVarsta() < 18);

        System.out.println("Exista minor? " + existaMinor);
    }
}