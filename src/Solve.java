import java.util.ArrayList;

public class Solve {
    ArrayList<TwoPort> elements;
    ArrayList<Node> nodes;
    ArrayList<Union> unions;
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
        for(double time=0 ; time <= t ; time += dt) {
            Erors erors = new Erors() ;
            erors.eror2(elements,nodes);
            erors.eror3(elements,nodes);
            erors.eror4(nodes);

            for(Union u : unions){

                u.updateVoltage(time);


                if(!u.mainNode.name.equals("0")){
                    u.I = 0;
                    u.I_p = 0;
                    for(Node n : u.nodes){
                        for(TwoPort e : n.connected){
                            if(e.endNode.equals(n.name)){
                                if(e.type == 'I'){
                                    u.I += ((CurrentSource)e).currentCalculator(time);
                                    u.I_p += ((CurrentSource)e).currentCalculator(time);
                                }
                                else {
                                    u.I += e.currentCalculator();
                                    u.I_p += e.currentDvCalculator(-dv);
                                }
                                }
                            else{//possibility of error
                                if(e.type == 'I'){
                                    u.I -= ((CurrentSource)e).currentCalculator(time);
                                    u.I_p -= ((CurrentSource)e).currentCalculator(time);
                                }
                                else {
                                    u.I -= e.currentCalculator();
                                    u.I_p -= e.currentDvCalculator(dv);
                                }
                            }
                        }
                    }
                    for(Node n : u.nodes) {
                        n.V_n = n.voltage;
                    }
                    u.mainNode.voltage += (Math.abs(u.I) - Math.abs(u.I_p)) * dv / di;
                    u.updateVoltage(time);
                }
            }

            //pro
        }
    }
}
