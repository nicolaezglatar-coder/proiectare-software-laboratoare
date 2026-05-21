package ro.ulbs.proiectaresoftware.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ApplicationLab2 {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>(); // a
        Set<Integer> zSet = new TreeSet<>(); // b
        List<Integer> xMinusY = new ArrayList<>(); // c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>(); // d

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            x.add(random.nextInt(11));
        }

        for (int i = 0; i < 7; i++) {
            y.add(random.nextInt(11));
        }

        Collections.sort(x);
        Collections.sort(y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);

        for (Integer element : x) {
            if (y.contains(element)) {
                zSet.add(element);
            }
        }

        for (Integer element : x) {
            if (!y.contains(element)) {
                xMinusY.add(element);
            }
        }

        Collections.sort(xMinusY);

        for (Integer element : xPlusY) {
            if (element <= p) {
                xPlusYLimitedByP.add(element);
            }
        }

        Collections.sort(xPlusYLimitedByP);

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("p = " + p);

        System.out.println("a) xPlusY = " + xPlusY);
        System.out.println("b) zSet = " + zSet);
        System.out.println("c) xMinusY = " + xMinusY);
        System.out.println("d) xPlusYLimitedByP = " + xPlusYLimitedByP);
    }
}