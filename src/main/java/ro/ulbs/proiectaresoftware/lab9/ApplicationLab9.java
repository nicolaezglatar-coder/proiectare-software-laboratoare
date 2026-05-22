package ro.ulbs.proiectaresoftware.lab9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class ApplicationLab9 {
    public static void main(String[] args) {
        problema931();

        System.out.println("-----------------------------------------");

        problema932();
    }

    public static void problema931() {
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(random.nextInt(21) + 5);
        }

        System.out.println("9.3.1");
        System.out.println("Lista initiala:");
        System.out.println(lista);

        int suma = lista.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("a) Suma elementelor: " + suma);

        Optional<Integer> maxim = lista.stream()
                .max(Integer::compareTo);

        Optional<Integer> minim = lista.stream()
                .min(Integer::compareTo);

        if (maxim.isPresent()) {
            System.out.println("b) Maxim: " + maxim.get());
        }

        if (minim.isPresent()) {
            System.out.println("b) Minim: " + minim.get());
        }

        List<Integer> listaInterval = lista.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());

        System.out.println("c) Elemente in intervalul [10..20]:");
        System.out.println(listaInterval);

        List<Double> listaDouble = lista.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());

        System.out.println("d) Lista de valori Double:");
        System.out.println(listaDouble);

        boolean contine12 = lista.stream()
                .anyMatch(n -> n == 12);

        System.out.println("e) Lista contine valoarea 12: " + contine12);
    }

    public static void problema932() {
        String text = "Acesta este un program scris in java pentru expresii lambda";

        List<String> cuvinte = Arrays.asList(text.split(" "));

        System.out.println("9.3.2");
        System.out.println("Lista initiala:");
        System.out.println(cuvinte);

        List<String> listaFiltrata = cuvinte.stream()
                .filter(cuvant -> cuvant.length() >= 5)
                .collect(Collectors.toList());

        long numarCuvinte = listaFiltrata.stream()
                .count();

        System.out.println("a) Numar cuvinte cu lungime >= 5: " + numarCuvinte);
        System.out.println("a) Lista filtrata:");
        System.out.println(listaFiltrata);

        List<String> listaSortata = listaFiltrata.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("b) Lista sortata:");
        System.out.println(listaSortata);

        Optional<String> cuvantCuP = cuvinte.stream()
                .filter(cuvant -> cuvant.startsWith("p"))
                .findFirst();

        if (cuvantCuP.isPresent()) {
            System.out.println("c) Cuvant care incepe cu litera p: " + cuvantCuP.get());
        } else {
            System.out.println("c) Nu exista cuvant care incepe cu litera p.");
        }
    }
}