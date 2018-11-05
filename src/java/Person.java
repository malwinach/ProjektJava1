import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import java.io.*;
import java.util.*;


public class Person {

    public static String aviva = new String();

    public static String getAviva() {
        return aviva;
    }

    public static Boolean isValidPesel (String pesel){
        if (pesel.length() != 11) {
            return false;
        }
        else {
            int suma = (
                    Character.getNumericValue(pesel.charAt(0))
                            + Character.getNumericValue(pesel.charAt(1)) * 3
                            + Character.getNumericValue(pesel.charAt(2)) * 7
                            + Character.getNumericValue(pesel.charAt(3)) * 9
                            + Character.getNumericValue(pesel.charAt(4))
                            + Character.getNumericValue(pesel.charAt(5)) * 3
                            + Character.getNumericValue(pesel.charAt(6)) * 7
                            + Character.getNumericValue(pesel.charAt(7)) * 9
                            + Character.getNumericValue(pesel.charAt(8))
                            + Character.getNumericValue(pesel.charAt(9)) * 3
                            + Character.getNumericValue(pesel.charAt(10)));
            if (suma % 10 != 0) {
                return false;
            }
            else {
                return true;
            }
        }
    }

    public static String ToPrint(String linia){
        linia=linia.replace("[", "");
        linia=linia.replace(":", ":\n");
        linia=linia.replace(", ", "\n");
        linia=linia.replace("]", " ");
        return linia;
    }

    public static void main(String[] args) throws IOException {


        Map<String, String> mapa = new HashMap<String, String>();
        FastListMultimap<String, String> Dane = FastListMultimap.newMultimap();
        String DoZapisu = new String();
        while (true) {
            System.out.println("Wprowadź miasto:");
            Scanner odczyt = new Scanner(System.in);
            String miasto = odczyt.nextLine();
            if (miasto.equals("exit")) {
                DoZapisu=(Dane.keyMultiValuePairsView().toString());
                DoZapisu=ToPrint(DoZapisu);
                aviva = DoZapisu;


                System.exit(0);
            }
            else {
                System.out.println("Wprowadź pozostałe dane:");
                Scanner dane = new Scanner(System.in);
                String imiepesel = dane.nextLine();
                String[] splited = imiepesel.split(" ");
                if (splited.length != 3) {
                    System.out.println("Błędna ilość danych.");
                }
                else {
                    String imie = splited[0];
                    String nazwisko = splited[1];
                    String pesel = splited[2];

                    if (!isValidPesel(pesel)) {
                        System.out.println("Numer PESEL jest nieprawidłowy.");
                    }
                    else {
                        Dane.put(miasto, imiepesel);
                    }
                }
            }

        }

    }
}
