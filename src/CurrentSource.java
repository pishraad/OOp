public class CurrentSource extends Source {
    @Override
    double currentCalculator() {
        return 0;
    }

    CurrentSource(String input){
        super(input);
        type = 'I';
    }

    double currentCalculator(double t){
        return value + amplitude * Math.cos(2 * Math.PI * frequency * t + phase);
    }
}
class CDCurrentSource extends  CurrentDependant {
    @Override
    double currentCalculator() {
        return 0;
    }

    CDCurrentSource(String input) {
        super(input);
        type = 'F';
    }
}

class VDCurrentSource extends VoltageDependant {
    @Override
    double currentCalculator() {
        return 0;
    }

    VDCurrentSource(String input) {
        super(input);
        type = 'G';
    }
}
