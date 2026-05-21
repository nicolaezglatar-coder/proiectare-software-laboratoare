package ro.ulbs.proiectaresoftware.lab1;

public class ApplicationLab1 {
    public static void main(String[] args) {
        String alfabet = "";

        // Generam literele alfabetului folosind for
        for (char c = 'a'; c <= 'z'; c++) {
            alfabet = alfabet + c;
        }

        // Afisam alfabetul cu litere mici si cu majuscule
        System.out.println(alfabet.toLowerCase());
        System.out.println(alfabet.toUpperCase());

        // Cream array-ul cerut
        String[] array = new String[5];

        int pozitieStart = -1;
        int indexArray = 0;

        for (int i = 0; i < alfabet.length(); i++) {
            char litera = alfabet.charAt(i);

            if (litera == 'a' || litera == 'e' || litera == 'i'
                    || litera == 'o' || litera == 'u') {

                if (pozitieStart != -1) {
                    array[indexArray] = alfabet.substring(pozitieStart, i);
                    indexArray++;
                }

                pozitieStart = i;
            }
        }

        // Ultima secventa, de la ultima vocala pana la final
        if (pozitieStart != -1) {
            array[indexArray] = alfabet.substring(pozitieStart);
        }

        // Afisam array-ul
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] = \"" + array[i] + "\";");
        }
    }
}