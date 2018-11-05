import java.io.IOException;
import java.util.Date;

import static org.quartz.DateBuilder.dateOf;

public class Time {
    public static Boolean Przerwa (Date teraz) {
        if (teraz.after(dateOf(00, 00,00)) && teraz.before(dateOf(8, 15, 00)) ||
        teraz.after(dateOf(9,45,00)) && teraz.before(dateOf(10,00, 00)) ||
        teraz.after(dateOf(11,30, 00)) && teraz.before(dateOf(11,45,00))){
            return true;
        }
        else{
            return false;
        }
    }

        public static void main(String[] args) throws IOException {
            Date teraz = new Date();
            if(Przerwa(teraz)){
                System.out.println("Przerrrwa");
            }
            else{
                System.out.println("Chuj");
            }

    }
}
