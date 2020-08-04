import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resistance extends TwoPort {

    double currentCalculator(){
        current = (this.startTerminal.voltage - this.endTerminal.voltage)/this.value;
        return current;
    }

    @Override
    double currentDvCalculator(double dv) {
        return (this.startTerminal.voltage - this.endTerminal.voltage +dv)/this.value;
    }

    Resistance(String input){
        super(input);
        type = 'R';
    }
}
