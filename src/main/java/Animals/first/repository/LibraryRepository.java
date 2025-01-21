package Animals.first.repository;

import Animals.first.model.LibraryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryModel, Long> {
    Optional<LibraryModel> findByName(String name);
}
