import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.awt.geom.Line2D;

public class Graphic {
    JFrame A ;


    Graphic(ArrayList<Node> nodes){
        A = new JFrame("circuit") ;
        A.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        A.setSize(900,800);

        JPanel p [] = new JPanel[36] ;
        for (int i=6;i<36;i++) {
            p[i] = new JPanel() ;
            p[i].setBounds((i%6)*100+200, 600-(i/6)*100, 10, 10);
            Border border;
            border = BorderFactory.createLineBorder(Color.BLACK, 3, true);
            p[i].setBorder(border);
            A.add(p[i]);
        }

        for (Node j :nodes){
            if (Integer.parseInt(j.name)<6){
                for (Node i : j.neighbor){
                    if (i.name.equals("0")){
                        ImageIcon g = new ImageIcon("grand.PNG","PNG") ;
                        JLabel G = new JLabel(g);
                        G.setBounds(Integer.parseInt(j.name)*100+75, 600,55,50);
                        A.add(G) ;
                    }
                }
            }
        }

        for (Node i : nodes){
            for (TwoPort j : i.connected){
                if (!j.isDraw){
                    j.isDraw = true ;
                    char[] element = {' ',' ',' '} ;
                    element [0] = j.type ;
                    int t = 1 ;
                    String anotherNode ;
                    if (i.name.equals(j.startNode))
                        anotherNode = j.endNode ;
                    else
                        anotherNode = j.startNode ;
                    for (TwoPort k : i.connected){
                        if ((k.endNode.equals(anotherNode) || k.startNode.equals(anotherNode) ) && !k.name.equals(j.name)){
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
        if (i==0 || j==0)
            verticalStraight = 'V' ;
        else if (i/6 == j/6)
            verticalStraight = 'S' ;
        else
            verticalStraight = 'V' ;

        if (element[1]==' '){

            if (element[0] == 'R' && verticalStraight == 'S'){
                 ImageIcon e = new ImageIcon("R1Straight.PNG","PNG") ;
                 JLabel E = new JLabel(e);
                 if (j>i)
                     E.setBounds((i%6)*100+100, 500-(i/6)*100,100,16);
                 if (i>j)
                     E.setBounds((j%6)*100+100, 500-(j/6)*100,100,16);
                 A.add(E) ;
            }
            else if (element[0] == 'R' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("R1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,17,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,17,100);
                A.add(E) ;
            }

            if (element[0] == 'L' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("L1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'L' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("L1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[0] == 'C' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("C1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'C' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("C1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[0] == 'V' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V4.PNG","PNG") ;
                else
                    e = new ImageIcon("V2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'V' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V3.PNG","PNG") ;
                else
                    e = new ImageIcon("V1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[0] == 'I' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I4.PNG","PNG") ;
                else
                    e = new ImageIcon("I2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'I' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I3.PNG","PNG") ;
                else
                    e = new ImageIcon("I1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[0] == 'E' || element[0] == 'H') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD4.PNG","PNG") ;
                else
                    e = new ImageIcon("VD2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[0] == 'E' || element[0] == 'H') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD3.PNG","PNG") ;
                else
                    e = new ImageIcon("VD1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[0] == 'F' || element[0] == 'G') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID4.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[0] == 'F' || element[0] == 'G') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID3.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }


        }
        else if (element[2]==' '){



            if (element[0] == 'R' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("R1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,16);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,16);
                A.add(E) ;
            }
            else if (element[0] == 'R' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("R1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,17,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,17,100);
                A.add(E) ;
            }

            if (element[0] == 'L' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("L1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'L' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("L1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[0] == 'C' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("C1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'C' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("C1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[0] == 'V' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V4.PNG","PNG") ;
                else
                    e = new ImageIcon("V2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'V' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V3.PNG","PNG") ;
                else
                    e = new ImageIcon("V1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[0] == 'I' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I4.PNG","PNG") ;
                else
                    e = new ImageIcon("I2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'I' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I3.PNG","PNG") ;
                else
                    e = new ImageIcon("I1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[0] == 'E' || element[0] == 'H') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD4.PNG","PNG") ;
                else
                    e = new ImageIcon("VD2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[0] == 'E' || element[0] == 'H') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD3.PNG","PNG") ;
                else
                    e = new ImageIcon("VD1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[0] == 'F' || element[0] == 'G') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID4.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[0] == 'F' || element[0] == 'G') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID3.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }


            if (element[1] == 'R' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("R1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,16);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,16);
                A.add(E) ;
            }
            else if (element[1] == 'R' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("R1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,17,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,17,100);
                A.add(E) ;
            }

            if (element[1] == 'L' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("L1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[1] == 'L' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("L1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[1] == 'C' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("C1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[1] == 'C' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("C1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[1] == 'V' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V4.PNG","PNG") ;
                else
                    e = new ImageIcon("V2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[1] == 'V' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V3.PNG","PNG") ;
                else
                    e = new ImageIcon("V1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[1] == 'I' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I4.PNG","PNG") ;
                else
                    e = new ImageIcon("I2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[1] == 'I' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I3.PNG","PNG") ;
                else
                    e = new ImageIcon("I1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[1] == 'E' || element[1] == 'H') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD4.PNG","PNG") ;
                else
                    e = new ImageIcon("VD2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[1] == 'E' || element[1] == 'H') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD3.PNG","PNG") ;
                else
                    e = new ImageIcon("VD1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[1] == 'F' || element[1] == 'G') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID4.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[1] == 'F' || element[1] == 'G') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID3.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }


        }

        else {


            if (element[0] == 'R' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("R1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,16);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,16);
                A.add(E) ;
            }
            else if (element[0] == 'R' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("R1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,17,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,17,100);
                A.add(E) ;
            }

            if (element[0] == 'L' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("L1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'L' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("L1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[0] == 'C' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("C1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'C' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("C1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[0] == 'V' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V4.PNG","PNG") ;
                else
                    e = new ImageIcon("V2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'V' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V3.PNG","PNG") ;
                else
                    e = new ImageIcon("V1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[0] == 'I' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I4.PNG","PNG") ;
                else
                    e = new ImageIcon("I2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[0] == 'I' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I3.PNG","PNG") ;
                else
                    e = new ImageIcon("I1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[0] == 'E' || element[0] == 'H') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD4.PNG","PNG") ;
                else
                    e = new ImageIcon("VD2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[0] == 'E' || element[0] == 'H') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD3.PNG","PNG") ;
                else
                    e = new ImageIcon("VD1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[0] == 'F' || element[0] == 'G') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID4.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 480-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 480-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[0] == 'F' || element[0] == 'G') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID3.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+75, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+75, 500-(j/6)*100,20,100);
                A.add(E) ;
            }


            if (element[1] == 'R' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("R1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,16);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,16);
                A.add(E) ;
            }
            else if (element[1] == 'R' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("R1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,17,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,17,100);
                A.add(E) ;
            }

            if (element[1] == 'L' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("L1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[1] == 'L' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("L1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[1] == 'C' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("C1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[1] == 'C' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("C1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[1] == 'V' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V4.PNG","PNG") ;
                else
                    e = new ImageIcon("V2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[1] == 'V' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V3.PNG","PNG") ;
                else
                    e = new ImageIcon("V1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[1] == 'I' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I4.PNG","PNG") ;
                else
                    e = new ImageIcon("I2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[1] == 'I' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I3.PNG","PNG") ;
                else
                    e = new ImageIcon("I1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[1] == 'E' || element[1] == 'H') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD4.PNG","PNG") ;
                else
                    e = new ImageIcon("VD2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[1] == 'E' || element[1] == 'H') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD3.PNG","PNG") ;
                else
                    e = new ImageIcon("VD1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[1] == 'F' || element[1] == 'G') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID4.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 500-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 500-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[1] == 'F' || element[1] == 'G') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID3.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+95, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+95, 500-(j/6)*100,20,100);
                A.add(E) ;
            }



            if (element[2] == 'R' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("R1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 520-(i/6)*100,100,16);
                if (i>j)
                    E.setBounds((j%6)*100+100, 520-(j/6)*100,100,16);
                A.add(E) ;
            }
            else if (element[2] == 'R' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("R1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+115, 500-(i/6)*100,17,100);
                if (i<j)
                    E.setBounds((j%6)*100+115, 500-(j/6)*100,17,100);
                A.add(E) ;
            }

            if (element[2] == 'L' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("L1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 520-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 520-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[2] == 'L' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("L1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+115, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+115, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[2] == 'C' && verticalStraight == 'S'){
                ImageIcon e = new ImageIcon("C1Straight.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 520-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 520-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[2] == 'C' && verticalStraight == 'V'){
                ImageIcon e = new ImageIcon("C1Vertical.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+115, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+115, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[2] == 'V' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V4.PNG","PNG") ;
                else
                    e = new ImageIcon("V2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 520-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 520-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[2] == 'V' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("V3.PNG","PNG") ;
                else
                    e = new ImageIcon("V1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+115, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+115, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if (element[2] == 'I' && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I4.PNG","PNG") ;
                else
                    e = new ImageIcon("I2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 520-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 520-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if (element[2] == 'I' && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("I3.PNG","PNG") ;
                else
                    e = new ImageIcon("I1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+115, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+115, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[2] == 'E' || element[2] == 'H') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD4.PNG","PNG") ;
                else
                    e = new ImageIcon("VD2.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 520-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 520-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[2] == 'E' || element[2] == 'H') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("VD3.PNG","PNG") ;
                else
                    e = new ImageIcon("VD1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+115, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+115, 500-(j/6)*100,20,100);
                A.add(E) ;
            }

            if ((element[2] == 'F' || element[2] == 'G') && verticalStraight == 'S'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID4.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j>i)
                    E.setBounds((i%6)*100+100, 520-(i/6)*100,100,20);
                if (i>j)
                    E.setBounds((j%6)*100+100, 520-(j/6)*100,100,20);
                A.add(E) ;
            }
            else if ((element[2] == 'F' || element[2] == 'G') && verticalStraight == 'V'){
                ImageIcon e ;
                if (j>i)
                    e = new ImageIcon("ID3.PNG","PNG") ;
                else
                    e = new ImageIcon("ID1.PNG","PNG") ;
                JLabel E = new JLabel(e);
                if (j<i)
                    E.setBounds((i%6)*100+115, 500-(i/6)*100,20,100);
                if (i<j)
                    E.setBounds((j%6)*100+115, 500-(j/6)*100,20,100);
                A.add(E) ;
            }


        }


    }




}
