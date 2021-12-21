package dinhhieu;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Main {

	public static void main(String[] args) {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Adult adult = new Adult();
		adult.setName("Google");
		adult.setAge(15);
		
		Set<ConstraintViolation<Adult>> violations = validator.validate(adult);
		for(ConstraintViolation<Adult> violation : violations) {
			System.err.println(violation.getMessage());
		}

	}

}
