import org.quartz.JobExecutionContext;

import java.util.Date;
import static org.quartz.DateBuilder.dateOf;

public class JobTime implements org.quartz.Job {


    public void execute(JobExecutionContext jobExecutionContext) {


        Date teraz = new Date();
        Date NajblizszeZajecia = new Date();
        Date NajblizszaPrzerwa = new Date();
        long X, czas1, czas2;
        int dzien = teraz.getDay();
        if (dzien == 5 && Time.PoZajeciach(teraz) || dzien == 6 || dzien == 7) {
            if (dzien == 5) {
                czas1 = teraz.getTime();
                NajblizszeZajecia = dateOf(00, 00, 00);
                czas2 = NajblizszeZajecia.getTime();
                X = ((czas2 - czas1) / 60000) + 3375;
                System.out.println(X + " minut do końca przerwy.");
            } else if (dzien == 6) {
                czas1 = teraz.getTime();
                NajblizszeZajecia = dateOf(00, 00, 00);
                czas2 = NajblizszeZajecia.getTime();
                X = ((czas2 - czas1) / 60000) + 1935;
                System.out.println(X + " minut do końca przerwy.");
            } else if (dzien == 7) {
                czas1 = teraz.getTime();
                NajblizszeZajecia = dateOf(00, 00, 00);
                czas2 = NajblizszeZajecia.getTime();
                X = ((czas2 - czas1) / 60000) + 495;
                System.out.println(X + " minut do końca przerwy.");
            }
        } else {

            if (Time.Przerwa(teraz)) {
                NajblizszeZajecia = Time.ClosestClass(teraz);
                czas1 = teraz.getTime();
                czas2 = NajblizszeZajecia.getTime();
                X = ((czas2 - czas1) / 60000) + 1;
                System.out.print(NajblizszeZajecia);
                System.out.println(X + " minut do końca przerwy.");
            } else if (Time.PoZajeciach(teraz)) {
                czas1 = teraz.getTime();
                NajblizszeZajecia = dateOf(00, 00, 00);
                czas2 = NajblizszeZajecia.getTime();
                X = ((czas2 - czas1) / 60000) + 495;
                System.out.println(X + " minut do końca przerwy.");
            } else {
                NajblizszaPrzerwa = Time.ClosestPeriod(teraz);
                czas1 = teraz.getTime();
                czas2 = NajblizszaPrzerwa.getTime();
                X = ((czas2 - czas1) / 60000) + 1;
                System.out.println(X + " minut do końca zajęć.");
            }
        }
    }
}

