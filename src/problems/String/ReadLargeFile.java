package problems.String;

import java.io.*;
import java.util.List;
import java.util.PriorityQueue;

public class ReadLargeFile {

   static PriorityQueue<String> sorted = new PriorityQueue<>();

    public static void readFile(String path){
            //this reads large file line by line
           try ( BufferedReader reader = new BufferedReader(new FileReader(path))){
           String line = null;
            while(reader.readLine() != null){
                line = reader.readLine();
                sorted.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void readFiles(List<String> path){

        for(int i=0; i<path.size(); i++){
            readFile(path.get(i));
        }

        while(!sorted.isEmpty()){
            System.out.println(sorted.poll());
        }
    }



    /**
     * for binary files use FIS
     * @param filePath
     */
    public void readFileFIS(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                // Process each chunk
                System.out.println("Read " + bytesRead + " bytes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
