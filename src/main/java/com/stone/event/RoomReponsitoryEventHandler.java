package com.stone.event;

import static com.stone.WebSocketConfiguration.MESSAGE_PREFIX;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.stone.model.Room;

@Component
@RepositoryEventHandler(Room.class)
public class RoomReponsitoryEventHandler {
	private final SimpMessagingTemplate websocket;

	private final EntityLinks entityLinks;

	@Autowired
	public RoomReponsitoryEventHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks) {
		this.websocket = websocket;
		this.entityLinks = entityLinks;
	}

	@HandleBeforeCreate
	public void beforeNewRoom(Room room) {
		room.setLastModifyDate(new Date());
	}

	@HandleBeforeSave
	public void beforeupdateRoom(Room room) {
		room.setLastModifyDate(new Date());
	}

	@HandleAfterCreate
	public void newRoom(Room room) {
		this.websocket.convertAndSend(MESSAGE_PREFIX + "/newRoom", getPath(room));
	}

	@HandleAfterDelete
	public void deleteRoom(Room room) {
		this.websocket.convertAndSend(MESSAGE_PREFIX + "/deleteRoom", getPath(room));
	}

	@HandleAfterSave
	public void updateRoom(Room room) {
		this.websocket.convertAndSend(MESSAGE_PREFIX + "/updateRoom", getPath(room));
	}

	/**
	 * Take an {@link Room} and get the URI using Spring Data REST's
	 * {@link EntityLinks}.
	 *
	 * @param room
	 */
	private String getPath(Room room) {
		String path = this.entityLinks.linkForSingleResource(room.getClass(), room.getRoomId()).toUri().getPath();
		// System.out.println(path);
		return path;
	}
}
