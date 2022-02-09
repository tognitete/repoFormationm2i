package com.hp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.dao.Dao;
import com.hp.models.Room;

@RestController
@RequestMapping("/v1")
public class RoomController {
	@Autowired
	private Dao db;
	private List<Room> rooms;
	private Room room;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@GetMapping("/room")
	public List<Room> getRooms() {
		rooms = (List<Room>) db.findAll("Room");
		return rooms;
	}
	
	@Transactional
	@GetMapping("/room/{id}")
	public Room read(@PathVariable("id") int id) {
		room = (Room) db.find(Room.class, id);
		return room;
	}
}
