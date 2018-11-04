import java.io.*;
import java.util.*;
import org.eclipse.collections.impl.multimap.list;



public class Person {
    public static void main(String[] args) throws IOException {
        File plik = new File("C:\\Users\\Malwina\\Desktop\\SpisLudnosci.txt");
        plik.createNewFile();
        FileWriter fw = new FileWriter(plik);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter("C:\\Users\\Malwina\\Desktop\\SpisLudnosci.txt");
        Map<String, String> Dane = new HashMap<String, String>();
        List lista = new ArrayList();
        FastListMultimap<String, String> citiesToPeople = FastListMultimap.newMultimap();

        while(true){
            System.out.print("Wprowadź miasto:");
            Scanner odczyt = new Scanner(System.in);
            String miasto = odczyt.nextLine();
            if(miasto.equals("exit")) {
                out.close();
                System.exit(0);
            }
            else{
                System.out.print("Wprowadź pozostałe dane:");
                Scanner dane = new Scanner(System.in);
                String imiepesel = dane.nextLine();
                String[] splited = imiepesel.split(" ");
                String imie = splited[0];
                String nazwisko = splited[1];
                String pesel = splited[2];
                if(pesel.length()!= 11){
                    System.out.println("Numer PESEL jest nieprawidłowy.");
                }
                else{
                    int suma = (
                            Character.getNumericValue(pesel.charAt(0))
                                    +Character.getNumericValue(pesel.charAt(1))*3
                                    +Character.getNumericValue(pesel.charAt(2))*7
                                    +Character.getNumericValue(pesel.charAt(3))*9
                                    +Character.getNumericValue(pesel.charAt(4))
                                    +Character.getNumericValue(pesel.charAt(5))*3
                                    +Character.getNumericValue(pesel.charAt(6))*7
                                    +Character.getNumericValue(pesel.charAt(7))*9
                                    +Character.getNumericValue(pesel.charAt(8))
                                    +Character.getNumericValue(pesel.charAt(9))*3
                                    +Character.getNumericValue(pesel.charAt(10)));
                    if(suma%10!=0) {
                        System.out.print("Numer PESEL jest nieprawidłowy.");
                    }
                    else{
                        //bw.append(imiepesel + "\n");
                        //bw.flush();
                        Dane.put(pesel, miasto + " " + imie + " " + nazwisko);
                        lista.add(Dane);
                        System.out.println(lista);
                        out.println(miasto + ":");
                        out.println(imiepesel + "\n");
                    }
                }

            }

        }

    }
}