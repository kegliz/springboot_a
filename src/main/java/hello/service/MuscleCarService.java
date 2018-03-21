package hello.service;

import hello.bean.MuscleCar;
import hello.dao.IMuscleCarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
final class MuscleCarService
        implements IMuscleCarService {

    private final IMuscleCarDao muscleCarDao;

    @Autowired
    MuscleCarService(
            final IMuscleCarDao muscleCarDao
    ) {
        this.muscleCarDao = muscleCarDao;
    }

    @Override
    public MuscleCar create(final MuscleCar muscleCar) {
        return muscleCarDao.create(muscleCar);
    }

    @Override
    public List<MuscleCar> read() {
        return muscleCarDao.read();
    }

    @Override
    public MuscleCar read(final int id)
            throws NoSuchElementException {
        return requireMuscleCarFound(id);
    }

    @Override
    public MuscleCar update(final int id, final MuscleCar muscleCar)
            throws NoSuchElementException {
        requireMuscleCarFound(id);
        return muscleCarDao.update(id, muscleCar);
    }

    @Override
    public void delete(final int id)
            throws NoSuchElementException {
        requireMuscleCarFound(id);
        muscleCarDao.delete(id);
    }

    private MuscleCar requireMuscleCarFound(final int id)
            throws NoSuchElementException {
        final MuscleCar muscleCar = muscleCarDao.read(id);
        if ( muscleCar == null ) {
            throw new NoSuchElementException(MuscleCar.class.getName());
        }
        return muscleCar;
    }

}
