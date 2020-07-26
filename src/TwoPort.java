import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TwoPort {
    Node startNode ;
    Node endNode ;
    String name;
    double value;
    double toDouble (String input){
        double out = Double.parseDouble(input.substring(0,input.length()-1));
        char last = input.charAt(input.length()-1);
        if(last == 'p'){
            out /= Math.pow(10,12);
        }
        else if(last == 'n'){
            out /= Math.pow(10,9);
        }
        else if(last == 'u'){
            out /= Math.pow(10,6);
        }
        else if(last == 'm'){
            out /= Math.pow(10,3);
        }
        else if(last == 'k'){
            out *= Math.pow(10,3);
        }
        else if(last == 'M'){
            out *= Math.pow(10,6);
        }
        else if(last == 'G'){
            out *= Math.pow(10,9);
        }
        return out;
    }
    TwoPort(){}
    TwoPort(String input) {
        Pattern pattern = Pattern.compile("[A-Z](.*)\\s+(.*)\\s+(.*)\\s+(\\S).*");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            name = matcher.group(0);
            startNode.name = matcher.group(1);
            endNode.name = matcher.group(2);
            value = toDouble(matcher.group(3));
        }
    }
}
