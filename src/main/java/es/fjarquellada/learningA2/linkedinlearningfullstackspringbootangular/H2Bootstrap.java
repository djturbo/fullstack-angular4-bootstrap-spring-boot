package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.entity.Room;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.repository.RoomRepository;

@Component
public class H2Bootstrap implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(H2Bootstrap.class);

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public void run(String... arg0) throws Exception {
		roomRepository.save(new Room(405, "200"));
		roomRepository.save(new Room(410, "211"));
		roomRepository.save(new Room(415, "222"));

		LOG.info("Obteniendo rooms : .....");
		roomRepository.findAll().forEach(room -> {
			LOG.info("room: id: {} number: {} price: {}", room.getId(), room.getRoomNumber(), room.getPrice());
		});
	}

}
