package com.gpupu.bjcpapi.model;

import java.util.List;

public class Category {
	private String id;
	private String name;
	private String note;
	private List<Subcategory> subcategories;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	public String toString() {
		String category = "";
		category += "Id: " + id + "\n";
		category += "Name: " + name + "\n";
		category += "Notes: " + note + "\n";
		category += "Subcategories: " + subcategories + "\n";

		return category;
	}
}
