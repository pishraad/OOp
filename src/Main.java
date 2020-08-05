import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static ArrayList<TwoPort> elements = new ArrayList<>();
    static ArrayList<Node> nodes = new ArrayList<>();
    static ArrayList<Union> unions = new ArrayList<>();
    static ArrayList<CurrentDependant> currentDependants = new ArrayList<>();
    static ArrayList<VoltageDependant> voltageDependants = new ArrayList<>();
    static double dv, di, dt, t;

    public static void main(String[] arg) {

        entrance();
        Graphic graphic = new Graphic(nodes) ;
        //Solve solve = new Solve(elements, nodes, unions, dv, di, dt, t);
        //solve.solver();
        //int iterCount = (int) (t / dt);
        //solve.fileWriter(iterCount / 100);


//        Graphic graphic = new Graphic(nodes);
        //Graphic graphic = new Graphic(nodes);
        //char[] element = {'R',' ',' '} ;
        //graphic.drawElement(0,6,element);


//        Scanner consool = new Scanner(System.in) ;
//        String consol = consool.nextLine() ;
//        while (!consol.equals("END")){
//
//            String node1 , node2 ;
//            double T ;
//            consol = consol.replaceAll("\\s+"," ");
//            String[] temp = consol.split(" ");
//            node1 = temp[0];
//            node2 = temp[1];
//            T = TwoPort.toDouble(temp[2]);
//
//            boolean existingNode1 = false , existingNode2 = false ;
//            for (Node i : nodes){
//                if (i.name.equals(node1)){
//                    existingNode1 = true ;
//
//                }
//                if (i.name.equals(node2)){
//                    existingNode2 = true ;
//
//                }
//            }
//
//            if (!existingNode1 || !existingNode2 )
//                System.out.println("ERROR");
//
//            consol = consool.nextLine() ;
//        }

    }

    static void entrance() {
        File file = new File("Test\\RIdc.txt");
        //File file = new File("D:\\University\\98-2\\OOP\\project\\test\\test4.txt") ;
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(file));
            String temp;
            int lineNumber = 0;
            boolean eror11 = false, eror12 = false, eror13 = false, eror14 = false;
            boolean isEnded = false;
            while (!isEnded) {
                temp = in.readLine();
                lineNumber++;
                if (temp.charAt(0) != '*') {

                    boolean correct = false;
                    if (temp.charAt(0) == 'R' || temp.charAt(0) == 'r') {
                        correct = true;
                        Resistance resistance = new Resistance(temp);
                        if ((resistance.value < 0)) // || reshte be jaye adad || adam tatbigh ba for gereftan
                            System.out.println("eror line .....");
                        else {
                            elements.add(resistance);
                            Node.addNode(elements.get(elements.size() - 1), nodes);
                        }
                    }

                    if (temp.charAt(0) == 'C' || temp.charAt(0) == 'c') {
                        correct = true;
                        Capacitor capacitor = new Capacitor(temp);
                        if (capacitor.value < 0)
                            System.out.println("eror line .....");
                        else {
                            elements.add(capacitor);
                            Node.addNode(elements.get(elements.size() - 1), nodes);
                        }
                    }

                    if (temp.charAt(0) == 'L' || temp.charAt(0) == 'l') {
                        correct = true;
                        Inductor inductor = new Inductor(temp);
                        if (inductor.value < 0)
                            System.out.println("eror line .....");
                        else {
                            elements.add(inductor);
                            Node.addNode(elements.get(elements.size() - 1), nodes);
                        }
                    }

                    if (temp.charAt(0) == 'V' || temp.charAt(0) == 'v') {
                        correct = true;
                        elements.add(new VoltageSource(temp));
                        Node.addNode(elements.get(elements.size() - 1), nodes);
                    }

                    if (temp.charAt(0) == 'I' || temp.charAt(0) == 'i') {
                        correct = true;
                        elements.add(new CurrentSource(temp));
                        Node.addNode(elements.get(elements.size() - 1), nodes);
                    }

                    if (temp.charAt(0) == 'F' || temp.charAt(0) == 'f') {
                        correct = true;
                        elements.add(new CDCurrentSource(temp));
                        Node.addNode(elements.get(elements.size() - 1), nodes);
                        currentDependants.add((CurrentDependant) elements.get(elements.size() - 1));
                    }

                    if (temp.charAt(0) == 'G' || temp.charAt(0) == 'g') {
                        correct = true;
                        elements.add(new VDCurrentSource(temp));
                        Node.addNode(elements.get(elements.size() - 1), nodes);
                        voltageDependants.add((VoltageDependant) elements.get(elements.size() - 1));
                    }

                    if (temp.charAt(0) == 'H' || temp.charAt(0) == 'h') {
                        correct = true;
                        elements.add(new CDVoltageSource(temp));
                        Node.addNode(elements.get(elements.size() - 1), nodes);
                        currentDependants.add((CurrentDependant) elements.get(elements.size() - 1));
                    }

                    if (temp.charAt(0) == 'E' || temp.charAt(0) == 'e') {
                        correct = true;
                        elements.add(new VDVoltageSource(temp));
                        Node.addNode(elements.get(elements.size() - 1), nodes);
                        voltageDependants.add((VoltageDependant) elements.get(elements.size() - 1));
                    }

                    if (temp.substring(0, 2).equals("dv")) {
                        eror11 = true;
                        correct = true;
                        temp = temp.substring(2);
                        dv = TwoPort.toDouble(temp.trim());
                    }

                    if (temp.substring(0, 2).equals("di")) {
                        eror12 = true;
                        correct = true;
                        temp = temp.substring(2);
                        di = TwoPort.toDouble(temp.trim());
                    }

                    if (temp.substring(0, 2).equals("dt")) {
                        eror13 = true;
                        correct = true;
                        temp = temp.substring(2);
                        dt = TwoPort.toDouble(temp.trim());
                    }

                    if (temp.startsWith(".tran")) {
                        eror14 = true;
                        correct = true;
                        temp = temp.substring(5);
                        t = TwoPort.toDouble(temp.trim());
                        isEnded = true;
                    }

                    if (!correct)
                        System.out.println("eror line .....");
                }

            }
            if (!eror11 || !eror12 || !eror13 || !eror14)
                System.out.println("error -1");

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CurrentDependant currentDependant : currentDependants) {
            for (TwoPort elementDependant : elements) {
                if (elementDependant.name.equals(currentDependant.elementDependantName)) {
                    currentDependant.elementDependant = elementDependant;
                }
            }
        }
        for (VoltageDependant voltageDependant : voltageDependants) {
            for (Node node : nodes) {
                if (node.name.equals(voltageDependant.startDependantNode)) {
                    voltageDependant.startDependant = node;
                } else if (node.name.equals(voltageDependant.endDependantNode)) {
                    voltageDependant.endDependant = node;
                }
            }
        }
        unions = Union.unionMaker(elements, nodes);
    }

}
