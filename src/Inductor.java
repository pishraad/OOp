public class Inductor extends TwoPort {

    Inductor(String input) {
        super(input);
        type = 'L';
    }

    @Override
    double currentCalculator() {
        current = I_n + (this.startTerminal.voltage - this.endTerminal.voltage) * dt / this.value;
        return current;
    }

    @Override
    double currentDvCalculator(double dv) {
        return I_n + (this.startTerminal.voltage - this.endTerminal.voltage + dv) * dt / this.value;
    }
}
