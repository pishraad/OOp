import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Graphic {
    JFrame A ;


    Graphic(ArrayList<Node> nodes){
        A = new JFrame("circuit") ;
        A.setSize(1000,700);

        for (int i=0;i<nodes.size();i++){
            // create nodes
            //size :
        }
       // Rofoghi(100 , 100);
        //node(nodes);

        A.setLayout(null);
        A.setVisible(true);
    }

    public void drawElement(int i , int j , char verticalStraight , char type){

        if (type == 'R' && verticalStraight == 'S'){
            ImageIcon r = new ImageIcon("D:\\uni\\oop\\project\\2\\Rstraight.PNG","PNG") ;
            JLabel R = new JLabel(r);
            R.setBounds(i,j,122,16);
            A.add(R) ;
        }
        else if (type == 'R' && verticalStraight == 'V'){
            ImageIcon r = new ImageIcon("D:\\uni\\oop\\project\\2\\Rvertical.PNG","PNG") ;
            JLabel R = new JLabel(r);
            R.setBounds(i,j,16,122);
            A.add(R) ;
        }



    }




}
