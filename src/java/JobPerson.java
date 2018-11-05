import org.quartz.JobExecutionContext;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class JobPerson implements org.quartz.Job{


        public void execute(JobExecutionContext jobExecutionContext) {

            String a = Person.getAviva();


            try {
                File plik = new File("C:\\Users\\Malwina\\Desktop\\SpisLudnosci.txt");
                plik.createNewFile();
                PrintWriter out = new PrintWriter("C:\\Users\\Malwina\\Desktop\\SpisLudnosci.txt");
                out.print(a);
                out.close();
            } catch (
                    IOException e) {
                e.printStackTrace();
                System.out.println("Nie wykonano");

            }
        }
    }
//        public static void toFile(String data) throws IOException {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("odp.txt"));
//            writer.write(data);
//            writer.close();
//            FileReader fileReader = new FileReader("odp.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String input;
//            List<String> lineList =new ArrayList<String>();
//            while((input = bufferedReader.readLine())!= null)
//            {
//                lineList.add(input);
//
//            }
//            fileReader.close();
//
//            Collections.sort(lineList);
//            Writer fileWriter =new FileWriter("odp.txt");
//            PrintWriter out = new PrintWriter(fileWriter);
//            for(String outputLine : lineList)
//            {
//                out.println(outputLine);
//                out.println();
//            }
//
//            out.flush();
//            out.close();
//            fileWriter.close();
//
//
//        }}
