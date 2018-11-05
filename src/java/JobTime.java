import org.quartz.JobExecutionContext;

import java.util.Date;

public class JobTime implements org.quartz.Job{


    public void execute(JobExecutionContext jobExecutionContext) {


            Date teraz = new Date();
            Date NajblizszeZajecia = new Date();
            Date NajblizszaPrzerwa = new Date();
            long X, czas1, czas2;
            if (Time.Przerwa(teraz)) {
                NajblizszeZajecia = Time.ClosestClass(teraz);
                czas1 = teraz.getTime();
                czas2 = NajblizszeZajecia.getTime();
                X = (czas2 - czas1) / 60000;
                System.out.print(NajblizszeZajecia);
                System.out.println(X + " minut do końca przerwy.");
            } else if (Time.PoZajeciach(teraz)) {
                czas1 = teraz.getTime();
                czas2 = NajblizszeZajecia.getTime();
                X = ((czas2 - czas1) / 60000) + 1440;
                System.out.println(X + " minut do końca przerwy.");
            } else {
                NajblizszaPrzerwa = Time.ClosestPeriod(teraz);
                czas1 = teraz.getTime();
                czas2 = NajblizszaPrzerwa.getTime();
                X = (czas2 - czas1) / 60000;
                System.out.println(X + " minut do końca zajęć.");
            }
    }
}

