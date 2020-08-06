import java.util.ArrayList;

public class Erors {

    public void eror2(ArrayList<TwoPort> element, ArrayList<Node> nodes) throws Minus2Error {

        for (TwoPort n : element) {
            if (n.type == 'I' || n.type == 'G' || n.type == 'F') {
                for (Node i : nodes) {
                    if (n.startNode.equals(i.name)) {
                        if (i.neighbor.size() == 2) {
                            if (i.connected.get(0).type == 'C' && i.connected.get(1).type == 'C') {
                                if (i.connected.get(0).value != i.connected.get(1).value) {
                                    throw new Minus2Error();
                                }
                            }
                        }
                    }
                }
            }
        }

        for (TwoPort n : element) {
            if (n.type == 'I' || n.type == 'G' || n.type == 'F') {
                for (Node i : nodes) {
                    if (n.endNode.equals(i.name)) {
                        if (i.neighbor.size() == 2) {
                            if (i.connected.get(0).type == 'C' && i.connected.get(1).type == 'C') {
                                if (i.connected.get(0).value != i.connected.get(1).value) {
                                    throw new Minus2Error();
                                }
                            }
                        }
                    }
                }
            }
        }

    }


    public void eror3(ArrayList<TwoPort> element, ArrayList<Node> nodes) throws Minus3Error {

        for (TwoPort n : element) {
            if (n.type == 'V' || n.type == 'H' || n.type == 'E') {
                for (TwoPort i : element) {
                    if (i.type == 'V' || i.type == 'H' || i.type == 'E') {
                        if (!i.name.equals(n.name)) {
                            if ((n.startNode.equals(i.startNode) && n.endNode.equals(i.endNode)) || (n.startNode.equals(i.endNode) && n.endNode.equals(i.startNode))) {
                                throw new Minus3Error();
                            }
                        }
                    }
                }

            }
        }

    }


    public void eror4(ArrayList<Node> nodes) throws Minus4Error {

        boolean eror = false;
        boolean existingGround = false;
        boolean zeroVoltage = false;

        for (Node i : nodes) {
            if (i.isGround) {
                existingGround = true;
                for (int j = 0; j < i.connected.size(); j++)
                    if (i.connected.get(j).type == 'V') {
                        if (i.connected.get(j).startNode.equals("0") && i.connected.get(j).endNode.equals("0")) {
                            if (i.connected.get(j).value != 0)
                                zeroVoltage = true;
                        }

                    }
            }
        }

        if (!existingGround || zeroVoltage)
            eror = true;

        if (eror)
            throw new Minus4Error() ;

    }


    public void eror5() {


    }


}

class Minus1Error extends Exception {
    public Minus1Error() {
        super("Error -1");
    }
}

class Minus2Error extends Exception {
    public Minus2Error() {
        super("Error -2");
    }
}

class Minus3Error extends Exception {
    public Minus3Error() {
        super("Error -3");
    }
}

class Minus4Error extends Exception {
    public Minus4Error() {
        super("Error -4");
    }
}

class Minus5Error extends Exception {
    public Minus5Error() {
        super("Error -5");
    }
}