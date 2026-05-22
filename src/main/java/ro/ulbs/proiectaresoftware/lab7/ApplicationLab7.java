package ro.ulbs.proiectaresoftware.lab7;

import ro.ulbs.proiectaresoftware.lab7.forms.Circle;
import ro.ulbs.proiectaresoftware.lab7.forms.Form;
import ro.ulbs.proiectaresoftware.lab7.forms.Square;
import ro.ulbs.proiectaresoftware.lab7.forms.Triangle;
import ro.ulbs.proiectaresoftware.lab7.util.PasswordMaker;

import java.util.ArrayList;
import java.util.List;

public class ApplicationLab7 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(1.1F, 2.0F, "red");
        Circle circle = new Circle(1.5F, "yellow");
        Square square = new Square(1.2F, "blue");

        System.out.println("Area = " + triangle.getArea() + " details: " + triangle);
        System.out.println("Area = " + circle.getArea() + " details: " + circle);
        System.out.println("Area = " + square.getArea() + " details: " + square);

        System.out.println("Total instance count is " + Form.getInstanceCount());

        PasswordMaker passwordMaker1 = PasswordMaker.getInstance();
        PasswordMaker passwordMaker2 = PasswordMaker.getInstance();

        System.out.println("Same singleton instance? " + (passwordMaker1 == passwordMaker2));
        System.out.println("Generated password: " + passwordMaker1.getPassword("Nicolae"));

        System.out.println();
        System.out.println("7.6.3 Imutabilitate");

        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student(112, "Ioan", "Popa", "TI21"));
        studenti.add(new Student(113, "Maria", "Oprea", "TI21"));
        studenti.add(new Student(120, "Alis", "Popa", "TI21"));
        studenti.add(new Student(122, "Mihai", "Vecerdea", "TI21"));
        studenti.add(new Student(123, "Eugen", "Uritescu", "TI21"));

        System.out.println("Lista initiala:");
        for (Student student : studenti) {
            System.out.println(student);
        }

        List<Student> listaNoua = imparteInDouaFormatii(studenti, "TI211/1", "TI211/2");

        System.out.println();
        System.out.println("Lista dupa impartirea in doua formatii:");
        for (Student student : listaNoua) {
            System.out.println(student);
        }
    }

    public static Student mutaStudent(Student student, String nouaFormatie) {
        return new Student(
                student.getNumarMatricol(),
                student.getPrenume(),
                student.getNume(),
                nouaFormatie
        );
    }

    public static List<Student> imparteInDouaFormatii(List<Student> studenti, String formatia1, String formatia2) {
        List<Student> rezultat = new ArrayList<>();

        int limitaPrimaFormatie = (studenti.size() + 1) / 2;

        for (int i = 0; i < studenti.size(); i++) {
            Student student = studenti.get(i);

            if (i < limitaPrimaFormatie) {
                rezultat.add(mutaStudent(student, formatia1));
            } else {
                rezultat.add(mutaStudent(student, formatia2));
            }
        }

        return rezultat;
    }
}