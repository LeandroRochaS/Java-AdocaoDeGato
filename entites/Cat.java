package entites;

public class Cat {
	private String singleCode;
	private String name;
	private String race;
	private String surname;
	private String gender;
	private String entryDate;
	private double age;
	private String food;
	private String quantityFood;
	private String weight;
	private String exitDate;
	private String cpfAdopter;
	
	public Cat(String singleCode, String name, String race, String surname, String gender, String entryDate, double age2,
			String food, String quantityFood, String weight, String exitDate, String cpfAdopter) {
		super();
		this.singleCode = singleCode;
		this.name = name;
		this.race = race;
		this.surname = surname;
		this.gender = gender;
		this.entryDate = entryDate;
		this.age = age2;
		this.food = food;
		this.quantityFood = quantityFood;
		this.weight = weight;
		this.exitDate = exitDate;
		this.cpfAdopter = cpfAdopter;
	}
	
	public String getSingleCode() {
		return singleCode;
	}
	public void setSingleCode(String singleCode) {
		this.singleCode = singleCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getQuantityFood() {
		return quantityFood;
	}
	public void setQuantityFood(String quantityFood) {
		this.quantityFood = quantityFood;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getExitDate() {
		return exitDate;
	}
	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}
	public String getCpfAdopter() {
		return cpfAdopter;
	}
	public void setCpfAdopter(String cpfAdopter) {
		this.cpfAdopter = cpfAdopter;
	}

	@Override
	public String toString() {
		return "Cat [singleCode=" + singleCode + ", name=" + name + ", race=" + race + ", surname=" + surname
				+ ", gender=" + gender + ", entryDate=" + entryDate + ", age=" + age + ", food=" + food
				+ ", quantityFood=" + quantityFood + ", weight=" + weight + ", exitDate=" + exitDate + ", cpfAdopter="
				+ cpfAdopter + "]";
	}
	
	
	
	
	
	

}
