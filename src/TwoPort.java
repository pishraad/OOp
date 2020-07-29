import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TwoPort {
    String startNode ;
    String endNode ;
    String name;
    double value;
    double toDouble (String input){
        double out = Double.parseDouble(input.substring(0,input.length()-1));
        char last = input.charAt(input.length()-1);
        if(last == 'p'){
            out /= Math.pow(10,12);
        }
        else if(last == 'n'){
            out /= Math.pow(10,9);
        }
        else if(last == 'u'){
            out /= Math.pow(10,6);
        }
        else if(last == 'm'){
            out /= Math.pow(10,3);
        }
        else if(last == 'k'){
            out *= Math.pow(10,3);
        }
        else if(last == 'M'){
            out *= Math.pow(10,6);
        }
        else if(last == 'G'){
            out *= Math.pow(10,9);
        }
        return out;
    }
    TwoPort(){}
    TwoPort(String input) {
        input = input.replaceAll("\\s+"," ");
        String[] temp = input.split(" ");
        name = temp[0];
        startNode = temp[1];
        endNode = temp[2];
        value = toDouble(temp[3]);
    }
    static void addNode(TwoPort element, ArrayList<Node> nodes){
        boolean found1 = false ;
        boolean found2 = false ;
        int index1 ;
        for (int i=0;i<nodes.size();i++){
            if (nodes.get(i).name.equals(element.startNode)){
                index1 = i ;
                found1 = true ;
                nodes.get(i).connected.add(element);
                for (int j=0;j<nodes.size();j++) {
                    if (nodes.get(j).name.equals(element.endNode)) {
                        found2 = true ;
                        nodes.get(i).neighbor.add(nodes.get(j)) ;
                        nodes.get(j).neighbor.add(nodes.get(i)) ;
                        nodes.get(j).connected.add(element);
                    }
                }
                if (!found2){
                    nodes.add(new Node(element.endNode));
                    nodes.get(nodes.size()-1).neighbor.add(nodes.get(index1)) ;
                    nodes.get(nodes.size()-1).connected.add(element);
                    nodes.get(index1).neighbor.add(nodes.get(nodes.size()-1));
                }
            }
        }
        if (!found1){
            nodes.add(new Node(element.startNode));
            nodes.get(nodes.size()-1).connected.add(element);
            for (int j=0;j<nodes.size();j++) {
                if (nodes.get(j).name.equals(element.endNode)) {
                    found2 = true ;
                    nodes.get(nodes.size()-1).neighbor.add(nodes.get(j)) ;
                    nodes.get(j).neighbor.add(nodes.get(nodes.size()-1)) ;
                    nodes.get(j).connected.add(element);
                }
            }
            if (!found2){
                nodes.add(new Node(element.endNode));
                nodes.get(nodes.size()-1).neighbor.add(nodes.get(nodes.size()-2)) ;
                nodes.get(nodes.size()-2).neighbor.add(nodes.get(nodes.size()-1)) ;
                nodes.get(nodes.size()-1).connected.add(element);
            }

        }
        // creating first nodes & yhen connecting
    }
}
