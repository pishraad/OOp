public class VoltageSource extends Source {
    VoltageSource(String input) {
        super(input);
        type = 'V';
    }

    static double VSCurrentCalculator(TwoPort voltageSource, double time) {
        voltageSource.current = 0;
        for (TwoPort e : voltageSource.startTerminal.connected) {
            if (voltageSource.startNode.equals(e.endNode)) {
                if (e.type == 'I') {
                    voltageSource.current += ((CurrentSource) e).currentCalculator(time);
                } else {
                    voltageSource.current += e.currentCalculator();
                }
            } else {//possibility of error
                if (e.type == 'I') {
                    voltageSource.current -= ((CurrentSource) e).currentCalculator(time);
                } else {
                    voltageSource.current -= e.currentCalculator();
                }
            }
        }
        return voltageSource.current;
    }

    @Override
    double currentCalculator() {
        return 0;
    }

    @Override
    double currentDvCalculator(double dv) {
        return 0;
    }

    double voltageCalculator(double t) {
        voltage = value + amplitude * Math.cos(2 * Math.PI * frequency * t + phase);
        return voltage;
    }


}

class CDVoltageSource extends CurrentDependant {

    CDVoltageSource(String input) {
        super(input);
        type = 'H';
    }

    @Override
    double currentCalculator() {
        return 0;
    }

    @Override
    double currentDvCalculator(double dv) {
        return 0;
    }

    double voltageCalculator(double t) {
        if (elementDependant.type == 'I') {
            elementDependant.current = ((CurrentSource) elementDependant).currentCalculator(t);
        } else if (elementDependant.type == 'V' || elementDependant.type == 'H' || elementDependant.type == 'E') {
            elementDependant.current = VoltageSource.VSCurrentCalculator(elementDependant, t);
        } else {
            elementDependant.current = elementDependant.currentCalculator();
        }
        voltage = gain * (elementDependant.current);
        return voltage;
    }
}

class VDVoltageSource extends VoltageDependant {
    VDVoltageSource(String input) {
        super(input);
        type = 'E';
    }

    @Override
    double currentCalculator() {
        return 0;
    }

    @Override
    double currentDvCalculator(double dv) {
        return 0;
    }

    double voltageCalculator(double t) {
        voltage = gain * (startDependant.voltage - endDependant.voltage);
        return voltage;
    }
}
