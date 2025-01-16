package Animals.first.controller;

import Animals.first.model.AnimalModel;
import Animals.first.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping(path = "/get")
    public List<AnimalModel> getAnimal() {
        return animalService.getAllAnimals();
    }

    @PostMapping
    public AnimalModel postAnimal(@RequestBody AnimalModel animal) {
        return animalService.addAnimal(animal);
    }
}