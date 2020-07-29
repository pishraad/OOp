import java.util.ArrayList;

public class Node extends Object{
    String name;
    double[] voltage;
    boolean added = false ;
    boolean isGround = false ;
    int union ;
    ArrayList<Node> neighbor = new ArrayList<>() ;
    ArrayList<TwoPort> connected = new ArrayList<>() ;

    Node(String name) {
        this.name = name;
        this.voltage = new double[1000] ;
        this.voltage[0] = 0.0 ;
        if (name.equals("0")) {
            isGround = true ;
            this.voltage = new double[]{0.0};
        }
    }
}
