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
                                 Minus2Error minus2Error = new Minus2Error() ;
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
                                    Minus2Error minus2Error = new Minus2Error() ;
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
                            Minus3Error minus3Error = new Minus3Error() ;
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
class Minus1Error  extends Exception {
    public Minus1Error(){
        super("Error -1");
    }
}
class Minus2Error  extends Exception {
    public Minus2Error(){
        super("Error -2");
    }
}
class Minus3Error  extends Exception {
    public Minus3Error(){
        super("Error -3");
    }
}
class Minus4Error  extends Exception {
    public Minus4Error(){
        super("Error -4");
    }
}
class Minus5Error  extends Exception {
    public Minus5Error(){
        super("Error -5");
    }
}