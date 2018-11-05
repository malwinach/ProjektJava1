import java.io.IOException;
import java.util.Date;

import static org.quartz.DateBuilder.dateOf;

public class Time {
    public static Boolean Przerwa (Date teraz) {
        if (teraz.after(dateOf(00, 00, 00)) && teraz.before(dateOf(8, 15, 00)) ||
            teraz.after(dateOf(9, 45, 00)) && teraz.before(dateOf(10, 00, 00)) ||
            teraz.after(dateOf(11, 30, 00)) && teraz.before(dateOf(11, 45, 00)) ||
            teraz.after(dateOf(13, 15, 00)) && teraz.before(dateOf(13, 45, 00)) ||
            teraz.after(dateOf(15, 15, 00)) && teraz.before(dateOf(15, 30, 00)) ||
            teraz.after(dateOf(17, 00, 00)) && teraz.before(dateOf(17, 15, 00))){
            return true;
        }
        else{
            return false;
        }
    }

    public static Boolean PoZajeciach (Date teraz) {
        if (teraz.after(dateOf(18, 45, 00)) && teraz.before(dateOf(23, 59, 00))) {
            return true;
        } else {
            return false;
        }
    }

    public static Date ClosestClass(Date teraz){
        Date Closest;
        if(teraz.after(dateOf(00, 00,00)) && teraz.before(dateOf(8, 15, 00))){
            Closest = dateOf((8,15,00));
        }
        else if(teraz.after(dateOf(9, 45,00)) && teraz.before(dateOf(10, 00, 00))){
            Closest = dateOf(10, 00, 00);
        }
        else if(teraz.after(dateOf(11, 30,00)) && teraz.before(dateOf(11, 45, 00))){
            Closest = dateOf(11, 45, 00);
        }
        else if(teraz.after(dateOf(13, 15,00)) && teraz.before(dateOf(13, 45, 00))){
            Closest = dateOf(13, 45, 00);
        }
        else if(teraz.after(dateOf(15, 15,00)) && teraz.before(dateOf(15, 30, 00))) {
            Closest = dateOf(15, 30, 00);
        }
        else if(teraz.after(dateOf(17, 00,00)) && teraz.before(dateOf(17, 15, 00))){
            Closest = dateOf(17, 15, 00);
        }
        else if(teraz.after(dateOf(18, 45,00)) && teraz.before(dateOf(23, 59, 00))){
         // THE NEXT DAY 8:15  ClosestPeriod = dateOf(10, 30, 00);
        }
        return Closest;
    }

    public static Date ClosestPeriod(Date teraz){
        Date ClosestPeriod;
        if(teraz.after(dateOf(8, 15,00)) && teraz.before(dateOf(9, 45, 00))){
            ClosestPeriod = dateOf((9,45,00));
        }
        else if(teraz.after(dateOf(10, 00,00)) && teraz.before(dateOf(11, 30, 00))){
            ClosestPeriod = dateOf(11, 30, 00);
        }
        else if(teraz.after(dateOf(11, 45,00)) && teraz.before(dateOf(13, 15, 00))){
            ClosestPeriod = dateOf(13, 15, 00);
        }
        else if(teraz.after(dateOf(13, 45,00)) && teraz.before(dateOf(15, 15, 00))){
            ClosestPeriod = dateOf(15, 15, 00);
        }
        else if(teraz.after(dateOf(15, 30,00)) && teraz.before(dateOf(17, 00, 00))) {
            ClosestPeriod = dateOf(17, 00, 00);
        }
        else if(teraz.after(dateOf(17, 15,00)) && teraz.before(dateOf(18, 45, 00))){
            ClosestPeriod = dateOf(18, 45, 00);
        }
        return ClosestPeriod;
    }

        public static void main(String[] args) throws IOException {
            Date teraz = new Date();
            Date NajblizszeZajecia = new Date();
            Date NajblizszaPrzerwa = new Date();
            Time X = new Time();
            if(Przerwa(teraz)){
                NajblizszeZajecia = ClosestClass(teraz);
                // X = Roznica(teraz, NajblizszeZajecia);
                System.out.print(NajblizszeZajecia)
                System.out.println("X" + "minut do końca przerwy.");
            }
            else if(PoZajeciach(teraz)) {
                //
                System.out.println("X" + "minut do końca przerwy.")
            }
            else{
                NajblizszaPrzerwa = ClosestPeriod(teraz);
                // X = Roznica(teraz, NajblizszaPrzerwa)
                System.out.println("X" + "minut do końca zajęć.");
            }

    }
}
