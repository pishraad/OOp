import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] arg)  {
        Main.entrance();
//        for(int i=0 ; i<nodes.size();i++){
//            System.out.println(nodes.get(i).name + "node name");
//            for(int j=0 ; j<nodes.get(i).neighbor.size();j++){
//                System.out.println(nodes.get(i).neighbor.get(j).name);
//            }
//        }


        //dokw0k0w


    }
   static ArrayList<TwoPort> elements = new ArrayList<TwoPort>();
    static ArrayList<Node> nodes = new ArrayList<>() ;

    static void entrance () {
        File file = new File("entrance.txt") ;
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(file));
            String temp;
            while (!(temp = in.readLine()).equals("END")) {
                if (temp.charAt(0) != '*') {
                    if (temp.charAt(0) == 'R'){
                        elements.add(new Resistance(temp));
                        TwoPort.addNode(elements.get(elements.size()-1),nodes);
                    }
                    if (temp.charAt(0) == 'C'){
                        elements.add(new Capacitor(temp));
                        TwoPort.addNode(elements.get(elements.size()-1),nodes);
                    }
                    if (temp.charAt(0) == 'L'){
                        elements.add(new Inductor(temp));
                        TwoPort.addNode(elements.get(elements.size()-1),nodes);
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

    static void unionMaker(){
        ArrayList<Node> queue = new ArrayList<>();
        int groundIndex = 0 ;
        for (int i=0;i<nodes.size();i++){
            if (nodes.get(i).isGround)
                groundIndex = i ;
        }
        queue.add(nodes.get(groundIndex)) ;
//        for (int i=0;i<nodes.get(groundIndex).neighbor.size();i++){
//
//        }
        int addedNode = 1 ;
        while (addedNode<nodes.size()){
            for (int i=0;i<nodes.get(addedNode).neighbor.size();i++){

            }
        }
    }
}
