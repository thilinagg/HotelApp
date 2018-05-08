package com.incubate.service;

import java.util.List;

import com.incubate.models.Hotel;

public interface HotelService {
	
	public String addHotel(String hotel_name, String address, String city);
	
	public List<Hotel> getHotelList();
	
	public Hotel getHotel(String hotel_id);
	
	public String updateHotel(String hotel_name, String address, String city, String hotel_id);

}
