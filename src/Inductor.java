public class Inductor extends TwoPort{

    @Override
    double currentCalculator() {
        System.out.println("L");
        return 0;
    }

    Inductor(String input) {
        super(input);
        type = 'L';
    }
}
