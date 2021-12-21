package dinhhieu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhhieu.entities.Student;
import dinhhieu.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Iterable<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Optional<Student> findById(Long id) {
		return studentRepo.findById(id);
	}

	@Override
	public Student save(Student st) {
		return studentRepo.save(st);
	}

	@Override
	public void remove(Long id) {
		studentRepo.deleteById(id);
	}

}
