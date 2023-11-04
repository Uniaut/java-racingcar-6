package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarNamesParser implements InputParser<List<String>> {
    public CarNamesParser() {
    }

    @Override
    public List<String> parse(String input) {
        String[] names = input.split(",");
        return Arrays.asList(names);
    }
}
