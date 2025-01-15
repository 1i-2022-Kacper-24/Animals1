package Animals.first.repository;

import Animals.first.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {
}
