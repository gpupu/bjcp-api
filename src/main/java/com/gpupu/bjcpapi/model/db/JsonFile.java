package com.gpupu.bjcpapi.model.db;

import java.io.File;
import java.util.List;

import com.gpupu.bjcpapi.model.Category;
import com.gpupu.bjcpapi.model.Subcategory;
import com.jayway.jsonpath.JsonPath;

public class JsonFile {

	private final static String FILE_NAME = "styleguide-2015.min.json"; // "styleguide-2015.json";
	// private final static String FILE_PATH =
	// this.getClass().getResource("/json/styleguide-2015.json").getPath();

	public List<Category> retrieveCategory(String categoryId) throws Exception {

		File file = new File(this.getClass().getResource("/json/" + FILE_NAME).getPath());

		JsonPath path = JsonPath.compile("$.styleguide.class[0].category[?(@.id==" + categoryId + ")]");
		List<Category> category = path.read(file);

		return category;
	}

	public List<Subcategory> retrieveSubcategory(String subcatId) throws Exception {
		File file = new File(this.getClass().getResource("/json/" + FILE_NAME).getPath());

		JsonPath path = JsonPath
				.compile("$.styleguide.class[0].category[*].subcategory[?(@.id == '" + subcatId + "')]");
		List<Subcategory> subcategories = path.read(file);

		return subcategories;
	}

	public List retrieveSubategoriesByTag(String tag) throws Exception {
		File file = new File(this.getClass().getResource("/json/" + FILE_NAME).getPath());

		JsonPath path = JsonPath
				.compile("$.styleguide.class[0].category[*].subcategory[?(@.tags.indexOf(" + tag + ") != -1)]");
		List<Subcategory> subcategories = path.read(file);

		return subcategories;

	}

}
