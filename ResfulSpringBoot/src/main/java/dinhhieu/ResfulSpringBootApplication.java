package dinhhieu;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dinhhieu.entities.Motor;

@SpringBootApplication
public class ResfulSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResfulSpringBootApplication.class, args);
		Motor m1 = new Motor(1,"wave","20 triệu");
		Motor m2 = new Motor(2,"SH","60 triệu");
		Motor m3 = new Motor(3,"Exciter","40 triệu");
		Motor m4 = new Motor(4,"Aỉblade","45 triệu");
		
		ArrayList<Motor> motors = new ArrayList<Motor>();
		motors.add(m1);
	}

}
