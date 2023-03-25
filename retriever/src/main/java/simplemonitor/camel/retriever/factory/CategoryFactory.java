package simplemonitor.camel.retriever.factory;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simplemonitor.camel.retriever.categories.ApplicationCategoryDto;
import simplemonitor.camel.retriever.categories.BootCategoryDto;
import simplemonitor.camel.retriever.categories.CategoryDto;
import simplemonitor.camel.retriever.categories.HardwareCategoryDto;
import simplemonitor.camel.retriever.categories.KernelCategoryDto;
import simplemonitor.camel.retriever.categories.SecurityCategoryDto;
import simplemonitor.camel.retriever.categories.UserCategoryDto;

public class CategoryFactory {

	public static CategoryDto getInstanceFromParams(LinkedList<String> params) {
		Logger logger = LoggerFactory.getLogger(CategoryFactory.class);
		CategoryDto category;
		switch(params.get(3)) {
			case "boot": {
				category = new BootCategoryDto(params.get(0),
	                    params.get(1),
	                    params.get(2),
	                    params.get(3),
	                    params.get(4),
	                    Integer.parseInt(params.get(5)),
	                    Integer.parseInt(params.get(6)),
	                    Integer.parseInt(params.get(7)),
	                    Integer.parseInt(params.get(8)),
	                    params.get(9),
	                    params.get(10));
				return category;
			}
			case "kernel": {
				category = new KernelCategoryDto(params.get(0),
	                    params.get(1),
	                    params.get(2),
	                    params.get(3),
	                    params.get(4),
	                    Integer.parseInt(params.get(5)),
	                    Integer.parseInt(params.get(6)),
	                    Integer.parseInt(params.get(7)),
	                    Integer.parseInt(params.get(8)),
	                    params.get(9),
	                    params.get(10));
				return category;
			}
			case "application": {
				category = new ApplicationCategoryDto(params.get(0),
	                    params.get(1),
	                    params.get(2),
	                    params.get(3),
	                    params.get(4),
	                    Integer.parseInt(params.get(5)),
	                    Integer.parseInt(params.get(6)),
	                    Integer.parseInt(params.get(7)),
	                    Integer.parseInt(params.get(8)),
	                    params.get(9),
	                    params.get(10));
				return category;
			}
			case "security": {
				category = new SecurityCategoryDto(params.get(0),
	                    params.get(1),
	                    params.get(2),
	                    params.get(3),
	                    params.get(4),
	                    Integer.parseInt(params.get(5)),
	                    Integer.parseInt(params.get(6)),
	                    Integer.parseInt(params.get(7)),
	                    Integer.parseInt(params.get(8)),
	                    params.get(9),
	                    params.get(10));
				return category;
			}
			case "hardware": {
				category = new HardwareCategoryDto(params.get(0),
	                    params.get(1),
	                    params.get(2),
	                    params.get(3),
	                    params.get(4),
	                    Integer.parseInt(params.get(5)),
	                    Integer.parseInt(params.get(6)),
	                    Integer.parseInt(params.get(7)),
	                    Integer.parseInt(params.get(8)),
	                    params.get(9),
	                    params.get(10));
				return category;
			}
			case "user": {
				category = new UserCategoryDto(params.get(0),
	                    params.get(1),
	                    params.get(2),
	                    params.get(3),
	                    params.get(4),
	                    Integer.parseInt(params.get(5)),
	                    Integer.parseInt(params.get(6)),
	                    Integer.parseInt(params.get(7)),
	                    Integer.parseInt(params.get(8)),
	                    params.get(9),
	                    params.get(10));
				return category;
			}
		}
		return null;
	}
	
}
