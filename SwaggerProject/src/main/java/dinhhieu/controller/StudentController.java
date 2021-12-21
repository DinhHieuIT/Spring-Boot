package dinhhieu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dinhhieu.entities.Student;
import dinhhieu.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
@Api(tags = "Student Rest Controller")
//@Api Dùng để nhóm tất cả các method trong class thành một nhóm.
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//Tạo mới 1 student
	@PostMapping
	@ApiOperation(value="Create new User")
	//apiOperation chỉ rõ method nào sẽ được tạo document:
	//tags : Khai báo nhóm 
	//value: Mô tả chức năng của method 
	//apiresponse chỉ rõ code và message trả về.
	@ApiResponses(value = { @ApiResponse(code=200, message="Success"),
			                @ApiResponse(code=400, message="Bad Request"),
			                @ApiResponse(code=500, message="Internet server error")
	})
	public ResponseEntity<Student> newStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.save(student),HttpStatus.OK);
	}
	
	//Lấy ra toàn bộ danh sách student
	@GetMapping
	@ApiOperation(value="Get all Students", tags="Students Rest Controller")
	@ApiResponses(value = { @ApiResponse(code=200, message="Success"),
			                @ApiResponse(code=400, message="Bad Request"),
			                @ApiResponse(code=500, message="Internet server error")
	})
	public ResponseEntity<Iterable<Student>> getAllStudent(){
		return new ResponseEntity<Iterable<Student>>(studentService.findAll(),HttpStatus.OK);
	}
	
	//Lấy ra một student theo id
	@GetMapping("/{id}")
	@ApiOperation(value="Get Student by Id", tags="Students")
	@ApiResponses(value = { @ApiResponse(code=200, message="Success"),
			                @ApiResponse(code=400, message="Bad Request"),
			                @ApiResponse(code=500, message="Internet server error")
	})
	public ResponseEntity<Student> getStudent(@PathVariable Long id){
		Optional<Student> studentOptional = studentService.findById(id);
		return studentOptional.map(student -> new ResponseEntity<>(student,HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.OK));
	}
	
	//Cập nhật category
	@PutMapping("/{id}")
	@ApiOperation(value="Update Students")
	@ApiResponses(value = { @ApiResponse(code=200, message="Success"),
			                @ApiResponse(code=400, message="Bad Request"),
			                @ApiResponse(code=500, message="Internet server error")
	})
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, Student student){
		Optional<Student> oldStudent = studentService.findById(id);
		return oldStudent.map(newStudent -> { studentService.remove(id);
		return new ResponseEntity<>(newStudent ,HttpStatus.OK);	
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	

}
