import java.io.*;
import java.util.ArrayList;

public class Main {

    static ArrayList<TwoPort> elements = new ArrayList<>();
    static ArrayList<Node> nodes = new ArrayList<>() ;
    static ArrayList<Union> unions = new ArrayList<>() ;

    public static void main(String[] arg)  {
        entrance();
        //for(Node node : nodes){
        //    System.out.println("node name: "+ node.name );
        //    System.out.println(node.union);
        //}
        //for(Union union : unions){
        //    System.out.println("union name: "+ union.name );
        //    for(Node node : union.nodes){
        //        System.out.println("    node name:"+ node.name );
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
                        Resistance resistance = new Resistance(temp) ;
                        if ((resistance.value<0)) // || reshte be jaye adad || adam tatbigh ba for gereftan
                            System.out.println("eror line .....");
                        else {
                            elements.add(resistance);
                            Node.addNode(elements.get(elements.size() - 1), nodes);
                        }
                    }

                    if (temp.charAt(0) == 'C' || temp.charAt(0) == 'c'){
                        Capacitor capacitor = new Capacitor(temp) ;
                        if (capacitor.value<0)
                            System.out.println("eror line .....");
                        else {
                            elements.add(capacitor);
                            Node.addNode(elements.get(elements.size() - 1), nodes);
                        }
                    }

                    if (temp.charAt(0) == 'V' || temp.charAt(0) == 'v') {
                        elements.add(new VoltageSource(temp));
                        Node.addNode(elements.get(elements.size()-1),nodes);

                    }

                    if (temp.charAt(0) == 'L' || temp.charAt(0) == 'l'){
                        Inductor inductor = new Inductor(temp) ;
                        if (inductor.value<0)
                            System.out.println("eror line .....");
                        else {
                            elements.add(inductor);
                            Node.addNode(elements.get(elements.size() - 1), nodes);
                        }
                    }

                    if (temp.charAt(0) == 'F' || temp.charAt(0) == 'f'){
                        CurrentDependant currentDependant = new CurrentDependant(temp) ;
                        currentDependant.CCCC(currentDependant,elements);
                        elements.add(currentDependant);
                        Node.addNode(elements.get(elements.size() - 1), nodes);
                    }

                    if (temp.charAt(0) == 'G' || temp.charAt(0) == 'g') {

                    }

                    if (temp.charAt(0) == 'H' || temp.charAt(0) == 'h') {

                    }

                    if (temp.charAt(0) == 'E' || temp.charAt(0) == 'e') {

                    }


                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        unions = Union.unionMaker(elements , nodes);
        System.out.println("union");
    }


}
