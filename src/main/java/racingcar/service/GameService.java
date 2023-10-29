package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.UserUtil;
import racingcar.validation.CarNameValidator;

public class GameService {

    private static final String DIVISION_STANDARD = ",";

    private final List<Car> carList;

    CarNameValidator carNameValidator = new CarNameValidator();

    public GameService() {
        carList = new ArrayList<>();
    }

    public void getCarList() {
        String userInput = UserUtil.getUserInput();
        List<String> userInputList = convertStrToList(userInput);
        carNameValidator.validateCarName(userInputList);
        userInputList.stream()
                .forEach(carName -> carList.add(Car.nameFrom(carName)));
    }

    private List<String> convertStrToList(String userInput) {
        return Arrays.stream(userInput.split(DIVISION_STANDARD))
                .collect(Collectors.toList());
    }
}
