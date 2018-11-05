import org.quartz.JobExecutionContext;
import java.io.IOException;
import java.util.Date;

public class JobPerson implements org.quartz.Job{


    public void execute(JobExecutionContext jobExecutionContext) {

        String a = Person.getAviva();


        try {
            Date teraz = new Date();
            Date NajblizszeZajecia = new Date();
            Date NajblizszaPrzerwa = new Date();
            Time X = new Time();
            if(Time.Przerwa(teraz)){
                NajblizszeZajecia = Time.ClosestClass(teraz);
                // X = Roznica(teraz, NajblizszeZajecia);
                System.out.print(NajblizszeZajecia)
                System.out.println("X" + "minut do końca przerwy.");
            }
            else if(Time.PoZajeciach(teraz)) {
                //
                System.out.println("X" + "minut do końca przerwy.")
            }
            else {
                NajblizszaPrzerwa = Time.ClosestPeriod(teraz);
                // X = Roznica(teraz, NajblizszaPrzerwa)
                System.out.println("X" + "minut do końca zajęć.");
                System.out.println("Zaktualizowano plik.");
            }
        }
        catch (
                IOException e) {
            e.printStackTrace();
            System.out.println("Nie wykonano.");

        }
    }
}

