public class Capacitor extends TwoPort {

    @Override
    double currentCalculator() {
        System.out.println("C");
        return 0;
    }

    Capacitor(String input){
        super(input);
        type = 'C';
    }
}
