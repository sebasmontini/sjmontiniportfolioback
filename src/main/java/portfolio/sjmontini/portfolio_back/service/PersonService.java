package portfolio.sjmontini.portfolio_back.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.sjmontini.portfolio_back.model.Person;
import portfolio.sjmontini.portfolio_back.repo.PersonRepo;
import portfolio.sjmontini.portfolio_back.service.exception.UserNotFoundException;

@Service
public class PersonService {
    private final PersonRepo personRepo;
    
    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }
    
    public Person addPerson(Person person){
        return personRepo.save(person);
    }
    
    public List<Person> findAllPersons(){
        return personRepo.findAll();
    }
    
    public Person updatePerson(Person person){
        return personRepo.save(person);
    }
    
    public Person findPersonById(Long id){
        return personRepo.findPersonById(id)
                .orElseThrow(() -> new UserNotFoundException ("No se encontró a la persona con el id " + id ));
    }
    
    public void deletePerson(Long id){
        personRepo.deletePersonById(id);
    }
}
