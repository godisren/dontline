package com.stone.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stone.model.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
	@Override
	Room save(@Param("room") Room Room);

	@Override
	void delete(@Param("id") Long id);

	@Override
	void delete(@Param("Room") Room Room);

}
