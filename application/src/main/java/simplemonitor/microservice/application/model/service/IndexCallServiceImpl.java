package simplemonitor.microservice.application.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simplemonitor.microservice.application.model.dao.IIndexCallDao;
import simplemonitor.microservice.application.model.entity.IndexCall;

@Service
public class IndexCallServiceImpl implements IIndexCallService {
	
	Logger logger = LoggerFactory.getLogger(IndexCallServiceImpl.class);
	
	@Autowired
	private IIndexCallDao indexCallDao;

	@Override
	public void save(IndexCall indexCall) {
		logger.info("METHOD SAVE. indexCall ENTITY: " + indexCall.toString());
		indexCallDao.save(indexCall);
	}
	
}
