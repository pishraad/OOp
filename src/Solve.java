import java.io.BufferedWriter;
import java.io.FileWriter;
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
                            if(e.type != 'V' && e.type != 'H' && e.type != 'E'){
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
                    }
                    for(Node n : u.nodes) {
                        n.V_n = n.voltage;
                    }
                    u.mainNode.voltage += (Math.abs(u.I) - Math.abs(u.I_p)) * dv / di;
                    for(TwoPort i : elements){
                        if(i.type == 'L'){
                            i.I_n = i.currentCalculator();
                        }
                    }
                    u.updateVoltage(time);
                }
            }
            for(TwoPort e : elements){
                if(e.type == 'V' || e.type == 'H' || e.type == 'E'){
                    VoltageSource.VSCurrentCalculator(e,time);
                }
                Properties properties = new Properties(time);
                properties.current = e.current;
                properties.voltage = e.voltageCalculator(time);
                properties.power = properties.current * properties.voltage;
                e.properties.add(properties);
            }
            for(Node n : nodes){
                Properties properties = new Properties(time);
                properties.voltage = n.voltage;
                n.properties.add(properties);
            }
        }
    }

    void fileWriter(int per){

        try{
            // Create file
            FileWriter fstream = new FileWriter(System.currentTimeMillis() + "out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            int counter = 0;
            int whichNode = 0 ;
            for (int i=0;i<nodes.size();i++){
                for (Node j : nodes){
                    if (j.name.equals(String.valueOf(whichNode))){
                        out.write("Node" + whichNode + ": ");
                        for(Properties p : j.properties){
                            if(counter % per == 0){
                                String string = String.format("t=%.6f , %.6f , ", p.time , p.voltage);
                                out.write(string);
                            }
                            counter++;
                        }
                    }
                }
                whichNode ++ ;
                out.write("\n\n");
            }
            counter =0;
            for(TwoPort e : elements){
                out.write(e.name + ": ");
                for(Properties p : e.properties){
                    if(counter % per == 0){
                        String string = String.format("t=%.6f , V=%.6f , I=%.6f , P=%.6f , ",p.time , p.voltage, p.current, p.power);
                        out.write(string);
                    }
                    counter++;
                }
                out.write("\n\n");
            }

            //Close the output stream
            out.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

    }
}
