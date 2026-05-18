package ro.ulbs.proiectaresoftware.lab4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Student {
    private String nume;
    private int varsta;
    private double medie;

    public Student(String nume, int varsta, double medie) {
        this.nume = nume;
        this.varsta = varsta;
        this.medie = medie;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public double getMedie() {
        return medie;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", medie=" + medie +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;

        return varsta == other.varsta &&
                Double.compare(other.medie, medie) == 0 &&
                Objects.equals(nume, other.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, varsta, medie);
    }
}

class Box<T> {
    private T valoare;

    public Box(T valoare) {
        this.valoare = valoare;
    }

    public T getValoare() {
        return valoare;
    }

    public void setValoare(T valoare) {
        this.valoare = valoare;
    }

    @Override
    public String toString() {
        return "Box{" +
                "valoare=" + valoare +
                '}';
    }
}

public class ApplicationLab4 {
    public static void main(String[] args) {

        System.out.println("=== Map ===");

        Map<String, Student> studenti = new HashMap<>();

        studenti.put("S1", new Student("Ion", 20, 8.50));
        studenti.put("S2", new Student("Maria", 21, 9.75));
        studenti.put("S3", new Student("Andrei", 22, 7.80));

        System.out.println("Student cu cheia S1:");
        System.out.println(studenti.get("S1"));

        System.out.println("\nParcurgere Map:");
        for (String cheie : studenti.keySet()) {
            System.out.println(cheie + " -> " + studenti.get(cheie));
        }

        System.out.println("\nParcurgere cu entrySet:");
        for (Map.Entry<String, Student> entry : studenti.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("\nContine cheia S2? " + studenti.containsKey("S2"));
        System.out.println("Contine valoarea Maria? " + studenti.containsValue(new Student("Maria", 21, 9.75)));

        studenti.remove("S3");

        System.out.println("\nDupa stergere S3:");
        System.out.println(studenti);

        System.out.println("\n=== Generics ===");

        Box<Integer> cutieInt = new Box<>(100);
        Box<String> cutieString = new Box<>("Salut Java");
        Box<Student> cutieStudent = new Box<>(new Student("Elena", 20, 10.00));

        System.out.println(cutieInt);
        System.out.println(cutieString);
        System.out.println(cutieStudent);

        System.out.println("\n=== equals si hashCode ===");

        Student student1 = new Student("Ana", 20, 9.50);
        Student student2 = new Student("Ana", 20, 9.50);
        Student student3 = new Student("Mihai", 21, 8.00);

        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);
        System.out.println("student3: " + student3);

        System.out.println("student1 equals student2: " + student1.equals(student2));
        System.out.println("student1 equals student3: " + student1.equals(student3));

        System.out.println("hashCode student1: " + student1.hashCode());
        System.out.println("hashCode student2: " + student2.hashCode());
        System.out.println("hashCode student3: " + student3.hashCode());
    }
}