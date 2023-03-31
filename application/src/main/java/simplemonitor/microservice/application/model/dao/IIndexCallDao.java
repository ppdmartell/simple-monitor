package simplemonitor.microservice.application.model.dao;

import org.springframework.data.repository.CrudRepository;

import simplemonitor.microservice.application.model.entity.IndexCall;

public interface IIndexCallDao extends CrudRepository<IndexCall, Long> {

}
