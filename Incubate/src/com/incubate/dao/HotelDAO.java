package com.incubate.dao;

import java.util.List;

import com.incubate.models.Hotel;

public interface HotelDAO {

	public String addHotel(String hotel_name, String address, String city);
	public List<Hotel> getHotelsList();
	public Hotel getHotel(String hotel_id);
	public String updateHotel(String hotel_name, String address, String city, String hotel_id);

}
