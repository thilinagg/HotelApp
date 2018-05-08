package com.incubate.service;

import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incubate.dao.HotelDAO;
import com.incubate.dao.UserDAO;
import com.incubate.models.Hotel;

@Service
public class HotelServiceImpl implements HotelService{
	
	private HotelDAO hotelDAO;

	public void setHotelDAO(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}

	@Override
	@Transactional
	public List<Hotel> getHotelList() {
		
		return hotelDAO.getHotelsList();
	}

	@Override
	@Transactional
	public String addHotel(String hotel_name, String address, String city) {
		
		return hotelDAO.addHotel(hotel_name, address, city);
	}

	@Override
	@Transactional
	public Hotel getHotel(String hotel_id) {
		return hotelDAO.getHotel(hotel_id);
	}

	@Override
	@Transactional
	public String updateHotel(String hotel_name, String address, String city, String hotel_id) {
		
		return hotelDAO.updateHotel(hotel_name, address, city, hotel_id);
	}
}
