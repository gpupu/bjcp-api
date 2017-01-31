package com.gpupu.bjcpapi.model.db;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

import java.io.File;
import java.util.List;

import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

public class JsonFile {

	private final static String FILE_NAME = "styleguide-2015.min.json"; // "styleguide-2015.json";
	// private final static String FILE_PATH =
	// this.getClass().getResource("/json/styleguide-2015.json").getPath();

	private List compileAndRead(String jsonPath) throws Exception {
		return compileAndRead(jsonPath, null);
	}

	private List compileAndRead(String jsonPath, Filter filter) throws Exception {
		File file = new File(this.getClass().getResource("/json/" + FILE_NAME).getPath());

		JsonPath path;
		if (filter != null) {
			path = JsonPath.compile(jsonPath, filter);
		} else {
			path = JsonPath.compile(jsonPath);
		}

		return path.read(file);

	}

	public List retrieveCategory(String categoryId) throws Exception {
		String jsonPath = "$.styleguide.class[0].category[?(@.id==" + categoryId + ")]";

		return compileAndRead(jsonPath);
	}

	public List retrieveSubcategory(String subcatId) throws Exception {
		String jsonPath = "$.styleguide.class[0].category[*].subcategory[?(@.id == '" + subcatId + "')]";

		return compileAndRead(jsonPath);
	}

	public List retrieveSubcategoriesByTag(String tag) throws Exception {

		Filter tagFilter = filter(where("tags").contains(tag));

		String jsonPath = "$.styleguide.class[0].category[*].subcategory[?]";

		return compileAndRead(jsonPath, tagFilter);

	}

}
