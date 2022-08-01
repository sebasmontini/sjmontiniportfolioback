package portfolio.sjmontini.portfolio_back;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portfolio.sjmontini.portfolio_back.model.Person;
import portfolio.sjmontini.portfolio_back.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonResource {
    private final PersonService personService;
    
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons (){           //Método que devuelve una HTTP Response y en el cuerpo habrá una lista o array de empleados.
        List<Person> persons = personService.findAllPersons();  //En este punto lo que tenemos que hacer es llamar al servicio y el servicio devolverá el listado
        return new ResponseEntity<>(persons, HttpStatus.OK);          //de todos los empleados que se encuntren en la Base de Datos.
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Person> getPersonById (@PathVariable("id") Long id){                 //Método para buscar un person por su id.
        Person person = personService.findPersonById(id);  
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    
    //Método para agregar un person. Usa método Post ya que realizará un cambio en el Back End.
    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){     //en addPerson esperamos el objeto completo person que va a estar en formato json que vendrá del usuario.
        Person newPerson = personService.addPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }
    
    //Método para actualizar un person. Usa el método Put ya que está haciendo una actualización sobre algo que ya exite.
    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){     //en addPerson esperamos el objeto completo person que va a estar en formato json que vendrá del usuario.
        Person updatePerson = personService.updatePerson(person);
        return new ResponseEntity<>(updatePerson, HttpStatus.OK);
    }
    
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id){     //en addPerson esperamos el objeto completo person que va a estar en formato json que vendrá del usuario.
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
