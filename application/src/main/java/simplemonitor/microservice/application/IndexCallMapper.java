package simplemonitor.microservice.application;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import simplemonitor.microservice.application.dto.IndexCallDto;
import simplemonitor.microservice.application.model.entity.IndexCall;

@Mapper
public interface IndexCallMapper {

	IndexCallMapper INSTANCE = Mappers.getMapper(IndexCallMapper.class);
	
	public IndexCallDto toDto(IndexCall indexCall);
	public IndexCall toEntity(IndexCallDto indexCallDto);
	
}
