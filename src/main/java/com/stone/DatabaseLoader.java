package com.stone;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.stone.model.Room;
import com.stone.service.RoomRepository;

@Component
@Profile("test")
public class DatabaseLoader implements CommandLineRunner {

	private final RoomRepository roomRepo;

	@Autowired
	public DatabaseLoader(RoomRepository roomRepository) {
		this.roomRepo = roomRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("#database load#");

		this.roomRepo.save(new Room("診間1", "王醫生", 2, new Date(), Room.STATUS_AVAIABLE));
		this.roomRepo.save(new Room("診間2", "陳醫生", 5, new Date(), Room.STATUS_AVAIABLE));
		this.roomRepo.save(new Room("診間3", "黃醫生", 0, new Date(), Room.STATUS_DISABLE));

	}
}