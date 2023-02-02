package com.iu.s1.army;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Soldier {

//	private Gun gun;
	
	private String name;
	private int age;
	
	@Autowired
	private Gun sg; //타입이 같은게 여러개면 같은 이름을 집어넣음
	@Autowired
	@Qualifier("rf") //만약 같은 이름이 없으면 이걸찾음
	private Gun rifle;

//	@Autowired
//	public void setGun (Gun gun) {
//		this.gun = gun;
//	}
//	
//	public void useGun() {
//		this.gun.trigger();
//	}
//	public Gun getGun() {
//		return gun;
//	}
	
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
