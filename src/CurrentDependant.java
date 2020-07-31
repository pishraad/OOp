import java.util.ArrayList;

public class CurrentDependant extends TwoPort {
    String element;
    double factor;

    CurrentDependant(String input){
        input = input.replaceAll("\\s+"," ");
        String[] temp = input.split(" ");
        name = temp[0];
        startNode = temp[1];
        endNode = temp[2];
        element = temp[3];
        factor = toDouble(temp[4]);
    }


    public void CCCC(CurrentDependant currentDependant, ArrayList<TwoPort> elements) {

        if (element.charAt(0) == 'I') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.current(i);
                }
            }
        }

        if (element.charAt(0) == 'L') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.current(i);
                }
            }
        }

        if (element.charAt(0) == 'C') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.current(i);
                }
            }
        }
        if (element.charAt(0) == 'R') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.current(i);
                }
            }
        }
    }





    public void VCCC(CurrentDependant currentDependant, ArrayList<TwoPort> elements){

        if (element.charAt(0) == 'I') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.voltage(i);
                }
            }
        }

        if (element.charAt(0) == 'R') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.voltage(i);
                }
            }
        }

        if (element.charAt(0) == 'L') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.voltage(i);
                }
            }
        }

        if (element.charAt(0) == 'C') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.voltage(i);
                }
            }
        }

    }


}

