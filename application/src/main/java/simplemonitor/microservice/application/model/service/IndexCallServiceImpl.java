package simplemonitor.microservice.application.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simplemonitor.microservice.application.model.dao.IIndexCallDao;
import simplemonitor.microservice.application.model.entity.IndexCall;

@Service
public class IndexCallServiceImpl implements IIndexCallService {
	
	@Autowired
	private IIndexCallDao indexCallDao;

	@Override
	public void save(IndexCall indexCall) {
		indexCallDao.save(indexCall);
	}
	
}
