package com.sjsq;

public class Mouse implements Pet {
	String age;
	String name;
	String price;
	String color;
	String pic_routh;
	static String kind = " Û";

	Mouse(String name, String age, String color, String price, String routh) {
		this.name = name;
		this.color = color;
		this.age = age;
		this.price = price;
		this.pic_routh = routh;
	}

	public String getKind() {
		return kind;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String getAge() {
		return age;
	}

	public String getPrice() {
		return price;
	}

	public String getPic_routh() {
		return pic_routh;
	}

	public void Change(Pet pet) {
		if (!pet.getName().equals(""))
			name = pet.getName();
		if (!pet.getAge().equals(""))
			age = pet.getAge();
		if (!pet.getColor().equals(""))
			color = pet.getColor();
		if (!pet.getPrice().equals(""))
			price = pet.getPrice();
		if (!pet.getPic_routh().equals(""))
			pic_routh = pet.getPic_routh();
	}
}