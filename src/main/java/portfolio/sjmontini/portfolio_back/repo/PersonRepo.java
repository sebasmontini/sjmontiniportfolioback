package portfolio.sjmontini.portfolio_back.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.sjmontini.portfolio_back.model.Person;

public interface PersonRepo extends JpaRepository<Person, Long>{
    
    public void deletePersonById(Long Id);
    public Optional<Person> findPersonById(Long id);
}
