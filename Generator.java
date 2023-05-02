import java.io.*;
import java.util.*;

public class Generator {
    public static void main(String args[]){
        try {
            File file = new File("test.txt");
            Scanner filein = new Scanner(file);

            PrintStream writer = new PrintStream(new FileOutputStream("output.txt") , false);
            while (filein.hasNext()){
                String currentLine = filein.nextLine();
                String edited = currentLine.replaceAll("\\s+", " ");
                String[] temp_list = edited.split(" ");

                // convert array to arraylist
                ArrayList<String> temp_ArrayList = new ArrayList<String>();

                for (String item : temp_list) {
                    temp_ArrayList.add(item);
                }

                for (int i = 0 ; i < temp_ArrayList.size() ; i += 1){
                    String item = temp_list[i];

                    if (item.contains("MC")){
                        String new_item = temp_ArrayList.get(i) + " " + temp_ArrayList.get(i + 1);
                        temp_ArrayList.remove(i + 1);
                        temp_ArrayList.set(i , new_item);
                    }
                }
                
                // specify a fixed width for each column in the output
                String formattedLine = String.format("%-4s%-8s%-15s%-15s%-16s", temp_ArrayList.get(0), temp_ArrayList.get(1), temp_ArrayList.get(2), temp_ArrayList.get(3), temp_ArrayList.get(4));
                writer.println(formattedLine);

            }
            filein.close();
            writer.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}

    
    
        
    
