package moee.henaknowledge.repository;

import moee.henaknowledge.module.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
