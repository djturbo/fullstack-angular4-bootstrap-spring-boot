package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.converter.ReservationRequestToReservation;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.converter.ReservationToReservationResponse;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.converter.RoomToReservableRoomResponseConverter;

@Configuration
public class ConversionConfig {
	@SuppressWarnings("rawtypes")
	private Set<Converter> getConverters() {
		Set<Converter> converters = new HashSet<Converter>();
		/* ADD CUSTOM CONVERTERS */
		converters.add(new RoomToReservableRoomResponseConverter());
		converters.add(new ReservationRequestToReservation());
		converters.add(new ReservationToReservationResponse());
		return converters;
	}
	
	@Bean 
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		
		return bean.getObject();
	}
}
