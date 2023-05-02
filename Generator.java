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
                System.out.println(temp_ArrayList);

                String result = "";
                for (String string : temp_ArrayList) {
                    result += string + " ";
                }

                writer.println(result);

            }
            filein.close();
            writer.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}