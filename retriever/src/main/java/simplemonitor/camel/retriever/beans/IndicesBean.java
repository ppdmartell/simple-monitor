package simplemonitor.camel.retriever.beans;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import simplemonitor.camel.retriever.categories.CategoryDto;
import simplemonitor.camel.retriever.categories.CategoryUtils;
import simplemonitor.camel.retriever.controller.DispatchFacade;
import simplemonitor.camel.retriever.factory.CategoryFactory;



@Component
public class IndicesBean {

	@Autowired
	private DispatchFacade dispatchFacade;
	
	Gson gson = new Gson();
	Logger logger = LoggerFactory.getLogger(IndicesBean.class);
	
	LinkedList<CategoryDto> categories;

	
	public static String elasticsearchIp = "192.168.122.200";
	public static String elasticsearchPort = ":9200";
	public static String protocol = "http://";

	/**
	 * This method tries to get list of indexes from elasticsearch.
	 * Then sends this list as a text to purgeAndClassifyRawInfo(rawText)
	 * for further processing.
	**/
	public void indicesRetrieval() {
		HttpClient httpClient = HttpClient.newHttpClient();
		String URIparam = protocol +
	     		  elasticsearchIp +
	     		  elasticsearchPort + "/_cat/indices?";
		try {
    		HttpRequest getRequest = HttpRequest.newBuilder()
    				.uri(new URI(URIparam))
    				.build();
    		
    		HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
    		String rawText = getResponse.body();
    		purgeAndClassifyRawInfo(rawText);
    	}
    	catch(Exception e) {
    		logger.info("There has been some error trying to retrieving the indexes: " + e.getMessage());
    	}
	}
	
	/**
	 * Convert the raw text list of indexes
	 * and call process() for more further processing.
	 * @param rawText
	 */
	public void purgeAndClassifyRawInfo(String rawText) {
		categories = new LinkedList<CategoryDto>();
		rawText.lines().forEachOrdered(line -> {
			LinkedList<String> catAttribs = Arrays.stream(line.split("\\s+"))
					                              .collect(Collectors.toCollection(LinkedList::new));
			String indexName = catAttribs.get(2);
			catAttribs.add(3, CategoryUtils.getCategoryFromIndexName(indexName));
			CategoryDto category = CategoryFactory.getInstanceFromParams(catAttribs);
			categories.add(category);
		});
		this.process(categories);
	}
	
	/**
	 * This is a call to the Facade
	 * @param categoriesParam
	 */
	public void process(LinkedList<CategoryDto> categoriesParam) {
		for(CategoryDto category : categoriesParam) {
			dispatchFacade.process(category);
		}
	}
	
}
