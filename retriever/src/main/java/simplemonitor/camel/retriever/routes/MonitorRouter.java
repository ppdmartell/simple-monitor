package simplemonitor.camel.retriever.routes;

import java.util.LinkedList;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import simplemonitor.camel.retriever.beans.IndicesBean;

@Component
public class MonitorRouter extends RouteBuilder {
	
	Logger logger = LoggerFactory.getLogger(MonitorRouter.class);

	@Autowired
	private IndicesBean indicesBean;
	
	private int periodInMiliseconds = 20000;
	
	/**
	 * Thanks to Apache Camel capabilities method indicesRetrieval
	 * in class indicesBean will be executed every time depending on the value
	 * defined by the variable periodInMiliseconds.
	 */
	@Override
	public void configure() throws Exception {
				
		from("timer:indicesTimer?period=" + periodInMiliseconds)
		.to("direct:harvester");
		
		from("direct:harvester")
		.bean(indicesBean, "indicesRetrieval")
		.to("log:harvester");
		
	}

}
