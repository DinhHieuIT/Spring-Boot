package dinhhieu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dinhhieu.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
