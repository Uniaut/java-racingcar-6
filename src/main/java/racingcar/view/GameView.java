package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.ConsoleInput;

public class GameView {
    private static final String ASKING_CAR_NAMES_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASKING_NUMBER_ATTEMPTS_TEXT = "시도할 회수는 몇회인가요?";

    public GameView() {
    }

    public ConsoleInput askCarNames() {
        System.out.println(ASKING_CAR_NAMES_TEXT);
        String input = Console.readLine();
        return new ConsoleInput(input);
    }

    public ConsoleInput askNumberAttempts() {
        System.out.println(ASKING_NUMBER_ATTEMPTS_TEXT);
        String input = Console.readLine();
        return new ConsoleInput(input);
    }
}
