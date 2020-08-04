import java.util.ArrayList;

public class Solve {
    ArrayList<TwoPort> elements = new ArrayList<>();
    ArrayList<Node> nodes = new ArrayList<>() ;
    ArrayList<Union> unions = new ArrayList<>() ;
    double dv , di , dt , t ;

    Solve(ArrayList<TwoPort> elements, ArrayList<Node> nodes, ArrayList<Union> unions, double dv ,double di ,double dt ,double t){
        this.elements = elements;
        this.nodes = nodes;
        this.unions = unions;
        this.dv = dv;
        this.di = di;
        this.dt = dt;
        this.t = t;
    }

    void solver(){
        for(int time=0 ; time <= t ; time += dt){
            //check for errors

        }
    }
}
