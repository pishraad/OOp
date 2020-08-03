import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class Graphic {
    JFrame A ;


    Graphic(ArrayList<Node> nodes){
        A = new JFrame("circuit") ;
        A.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        A.setSize(900,800);

        JPanel p [] = new JPanel[30] ;
        for (int i=0;i<30;i++) {
            p[i] = new JPanel() ;
            p[i].setBounds((i%6)*100+200, 500-(i/6)*100, 10, 10);
            Border border;
            border = BorderFactory.createLineBorder(Color.BLACK, 3, true);
            p[i].setBorder(border);
            A.add(p[i]);
        }

        for (Node i : nodes){
            for (TwoPort j : i.connected){
                if (!j.isDraw){
                    j.isDraw = true ;
                    char[] element = {' ',' ',' '} ;
                    element [0] = j.type ;
                    int t = 1 ;
                    for (TwoPort k : i.connected){
                        if (k.endNode.equals(j.startNode) || k.endNode.equals(j.endNode) || k.startNode.equals(j.startNode) || k.startNode.equals(j.endNode) ){
                            k.isDraw = true ;
                            element[t] = k.type ;
                            t++ ;
                        }
                    }
                    drawElement(Integer.parseInt(j.startNode),Integer.parseInt(j.endNode),element);
                }
            }
        }


       // Rofoghi(100 , 100);
        //node(nodes);

        A.setLayout(null);
        A.setVisible(true);
    }

    public void drawElement(int i , int j ,char[] element){

        char verticalStraight = ' ' ;
        if (i/6 == j/6)
            verticalStraight = 'S' ;
        else
            verticalStraight = 'V' ;

        if (element[1]==' '){

            if (element[0] == 'R' && verticalStraight == 'S'){
                 ImageIcon e = new ImageIcon("R1Straight.PNG","PNG") ;
                 JLabel E = new JLabel(e);
                 if (j>i)
                     E.setBounds((i%6)*100+100, 500-(i/6)*100,100,16);
                 if (i<j)
                     E.setBounds((j%6)*100+100, 500-(j/6)*100,100,16);
                 A.add(E) ;
            }
            else if (element[0] == 'R' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("R1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,17);
                if (i<j)
                    E.setBounds((j%6)*100+200, 500-(j/6)*100,17,100);
                A.add(E) ;
            }

            if (element[0] == 'L' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("L1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,16);
                if (i<j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,16);
                A.add(E) ;
            }
            else if (element[0] == 'L' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("L1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,16);
                if (i<j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,16);
                A.add(E) ;
            }

        }
        else if (element[2]==' '){

        }
        else {

        }


    }




}
