package racingcar.model;

public class NumberAttemptsParser implements InputParser<Integer> {

    @Override
    public Integer parse(String input) {
        return Integer.parseInt(input);
    }
}
