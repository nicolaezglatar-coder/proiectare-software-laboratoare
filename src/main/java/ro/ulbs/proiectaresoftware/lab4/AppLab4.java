package ro.ulbs.proiectaresoftware.lab4;

import java.util.HashMap;
import java.util.Map;

public class AppLab4 {
    public static void main(String[] args) {
        HashMap<String, Integer> varste = new HashMap<>();

        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);

        Map<String, String> adrese = Map.of(
                "Ioan", "Sibiu",
                "Maria", "Bucuresti",
                "Victor", "Cluj",
                "Simina", "Alba-Iulia",
                "Marius", "Medias",
                "Mihai", "Cisnadie",
                "Daniela", "Sibiu"
        );

        System.out.println("varste initial:");
        System.out.println(varste);

        varste.put("Vlad", 19);
        varste.put("Iulia", 19);

        System.out.println("varste dupa adaugare:");
        System.out.println(varste);

        HashMap<String, Tanar> tineri = new HashMap<>();

        for (String nume : varste.keySet()) {
            String adresa = adrese.get(nume);
            Tanar tanar = new Tanar(nume, varste.get(nume), adresa);
            tineri.put(nume, tanar);
        }

        System.out.println("tineri:");
        for (Map.Entry<String, Tanar> entry : tineri.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}