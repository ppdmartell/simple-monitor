package simplemonitor.camel.retriever.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simplemonitor.camel.retriever.model.entity.Category;
import simplemonitor.camel.retriever.restdto.TotalIndexesDto;
import simplemonitor.camel.retriever.service.ICategoryService;

@RestController
@RequestMapping("/api")
public class IndexesRestController {
	
	@Autowired
	private ICategoryService categoryService;
	
	//@Autowired
	//private TotalIndexesDto totalIndexesDto;
	
	@GetMapping("/indices")
	public List<Category> getIndexes() {
		return categoryService.findAll();
	}
	
	@GetMapping("/hosts")
	public List<String> getHosts() {
		List<String> hosts = categoryService.findAll()
				                .stream()
								.map(Category::getIndice)
								.map(category -> category.replaceAll("-(19|20)\\d\\d\\.(0[1-9]|1[012])\\.(0[1-9]|[12][0-9]|3[01])", ""))
								.map(category -> category.replaceAll("(kernel|user|hardware|security|application|boot)-", ""))
								.distinct()
								.collect(Collectors.toList());
		return hosts;
	}

}
