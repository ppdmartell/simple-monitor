package simplemonitor.camel.retriever.dispatchers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simplemonitor.camel.retriever.categories.CategoryDto;

public class SecurityDispatcher extends Dispatcher {

	Logger logger = LoggerFactory.getLogger(ApplicationDispatcher.class);
	
	public SecurityDispatcher() {
		this.setEndpointProtocol("http://");
		this.setEndpointIPAddress("192.168.122.202");
		this.setEndpointPort("9999");
		this.setRoute("TODO");
	}

	@Override
	public void dispatch(CategoryDto category, boolean update) {
		// TODO Auto-generated method stub
		logger.info("Dispatching - > [" + category.getCategory() + "] [" + category.getIndice() + "]");
	}

}
