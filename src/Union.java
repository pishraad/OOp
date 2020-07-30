//import java.util.ArrayList;
//
//public class Union {
//
//    public void setting(ArrayList<Node> node){
//        for (int i=0;i<node.size();i++) {
//            node.get(i).union = i ;
//            node.get(i).added = false ;
//        }
//    }
//
//    public ArrayList<Union> unionMaker(ArrayList<Node> node){
//        ArrayList<Union> unionss = new ArrayList<>() ;
//        int groundIndex = 0 ;
//        for (int i=0;i<node.size();i++){
//            if (node.get(i).isGround)
//                groundIndex = i ;
//                unionss.add(node.get(i)) ;
//        }
//        for (int i=0;i<nodes.get(groundIndex).neighbor.size();i++){
//            unionss.add(nodes.get(groundIndex).neighbor.get(i)) ;
//            nodes.get(groundIndex).neighbor.get(i).added = true ;
//        }
//        return unionss ;
//    }
//}
