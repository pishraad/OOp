public class Resistance extends TwoPort {

    Resistance(String input) {
        super(input);
        type = 'R';
    }

    double currentCalculator() {
        current = (this.startTerminal.voltage - this.endTerminal.voltage) / this.value;
        return current;
    }

    @Override
    double currentDvCalculator(double dv) {
        return (this.startTerminal.voltage - this.endTerminal.voltage + dv) / this.value;
    }
}
