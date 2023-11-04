package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.assertj.core.util.Sets;

public class Race {
    private final List<String> carNames;
    private final Map<String, Car> cars;

    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int RANDOM_NUMBER_GTE_CONDITION = 4;

    public Race(List<String> carNames) {
        validateCarNames(carNames);

        this.carNames = carNames;
        cars = carNames.stream()
                .collect(Collectors.toMap(n -> n, n -> new Car()));
    }

    private void validateCarNames(List<String> carNames) {
        Set<String> carNamesSet = Sets.newHashSet(carNames);
        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException("Duplicated names");
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    private Car getCar(String carName) {
        return cars.get(carName);
    }

    public int getDistance(String carName) {
        return getCar(carName).getDistance();
    }

    private void randomAdvance(Car car) {
        int randomNumber = Randoms.pickNumberInRange(
                RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        if (randomNumber >= RANDOM_NUMBER_GTE_CONDITION) {
            car.advance();
        }
    }

    public void doAttempt() {
        for (Car car : cars.values()) {
            randomAdvance(car);
        }
    }

    public List<String> getWinnerNames() {
        Integer maxDistance = carNames.stream()
                .map(this::getDistance)
                .max(Comparator.comparing(x -> x))
                .orElse(0);
        return carNames.stream()
                .filter(name -> maxDistance.equals(getDistance(name)))
                .toList();
    }
}
