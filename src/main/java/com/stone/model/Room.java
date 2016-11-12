package com.stone.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ROOM")
public class Room implements Serializable {

	public final static String STATUS_AVAIABLE = "Y";
	public final static String STATUS_DISABLE = "N";
	
	public Room(String roomName, String ownerName, Integer currentNum, Date lastModifyDate,
			String status) {
		super();
		this.roomName = roomName;
		this.ownerName = ownerName;
		this.currentNum = currentNum;
		this.lastModifyDate = lastModifyDate;
		this.status = status;
	}

	public Room() {
		super();
	}

	@Id
	@GeneratedValue
	@Column(name = "ROOM_ID")
	private Long roomId;
	//private String roomId;

	@Column(name = "ROOM_NAME")
	private String roomName;

	@Column(name = "OWNER_NAME")
	private String ownerName;

	@Column(name = "CURRENT_NUM")
	private Integer currentNum;

	@Column(name = "LAST_MODIFY_DATE")
	private Date lastModifyDate;

	@Column(name = "STATUS")
	private String status;	
	
	

}
