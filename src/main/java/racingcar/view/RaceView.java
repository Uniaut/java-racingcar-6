package racingcar.view;

import java.util.List;
import racingcar.model.Race;

public class RaceView {
    private static final String RACE_INTRO_TEXT = "\n실행 결과";
    private static final String RACE_WINNER_TEXT = "최종 우승자 : ";

    public RaceView() {
    }

    public void printRaceIntro() {
        System.out.println(RACE_INTRO_TEXT);
    }

    private String renderCarState(String carName, int distance) {
        return carName + " : " + "-".repeat(distance);
    }

    public void printRace(Race race) {
        for (String name : race.getCarNames()) {
            String renderedCarState = renderCarState(name, race.getDistance(name));
            System.out.println(renderedCarState);
        }
        System.out.println();
    }

    public void printWinner(Race race) {
        List<String> winnerNames = race.getWinnerNames();
        System.out.println(RACE_WINNER_TEXT + String.join(", ", winnerNames));
    }
}
