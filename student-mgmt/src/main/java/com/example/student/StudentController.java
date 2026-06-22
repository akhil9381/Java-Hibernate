package com.example.student;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	private StudentService studentService;
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
	}
	@PostMapping("/students")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Student s) {
		studentService.insert(s);
	}
	@GetMapping("/students/{id}")
	public Optional<Student> find(@PathVariable int id) {
		return studentService.find(id);
	}
	@GetMapping("/students")
	public List<Student> findAll(){
		return studentService.findAll();
	}
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable int id) {
		studentService.delete(id);
	}
	@PutMapping("/students/{id}")
	public void update(@RequestBody Student s,@PathVariable int id) {
		studentService.update(id,s);
	}
}
