package dinhhieu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dinhhieu.entities.Motor;

@Service
public class MotorService {
	
	public List<Motor> getAllMotor(){
		//giả định dữ liệu nhập vào đều có id khác nhau
		ArrayList<Motor> motors = new ArrayList<Motor>();
		Motor m1 = new Motor(1,"wave","20 triệu");
		Motor m2 = new Motor(2,"SH","60 triệu");
		Motor m3 = new Motor(3,"Exciter","40 triệu");
		Motor m4 = new Motor(4,"Aỉblade","45 triệu");
		motors.add(m1);
		motors.add(m2);
		motors.add(m3);
		motors.add(m4);
		
		
		return motors;
	}
	
	public List<Motor> deleteMotorById(int id){
		ArrayList<Motor> motors = (ArrayList<Motor>) getAllMotor();
		if(id>0) {
			Motor motorDelete = motors.remove(id-1);
			return motors;
		}
	
		return null;
	}
	
	public Motor getMotorById(int id) {
		ArrayList<Motor> motors = (ArrayList<Motor>) getAllMotor();
		for(int i=0;i<motors.size();i++) {
			if (i+1 == id) {
				return motors.get(id);
			}
		}
		return null;
	}
	
	public List<Motor> updateMotor(int id, String name, String cost){
		ArrayList<Motor> motors = (ArrayList<Motor>) getAllMotor();
		for(int i = 0;i<motors.size();i++) {
			if (i != id) {
				Motor m5 = new Motor(id, name, cost);
				motors.add(m5);
				return motors;
			}
		}
		return motors;
		
	}
	

	
}
