package ro.ulbs.proiectaresoftware.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ApplicationLab2 {
    public static void main(String[] args) {

        // Primitive
        int varsta = 20;
        long populatie = 19000000L;
        float medieFloat = 8.75f;
        double medieDouble = 9.25;
        char litera = 'A';
        byte nota = 10;

        System.out.println("=== Primitive ===");
        System.out.println("int: " + varsta);
        System.out.println("long: " + populatie);
        System.out.println("float: " + medieFloat);
        System.out.println("double: " + medieDouble);
        System.out.println("char: " + litera);
        System.out.println("byte: " + nota);

        // Conversie String -> int / double
        String numarText = "123";
        int numar = Integer.parseInt(numarText);

        String doubleText = "45.67";
        double valoare = Double.parseDouble(doubleText);

        System.out.println("\n=== Conversii ===");
        System.out.println("String -> int: " + numar);
        System.out.println("String -> double: " + valoare);

        // List cu ArrayList
        List<String> studenti = new ArrayList<>();

        studenti.add("Ion");
        studenti.add("Maria");
        studenti.add("Andrei");
        studenti.add("Elena");
        studenti.add("Maria");

        System.out.println("\n=== ArrayList ===");
        System.out.println("Lista initiala: " + studenti);
        System.out.println("Primul student: " + studenti.get(0));
        System.out.println("Contine Maria? " + studenti.contains("Maria"));
        System.out.println("Dimensiune lista: " + studenti.size());

        studenti.remove("Ion");
        System.out.println("Dupa stergere Ion: " + studenti);

        Collections.sort(studenti);
        System.out.println("Lista sortata: " + studenti);

        System.out.println("\nParcurgere cu for-each:");
        for (String student : studenti) {
            System.out.println(student);
        }

        System.out.println("\nParcurgere cu Iterator:");
        Iterator<String> iterator = studenti.iterator();
        while (iterator.hasNext()) {
            String student = iterator.next();
            System.out.println(student);
        }

        // LinkedList
        List<String> discipline = new LinkedList<>();

        discipline.add("Java");
        discipline.add("Baze de date");
        discipline.add("Proiectare software");

        System.out.println("\n=== LinkedList ===");
        System.out.println(discipline);

        // Set - nu permite duplicate
        Set<String> numeUnice = new HashSet<>();

        numeUnice.add("Ion");
        numeUnice.add("Maria");
        numeUnice.add("Ion");
        numeUnice.add("Andrei");

        System.out.println("\n=== HashSet ===");
        System.out.println("Set fara duplicate: " + numeUnice);

        // Stream simplu
        System.out.println("\n=== Stream ===");
        studenti.stream()
                .filter(s -> s.startsWith("M") || s.startsWith("A"))
                .forEach(s -> System.out.println("Student filtrat: " + s));
    }
}