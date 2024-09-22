package Items;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import Classes.Adventurer;

public class Item {
	private String name;
	private String stat;

	// Constructor
	public Item() {
		
	}
	
	public Item(String name, String stat) {
		this.name = name;
		this.stat = stat;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getStat() {
		return stat;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStat(String stat) {
		this.stat = stat;
	}
	
	// Method to use the item
	public void use(Adventurer player) {
		System.out.println("You use " + name);
	}
}
