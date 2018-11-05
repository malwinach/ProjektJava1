import org.quartz.JobExecutionContext;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JobPerson implements org.quartz.Job{


        public void execute(JobExecutionContext jobExecutionContext) {

            String a = Person.getAviva();


            try {
                File plik = new File("SpisLudnosci.txt");
                plik.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter("SpisLudnosci.txt"));
                writer.write(a);
                writer.close();
                System.out.println("Zaktualizowano plik.");
            }
            catch (
                    IOException e) {
                e.printStackTrace();
                System.out.println("Nie wykonano");

            }
        }
    }

