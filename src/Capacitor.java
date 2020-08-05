public class Capacitor extends TwoPort {

    Capacitor(String input) {
        super(input);
        type = 'C';
    }

    @Override
    double currentCalculator() {
        current = (this.value * (this.startTerminal.voltage - this.startTerminal.V_n - this.endTerminal.voltage + this.endTerminal.V_n)) / dt;
        return current;
    }

    @Override
    double currentDvCalculator(double dv) {
        return (this.value * (this.startTerminal.voltage - this.startTerminal.V_n - this.endTerminal.voltage + this.endTerminal.V_n + dv)) / dt;
    }
}
