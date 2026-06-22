package com.example.student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
	private StudentRepository studentRepository;
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	@Transactional
	public void insert(Student s) {
		studentRepository.save(s);
	}
	public Optional<Student> find(int id) {
		return studentRepository.findById(id);
	}
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	@Transactional
	public void delete(int id) {
		studentRepository.deleteById(id);
	}
	@Transactional
	public void update(int id,Student s) {
		Student student=studentRepository.findById(id).orElse(null);
		if(student!=null) {
			student.setName(s.getName());
			student.setBranch(s.getBranch());
			student.setCgpa(s.getCgpa());
			studentRepository.save(student);
		}
	}
}
