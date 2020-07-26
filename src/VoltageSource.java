import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VoltageSource extends TwoPort {
    double amplitude;
    double frequency;
    double phase;

    VoltageSource(String input) {
        Pattern pattern = Pattern.compile("[A-Z](.*)\\s+(.*)\\s+(.*)\\s+(.*)\\s+(.*)\\s+(.*)\\s+(.*)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            name = matcher.group(0);
            startNode.name = matcher.group(1);
            endNode.name = matcher.group(2);
            value = toDouble(matcher.group(3));
            amplitude = toDouble(matcher.group(4));
            frequency = toDouble(matcher.group(5));
            phase = toDouble(matcher.group(6));
        }
    }
}