package ro.ulbs.proiectaresoftware.lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class ApplicationLab9 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(random.nextInt(21) + 5);
        }

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
}