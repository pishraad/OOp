import java.io.*;
import java.util.ArrayList;

public class Main {

    static ArrayList<TwoPort> elements = new ArrayList<>();
    static ArrayList<Node> nodes = new ArrayList<>() ;
    private static Object VoltageSource;
    private static Object VoltageDependant;

    public static void main(String[] arg)  {
        entrance();
       //for(Node node : nodes){
       //    System.out.println("node name: "+ node.name );
       //    for(Node n : node.neighbor){
       //        System.out.println(n.name);
       //    }
       //    for(TwoPort e : node.connected){
       //        System.out.println(e.name);
       //        System.out.println(e.value);
       //    }
       //}
    }

    static void entrance () {
        File file = new File("entrance.txt") ;
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(file));
            String temp;
            while (!(temp = in.readLine()).equals("END")) {
                if (temp.charAt(0) != '*') {
                    if (temp.charAt(0) == 'R' || temp.charAt(0) == 'r'){
                        elements.add(new Resistance(temp));
                        TwoPort.addNode(elements.get(elements.size()-1),nodes);
                    }
                    if (temp.charAt(0) == 'C' || temp.charAt(0) == 'c'){
                        elements.add(new Capacitor(temp));
                        TwoPort.addNode(elements.get(elements.size()-1),nodes);
                    }
                    if (temp.charAt(0) == 'L' || temp.charAt(0) == 'l'){
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
        for (int i=0;i<nodes.size();i++) {
            nodes.get(i).union = i ;
            nodes.get(i).added = false ;
        }
        int groundIndex = 0 ;
        for (int i=0;i<nodes.size();i++){
            if (nodes.get(i).isGround)
                groundIndex = i ;
        }


        for (int j=0;j<nodes.get(groundIndex).connected.size();j++) {
            if (nodes.get(groundIndex).connected.get(j) == VoltageSource || nodes.get(groundIndex).connected.get(j) == VoltageDependant) {

                String anoderNode ;
                if (nodes.get(groundIndex).connected.get(j).startNode.equals(nodes.get(groundIndex).name))
                    anoderNode = nodes.get(groundIndex).connected.get(j).endNode  ;
                else
                    anoderNode = nodes.get(groundIndex).connected.get(j).startNode  ;

                for (int ii=0;ii<nodes.size();ii++){
                    if (anoderNode.equals(nodes.get(ii).name)){
                        nodes.get(ii).added = true ;
                        nodes.get(ii).union = groundIndex ;
                    }
                }

            }
        }

        for (int i=0;i<nodes.get(groundIndex).neighbor.size();i++){
            if (!nodes.get(groundIndex).neighbor.get(i).added)
                nodes.get(groundIndex).neighbor.get(i).added = true ;
        }
//        ArrayList<Node> queue = new ArrayList<>();
//        queue.add(nodes.get(groundIndex)) ;
////        for (int i=0;i<nodes.get(groundIndex).neighbor.size();i++){
////
////        }
//        int addedNode = 1 ;
//        while (addedNode<nodes.size()){
//            for (int i=0;i<nodes.get(addedNode).neighbor.size();i++){
//
//            }
//        }
    }
}
