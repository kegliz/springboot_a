package hello.web;

import hello.bean.MuscleCar;
import hello.service.IMuscleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
@RequestMapping("/api/cars")
final class MuscleCarController {

    private final IMuscleCarService muscleCarService;

    @Autowired
    MuscleCarController(
            final IMuscleCarService muscleCarService
    ) {
        this.muscleCarService = muscleCarService;
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    MuscleCar create(
            @RequestBody final MuscleCar muscleCar
    ) {
        return muscleCarService.create(muscleCar);
    }

    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    List<MuscleCar> get() {
        return muscleCarService.read();
    }

    @RequestMapping(value = "/{id}", method = GET)
    @ResponseStatus(OK)
    MuscleCar get(
            @PathVariable("id") final int id
    ) {
        return muscleCarService.read(id);
    }

    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseStatus(OK)
    MuscleCar update(
            @PathVariable("id") final int id,
            @RequestBody final MuscleCar muscleCar
    ) {
        return muscleCarService.update(id, muscleCar);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @ResponseStatus(NO_CONTENT)
    void delete(
            @PathVariable("id") final int id
    ) {
        muscleCarService.delete(id);
    }

}