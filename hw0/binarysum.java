import java.io.*;

public class binarysum {
    public static void main(String[] args) {
        //System.out.println("program starts");
        
        // The name of the file to open.
        String fileName = args[0];

        // This will reference one line at a time
        String line = null;

        // Record the sum
        int sum = 0 ;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                sum = sum + Integer.parseInt(line,2);
            }    
            // Always close files.
            bufferedReader.close();            
            // print the sum
            System.out.println(sum);

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                   
            // Or we could just do this: 
            // ex.printStackTrace();
        }



    }

}

