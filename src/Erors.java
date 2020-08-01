import java.util.ArrayList;

public class Erors {

    public void eror2(ArrayList<TwoPort> element,ArrayList<Node> nodes){

        for (TwoPort n : element){
            if (n.type == 'C' ){ // || n == ...
                for (Node i : nodes){
                   if (n.startNode.equals(i.name)){
                       if (i.neighbor.size()==2){
                         if (i.connected.get(0).type == 'C' && i.connected.get(1).type == 'C'){
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

        for (TwoPort n : element){
            if (n.type == 'C' ){ // || n == ...
                for (Node i : nodes){
                    if (n.endNode.equals(i.name)){
                        if (i.neighbor.size()==2){
                            if (i.connected.get(0).type == 'C' && i.connected.get(1).type == 'C'){
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


    public void eror3(ArrayList<TwoPort> element,ArrayList<Node> nodes){

        for (TwoPort n : element){
            if (n.type == 'V' ){ // || n == ...
                for (TwoPort i : element) {
                    if (i.type == 'V') { // || n == ...

                        if ((n.startNode.equals(i.startNode) && n.endNode.equals(i.endNode)) || (n.startNode.equals(i.endNode) && n.endNode.equals(i.startNode))){
                            System.out.println("Eror -3");
                            //stop
                        }

                    }
                }

            }
        }

    }



    public void eror4(ArrayList<Node> nodes){

        boolean eror = false ;
        boolean existingGround = false ;
        boolean zeroVoltage = false ;

        for (Node i : nodes){
            if (i.isGround) {
                existingGround = true;
                for (int j=0;j<i.connected.size();j++)
                if (i.connected.get(j).type == 'V' ){
                    if (i.connected.get(j).startNode.equals("0") && i.connected.get(j).endNode.equals("0")){
                        if (i.connected.get(j).value != 0 )
                            zeroVoltage = true ;
                    }

                }
            }
        }

        if (!existingGround || zeroVoltage)
            eror = true ;

        if (eror)
            System.out.println("eror -4");

    }



    public void eror5(){


    }



}
