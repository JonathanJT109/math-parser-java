package main;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String filePath = "src/assets/1.txt";
        Vector<String> lines = new Vector<>();
        try {
            FileReader myObj = new FileReader(filePath);

            BufferedReader myReader = new BufferedReader(myObj);

            String line;

            while ((line = myReader.readLine()) != null) {
                lines.add(line);
            }

            myReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s: lines) {
            System.out.println(s);
        }
    }
}