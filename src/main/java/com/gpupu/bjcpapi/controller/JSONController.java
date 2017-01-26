package com.gpupu.bjcpapi.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gpupu.bjcpapi.model.Category;
import com.gpupu.bjcpapi.model.Subcategory;
import com.gpupu.bjcpapi.model.db.JsonFile;

@RestController
@EnableWebMvc
@RequestMapping("/2015")
public class JSONController {

	private JsonFile connector;
	private ObjectMapper mapper;

	public JSONController() {
		super();
		mapper = new ObjectMapper(); // can reuse, share globally
		connector = new JsonFile();
	}

	@RequestMapping("/all")
	@ResponseBody
	public List getAllCategories(Model model) {

		List categories = null;
		try {
			// jsonSubcat = mapper.writeValueAsString(subC);

			categories = retrieveCategories();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categories;

	}

	@RequestMapping(params = { "category" })
	@ResponseBody
	public List getCategoryByCode(Model model, @RequestParam(value = "category") String catCode) {

		List listCategories = null;
		try {
			listCategories = retrieveCategory(catCode);
			// jsonSubcat = catJson.toString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listCategories;

	}

	private List retrieveCategory(String categoryId) throws Exception {

		List jsonText = connector.retrieveCategory(categoryId);

		return jsonText;
	}

	/*
	 * @RequestMapping(value = "/test/category", produces = "application/json",
	 * method = RequestMethod.GET)
	 * 
	 * @ResponseBody public Category getTestCase(Model model) {
	 * 
	 * Category category = new Category(); category.setId("test01");
	 * category.setName("Test Category"); category.setNote(
	 * "This is a test category in order to check how return a POJO object as a JSON file. Hope this works!"
	 * );
	 * 
	 * model.addAttribute("category", category);
	 * 
	 * return category;
	 * 
	 * }
	 */

	// @RequestMapping(method = RequestMethod.GET)
	@RequestMapping(params = { "subcategory" })
	@ResponseBody
	public List getSubcategoryByCode(Model model, @RequestParam(value = "subcategory") String subcatCode) {

		List subcategories = null;
		try {
			subcategories = retrieveSubcategory(subcatCode);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return subcategories;

	}

	private List retrieveSubcategory(String subcategoryId) throws Exception {

		List subcategories = connector.retrieveSubcategory(subcategoryId);
		return subcategories;

	}

	@RequestMapping(params = { "tag" })
	@ResponseBody
	public List getSubcategoriesByTag(Model model, @RequestParam(value = "tag") String tagText) {

		List subcategories = null;
		try {
			subcategories = retrieveSubcategoriesByTag(tagText);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return subcategories;

	}

	private List retrieveSubcategoriesByTag(String tagText) throws Exception {

		List subcategories = connector.retrieveSubategoriesByTag(tagText);
		return subcategories;

	}

	private List<Category> retrieveCategories() throws Exception {

		// ObjectMapper mapper = new ObjectMapper(); // can reuse, share
		// globally
		String filePath = this.getClass().getResource("/escafandra.txt").getPath();
		PrintWriter writer = new PrintWriter(filePath, "UTF-8");

		try {
			File file = new File(this.getClass().getResource("/json/styleguide-2015.json").getPath());
			JsonNode jNode = mapper.readTree(file);
			JsonNode categories = jNode.path("styleguide").path("class").get(0).path("category");

			Iterator<JsonNode> iterator = categories.getElements();
			ArrayList<Category> categoryList = new ArrayList<Category>();

			// writer.println("The first line before our loop");
			// writer.println("The second line before our loop");

			while (iterator.hasNext()) {
				JsonNode category = iterator.next();

				// writer.println("ID: " + category.path("id").getTextValue());
				// writer.println("Name: " +
				// category.path("name").getTextValue());

				Category item = new Category();
				item.setId(category.path("id").getTextValue());
				item.setName(category.path("name").getTextValue());
				item.setNote(category.path("notes").getTextValue());
				item.setSubcategories(retrieveSubcategories(category.path("subcategory")));

				categoryList.add(item);
			}

			return categoryList;
		} catch (Exception ex) {

		} finally {
			writer.close();
		}

		return null;
	}

	private List<Subcategory> retrieveSubcategories(JsonNode subcategories) throws Exception {

		ArrayList<Subcategory> subcatList = new ArrayList<Subcategory>();
		Iterator<JsonNode> iterator = subcategories.getElements();

		while (iterator.hasNext()) {
			JsonNode subcat = iterator.next();

			Subcategory item = new Subcategory();

			item.setId(subcat.path("id").getTextValue());
			item.setName(subcat.path("name").getTextValue());
			item.setImpression(subcat.path("impression").getTextValue());
			item.setAroma(subcat.path("aroma").getTextValue());
			item.setAppearance(subcat.path("appearance").getTextValue());
			item.setFlavor(subcat.path("flavor").getTextValue());
			item.setMouthfeel(subcat.path("mouthfeel").getTextValue());
			item.setComments(subcat.path("comments").getTextValue());
			item.setHistory(subcat.path("history").getTextValue());
			item.setIngredients(subcat.path("ingredients").getTextValue());
			item.setComparison(subcat.path("comparison").getTextValue());

			subcatList.add(item);
		}

		return subcatList;
	}

}