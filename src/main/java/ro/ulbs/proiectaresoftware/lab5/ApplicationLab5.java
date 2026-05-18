package ro.ulbs.proiectaresoftware.lab5;

class IntCalculator {
    private int state;

    public IntCalculator(int state) {
        this.state = state;
    }

    public IntCalculator add(int value) {
        state += value;
        return this;
    }

    public IntCalculator subtract(int value) {
        state -= value;
        return this;
    }

    public IntCalculator multiply(int value) {
        state *= value;
        return this;
    }

    public int result() {
        return state;
    }

    public IntCalculator clear() {
        state = 0;
        return this;
    }
}

abstract class Forma {
    public abstract String getName();

    public abstract double getArea();

    @Override
    public String toString() {
        return getName() + " area=" + getArea();
    }
}

class Patrat extends Forma {
    private double latura;

    public Patrat(double latura) {
        this.latura = latura;
    }

    @Override
    public String getName() {
        return "Patrat";
    }

    @Override
    public double getArea() {
        return latura * latura;
    }
}

class Dreptunghi extends Forma {
    private double lungime;
    private double latime;

    public Dreptunghi(double lungime, double latime) {
        this.lungime = lungime;
        this.latime = latime;
    }

    @Override
    public String getName() {
        return "Dreptunghi";
    }

    @Override
    public double getArea() {
        return lungime * latime;
    }
}

class User {
    private String nume;
    private int varsta;
    private String email;

    private User(String nume, int varsta, String email) {
        this.nume = nume;
        this.varsta = varsta;
        this.email = email;
    }

    public static class Builder {
        private String nume;
        private int varsta;
        private String email;

        public Builder setNume(String nume) {
            this.nume = nume;
            return this;
        }

        public Builder setVarsta(int varsta) {
            this.varsta = varsta;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(nume, varsta, email);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", email='" + email + '\'' +
                '}';
    }
}

public class ApplicationLab5 {
    public static void main(String[] args) {

        System.out.println("=== Method chaining ===");

        IntCalculator calculator = new IntCalculator(10);

        int rezultat = calculator
                .add(5)
                .subtract(3)
                .multiply(2)
                .result();

        System.out.println("Rezultat calculator: " + rezultat);

        int rezultatDupaClear = calculator
                .clear()
                .add(100)
                .subtract(40)
                .result();

        System.out.println("Rezultat dupa clear: " + rezultatDupaClear);

        System.out.println("\n=== Abstractizare si mostenire ===");

        Forma patrat = new Patrat(5);
        Forma dreptunghi = new Dreptunghi(4, 6);

        System.out.println(patrat);
        System.out.println(dreptunghi);

        System.out.println("\n=== Builder Pattern ===");

        User user = new User.Builder()
                .setNume("Nicolae")
                .setVarsta(20)
                .setEmail("nicolae@email.com")
                .build();

        System.out.println(user);
    }
}