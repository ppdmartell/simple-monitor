package simplemonitor.camel.retriever.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simplemonitor.camel.retriever.restdto.TotalIndexesDto;
import simplemonitor.camel.retriever.service.ICategoryService;

@RestController
@RequestMapping("/api")
public class IndexesRestController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private TotalIndexesDto totalIndexesDto;
	
	@GetMapping("/indices")
	public TotalIndexesDto getIndexes() {
		totalIndexesDto.setDescription("All the registered indices.");
		totalIndexesDto.setIndices(categoryService.findAll());
		return totalIndexesDto;
	}

}
