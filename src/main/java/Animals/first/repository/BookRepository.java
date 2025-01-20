package Animals.first.repository;

import Animals.first.model.BooksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BooksModel, Long> {
// Metody niestandardowe, jeśli potrzebne
}