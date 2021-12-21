package dinhhieu;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Adult {
	
	@NotNull(message = "Name can't be null")
	private String name;
	
	@Min(value=16, message = "Thanh nien tren 18 tuoi moi duoc goi la nguoi lon")
	private int age;
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}
