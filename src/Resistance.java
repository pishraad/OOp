import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resistance extends TwoPort {

    double currentCalculator(){
        System.out.println("R");
        return 0;
    }

    Resistance(String input){
        super(input);
        type = 'R';
    }
}
