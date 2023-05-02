import java.io.*; 
import java.util.*;

public class Generator {
    public static void main(String args[]){
        try {
            File file = new File("test.txt");
            Scanner filein = new Scanner(file);

            while (filein.hasNext()){
                String currentLine = filein.nextLine();
                String[] temp_list = currentLine.split(" ");

                System.out.println(Array.toString(temp_list));
                // for (String item : temp_list) {
                //     System.out.println(item);
                // }
            }
        }
        catch(FileNotFoundException e){

        }

    }
}