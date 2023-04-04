package simplemonitor.microservice.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import simplemonitor.microservice.application.dto.AgentDto;
import simplemonitor.microservice.application.dto.EcsDto;
import simplemonitor.microservice.application.dto.FieldsDto;
import simplemonitor.microservice.application.dto.FileDto;
import simplemonitor.microservice.application.dto.HitDto;
import simplemonitor.microservice.application.dto.HitsDto;
import simplemonitor.microservice.application.dto.HostDto;
import simplemonitor.microservice.application.dto.IndexCallDto;
import simplemonitor.microservice.application.dto.InputDto;
import simplemonitor.microservice.application.dto.LogDto;
import simplemonitor.microservice.application.dto.OsDto;
import simplemonitor.microservice.application.dto.ShardsDto;
import simplemonitor.microservice.application.dto.SourceDto;
import simplemonitor.microservice.application.dto.TotalDto;
import simplemonitor.microservice.application.model.entity.Agent;
import simplemonitor.microservice.application.model.entity.Ecs;
import simplemonitor.microservice.application.model.entity.Fields;
import simplemonitor.microservice.application.model.entity.File;
import simplemonitor.microservice.application.model.entity.Hit;
import simplemonitor.microservice.application.model.entity.Hits;
import simplemonitor.microservice.application.model.entity.Host;
import simplemonitor.microservice.application.model.entity.IndexCall;
import simplemonitor.microservice.application.model.entity.Input;
import simplemonitor.microservice.application.model.entity.Log;
import simplemonitor.microservice.application.model.entity.Os;
import simplemonitor.microservice.application.model.entity.Shards;
import simplemonitor.microservice.application.model.entity.Source;
import simplemonitor.microservice.application.model.entity.Total;

@Component
public class IndexMapper {
	
	public IndexCall mapIndexDtoToEntity(IndexCallDto indexCallDto) {
		IndexCall indexCall = new IndexCall();
		Hits hits = mapParentHitsDtoToEntity(indexCallDto.getHits());
		Shards shards = mapShardsDtoToEntity(indexCallDto.getShardsDto());
		
		indexCall.setHits(hits);
		indexCall.setShards(shards);
		indexCall.setTimedOut(indexCallDto.isTimedOut());
		indexCall.setTook(indexCallDto.getTook());
		return indexCall;
	}
	
	public List<Hit> mapHitsDtoToEntity(List<HitDto> hitsDto) {
		List<Hit> hits = new ArrayList<>();
		for(HitDto hitDto : hitsDto) {
			File file = mapFileDtoToEntity(hitDto.getSource().getLog().getFile());
			Log log = mapLogDtoToEntity(hitDto.getSource().getLog());
			Ecs ecs = mapEcsDtoToEntity(hitDto.getSource().getEcs());
			Agent agent = mapAgentDtoToEntity(hitDto.getSource().getAgent());
			Os os = mapOsDtoToEntity(hitDto.getSource().getHost().getOs());
			Host host = mapHostDtoToEntity(hitDto.getSource().getHost());
			Fields fields = mapFieldsToEntity(hitDto.getSource().getFields());
			Input input = mapInputToEntity(hitDto.getSource().getInput());
			Source source = mapSourceToEntity(hitDto.getSource());
			
			/* Setting source */
			log.setFile(file);
			host.setOs(os);
			source.setAgent(agent);
			source.setEcs(ecs);
			source.setFields(fields);
			source.setHost(host);
			source.setInput(input);
			source.setLog(log);
			
			/* Setting hit */
			Hit hit = new Hit();
			hit.setIgnored(hitDto.getIgnored());
			hit.setIndexName(hitDto.getIndexName());
			hit.setLegacyId(hitDto.getLegacyId());
			hit.setScore(hitDto.getScore());
			hit.setSource(source);
			
			hits.add(hit);
		}
		return hits;
	}
	
	public File mapFileDtoToEntity(FileDto fileDto) {
		File file = new File();
		file.setPath(fileDto.getPath());
		return file;
	}
	
	public Log mapLogDtoToEntity(LogDto logDto) {
		Log log = new Log();
		log.setOffset(logDto.getOffset());
		return log;
	}
	
	public Ecs mapEcsDtoToEntity(EcsDto ecsDto) {
		Ecs ecs = new Ecs();
		ecs.setVersion(ecsDto.getVersion());
		return ecs;
	}
	
	public Agent mapAgentDtoToEntity(AgentDto agentDto) {
		Agent agent = new Agent();
		agent.setEphemeralId(agentDto.getEphemeralId());
		agent.setLegacyId(agentDto.getLegacyId());
		agent.setName(agentDto.getName());
		agent.setType(agentDto.getType());
		agent.setVersion(agentDto.getVersion());
		return agent;
	}
	
	public Os mapOsDtoToEntity(OsDto osDto) {
		Os os = new Os();
		os.setCodename(osDto.getCodename());
		os.setFamily(osDto.getFamily());
		os.setKernel(osDto.getKernel());
		os.setName(osDto.getName());
		os.setPlatform(osDto.getPlatform());
		os.setType(osDto.getType());
		os.setVersion(osDto.getVersion());
		return os;
	}
	
	public Host mapHostDtoToEntity(HostDto hostDto) {
		Host host = new Host();
		host.setArchitecture(hostDto.getArchitecture());
		host.setContainerized(hostDto.isContainerized());
		host.setHostname(hostDto.getHostname());
		host.setIp(hostDto.getIp());
		host.setLegacyId(hostDto.getLegacyId());
		host.setMac(hostDto.getMac());
		host.setName(hostDto.getName());
		return host;
	}
	
	public Fields mapFieldsToEntity(FieldsDto fieldsDto) {
		Fields fields = new Fields();
		fields.setCategory(fieldsDto.getCategory());
		fields.setNode(fieldsDto.getNode());
		return fields;
	}
	
	public Input mapInputToEntity(InputDto inputDto) {
		Input input = new Input();
		input.setType(inputDto.getType());
		return input;
	}
	
	public Source mapSourceToEntity(SourceDto sourceDto) {
		Source source = new Source();
		source.setMessage(sourceDto.getMessage());
		source.setTimestamp(sourceDto.getTimestamp());
		source.setTags(sourceDto.getTags());
		return source;
	}
	
	public Hits mapParentHitsDtoToEntity(HitsDto hitsDto) {
		Hits hits = new Hits();
		List<Hit> hitsList = mapHitsDtoToEntity(hitsDto.getHits());
		Total total = mapTotalDtoToEntity(hitsDto.getTotal());
		hits.setHits(hitsList);
		hits.setTotal(total);
		hits.setMaxScore(hitsDto.getMaxScore());
		for(int i = 0; i < hits.getHits().size(); i++) {
			hits.getHits().get(i).setHits(hits);
		}
		return hits;
	}
	
	public Total mapTotalDtoToEntity(TotalDto totalDto) {
		Total total = new Total();
		total.setRelation(totalDto.getRelation());
		total.setValue(totalDto.getValue());
		return total;
	}
	
	public Shards mapShardsDtoToEntity(ShardsDto shardsDto) {
		Shards shards = new Shards();
		shards.setFailed(shardsDto.getFailed());
		shards.setSkipped(shardsDto.getSkipped());
		shards.setSuccessful(shardsDto.getSuccessful());
		shards.setTotal(shardsDto.getTotal());
		return shards;
	}

}
