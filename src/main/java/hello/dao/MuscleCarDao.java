package hello.dao;

import hello.bean.MuscleCar;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MuscleCarDao implements IMuscleCarDao {

    @Override
    public MuscleCar create(final MuscleCar muscleCar) {
        return muscleCar;
    }

    @Override
    public List<MuscleCar> read() {
        return null;
    }

    @Override
    public MuscleCar read(final int id) {
        return null;
    }

    @Override
    public MuscleCar update(final int id, final MuscleCar muscleCar) {
        return muscleCar;
    }

    @Override
    public void delete(final int id) {
    }

}
