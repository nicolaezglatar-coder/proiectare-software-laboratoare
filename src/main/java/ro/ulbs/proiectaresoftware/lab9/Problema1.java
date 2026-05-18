package ro.ulbs.proiectaresoftware.lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Problema1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }

        System.out.println("Lista initiala:");
        System.out.println(list);

        int sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Suma elementelor: " + sum);

        Optional<Integer> maxOptional = list.stream()
                .max(Integer::compareTo);

        if (maxOptional.isPresent()) {
            System.out.println("Maxim: " + maxOptional.get());
        }

        Optional<Integer> minOptional = list.stream()
                .min(Integer::compareTo);

        if (minOptional.isPresent()) {
            System.out.println("Minim: " + minOptional.get());
        }

        List<Integer> lista2 = list.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("Numere pare:");
        System.out.println(lista2);

        List<Double> lista3 = list.stream()
                .map(n -> Math.sqrt(n))
                .toList();

        System.out.println("Radacini patrate:");
        System.out.println(lista3);

        Optional<Integer> found = list.stream()
                .filter(n -> n > 50)
                .findFirst();

        if (found.isPresent()) {
            System.out.println("Primul numar mai mare decat 50: " + found.get());
        } else {
            System.out.println("Nu exista numar mai mare decat 50.");
        }
    }
}