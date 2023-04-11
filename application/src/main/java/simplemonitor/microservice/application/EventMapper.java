package simplemonitor.microservice.application;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sisyphsu.dateparser.DateParserUtils;

import simplemonitor.microservice.application.model.entity.Event;
import simplemonitor.microservice.application.model.entity.Hit;

public class EventMapper {
	
	static Logger logger = LoggerFactory.getLogger(EventMapper.class);
	
	public static Event populateEvent(Hit hit) {
		Event event = new Event();
		event.setLegacyId(hit.getLegacyId());
		event.setIndexName(hit.getIndexName());
		event.setCategory(hit.getSource().getFields().getCategory());
		event.setHostname(hit.getSource().getHost().getHostname());
		event.setDatetime(dateProcess(hit.getSource().getTimestamp()));
		event.setLogFiles(hit.getSource().getLog().getFile().getPath());
		event.setMessage(hit.getSource().getMessage());
		event.setIp(hit.getSource().getHost().getIp().toString());
		event.setMac(hit.getSource().getHost().getMac().toString());
		event.setArchitecture(hit.getSource().getHost().getArchitecture());
		event.setOsName(hit.getSource().getHost().getOs().getName());
		event.setKernel(hit.getSource().getHost().getOs().getKernel());
		event.setOsType(hit.getSource().getHost().getOs().getType());
		event.setOsVersion(hit.getSource().getHost().getOs().getVersion());
		return event;
	}
	
	public static Date dateProcess(String date) {
		Date result = DateParserUtils.parseDate(date);
		return result;
	}

}
