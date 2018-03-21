package hello.service;

import hello.bean.MuscleCar;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public interface IMuscleCarService {

    MuscleCar create(MuscleCar muscleCar);

    List<MuscleCar> read();

    MuscleCar read(int id)
            throws NoSuchElementException;

    MuscleCar update(int id, MuscleCar muscleCar)
            throws NoSuchElementException;

    void delete(int id)
            throws NoSuchElementException;

}
