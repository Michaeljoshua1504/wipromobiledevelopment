import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class fh {
    public static void main(String[] args) throws Exception {
        /* int ch;
        FileReader fr = new FileReader(new File("./meow.txt"));
        while ((ch=fr.read()) != -1) {
            System.out.print((char) ch);
        }

        fr.close(); */
        /* Scanner sc = new Scanner(new File("./meow.txt"));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
        InputStreamReader isr = new InputStreamReader(new FileInputStream("./meow.txt"));
        BufferedReader br = new BufferedReader(isr);

        br.lines().forEach(System.out::println);
        br.close(); */

        /* FileWriter fr = new FileWriter(new File("./meow.txt"));
        String str = "This is my new text";

        for (int i = 0; i < str.length(); i++) {
            // fr.write(str.charAt(i));
        }

        fr.close(); */

        
        File f = new File("./meow.txt");
        InputStreamReader isr = new InputStreamReader(new FileInputStream("./meow.txt"));
        BufferedReader br = new BufferedReader(isr);

        br.lines().filter(name -> name.startsWith("A"))
            .forEach(System.out::println);



    }
}