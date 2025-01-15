package Animals.first.service;

import Animals.first.model.AnimalModel;
import Animals.first.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public AnimalModel addAnimal(AnimalModel animal) {
        return animalRepository.save(animal);
    }

    public List<AnimalModel> getAllAnimals() {
        return animalRepository.findAll();
    }
}