import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] arg)  {
        new Main().entrance();





    }
    ArrayList<TwoPort> elements = new ArrayList<TwoPort>();
    void entrance () {
        File file = new File("entrance.txt") ;
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(file));
            String temp;
            while (!(temp = in.readLine()).equals("END")) {
                if (temp.charAt(0) != '*') {
                    if (temp.charAt(0) == 'R'){
                        elements.add(new Resistance(temp));
                    }
                    if (temp.charAt(0) == 'C'){
                        elements.add(new Capacitor(temp));
                    }
                    if (temp.charAt(0) == 'L'){
                        elements.add(new Inductor(temp));
                    }

                }

            }
        }
     catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
