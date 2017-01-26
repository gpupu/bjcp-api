package com.gpupu.bjcpapi.model;

import java.util.Arrays;

public class Subcategory {

	private String id;
	private String name;
	private String impression;
	private String aroma;
	private String appearance;
	private String flavor;
	private String mouthfeel;
	private String comments;
	private String history;
	private String ingredients;
	private String comparison;
	private String[] examples;
	private String[] tags;
	private String[] stats;

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

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getAroma() {
		return aroma;
	}

	public void setAroma(String aroma) {
		this.aroma = aroma;
	}

	public String getAppearance() {
		return appearance;
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getMouthfeel() {
		return mouthfeel;
	}

	public void setMouthfeel(String mouthfeel) {
		this.mouthfeel = mouthfeel;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getComparison() {
		return comparison;
	}

	public void setComparison(String comparison) {
		this.comparison = comparison;
	}

	public String[] getExamples() {
		return examples;
	}

	public void setExamples(String[] examples) {
		this.examples = examples;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Subcategory [id=" + id + ", name=" + name + ", impression=" + impression + ", aroma=" + aroma
				+ ", appearance=" + appearance + ", flavor=" + flavor + ", mouthfeel=" + mouthfeel + ", comments="
				+ comments + ", history=" + history + ", ingredients=" + ingredients + ", comparison=" + comparison
				+ ", examples=" + Arrays.toString(examples) + ", tags=" + Arrays.toString(tags) + ", stats="
				+ Arrays.toString(stats) + ", toString()=" + super.toString() + "]";
	}

}
