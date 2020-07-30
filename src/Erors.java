import java.util.ArrayList;

public class Erors {

    public void eror2(ArrayList<TwoPort> element,ArrayList<Node> nodes){

        for (TwoPort n : element){
            if (n == CurentSource || n == ...) {
                for (Node i : nodes){
                   if (n.startNode.equals(i.name)){
                       if (i.neighbor.size()==2){
                         if (i.connected.get(0) == CurrentSource && i.connected.get(1) == CurrentSource){
                             if (i.connected.get(0).value != i.connected.get(1).value){
                                 System.out.println("Eror -2");
                                 //Stop
                             }
                         }
                       }
                   }
                }


            }
        }

    }




}
