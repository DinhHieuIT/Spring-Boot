package dinhhieu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dinhhieu.entities.Motor;
import dinhhieu.service.MotorService;

@RestController
@RequestMapping("/rest")
public class MotorController {
	
	@Autowired
	MotorService motorService;
	
	// Get all Motor
	@GetMapping(value="/motors")
	public ResponseEntity<List<Motor>> getAllMotor(){
		List<Motor> motors = motorService.getAllMotor();
		return new ResponseEntity<List<Motor>>(motors,HttpStatus.OK);
	}
	
	//Get Motor By Id
	@GetMapping(value="/motors/{id}")
	public ResponseEntity<Motor> getMotorById(@PathVariable int id){
		Motor motor = motorService.getMotorById(id);
		return new ResponseEntity<Motor>(motor,HttpStatus.OK);
	}
	
	//Create a new Motor
	@PostMapping(value="/motors")
	public ResponseEntity<String> newMotor(){
		List<Motor> motors = motorService.updateMotor(5,"yamaha","80 triệu");
		return new ResponseEntity<String>("Created",HttpStatus.OK);
	}
	
	//Delete a motor
	@GetMapping(value="/delete/motors/{id}")
	public ResponseEntity<String> deleteMotor(){
		List<Motor> motors = motorService.deleteMotorById(2);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}
	
	}
