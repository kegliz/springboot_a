package hello.dao;

import hello.bean.MuscleCar;

import java.util.List;
import java.util.Map;

public interface IMuscleCarDao {

    MuscleCar create(MuscleCar muscleCar);

    List<MuscleCar> read();

    MuscleCar read(int id);

    MuscleCar update(int id, MuscleCar muscleCar);

    void delete(int id);

}
