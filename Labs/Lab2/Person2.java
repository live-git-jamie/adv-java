package Lab2;


public class Person2 {
	// declare fields
	private int personID;
	private int age;
	private float salary;
	
	public Person2() {
		this.personID = -1;
		this.age = -1;
		this.salary = 0.0f;
	}
	public Person2(int personID, int age, float salary) {
		this.personID = personID;
		this.age = age;
		this.salary = salary;
	}
	
	public int getID() {
		return personID;
	}

	public int getAge() {
		return age;
	}

	public float getSalary() {
		return salary;
	}
	
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Person [ID="+personID+", age="
				+age+", salary="+salary+"]";
	}
}

