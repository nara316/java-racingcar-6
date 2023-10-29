package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Car {

    private static final int CAR_NAME_MIN_SIZE = 1;
    private static final int CAR_NAME_MAX_SIZE = 5;
    private final String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car nameFrom(String name) {
        return new Car(name, 0);
    }

    private boolean validateNameSize(List<String> carNameList) {
        return carNameList.stream()
                .allMatch(carName -> CAR_NAME_MIN_SIZE <= carName.length() && carName.length() < CAR_NAME_MAX_SIZE);
    }

    private boolean validateNameDuplication(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);

        return carNameList.size() == carNameSet.size();
    }
}
