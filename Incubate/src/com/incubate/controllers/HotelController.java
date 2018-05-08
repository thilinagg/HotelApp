package com.incubate.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.incubate.models.Hotel;
import com.incubate.service.HotelService;
import com.incubate.service.UserService;

@Controller
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired(required=true)
	@Qualifier(value="hotelService")
	public void setHotelService(HotelService ps){
		this.hotelService = ps;
	}
	@Autowired
	HttpSession httpSession;
	
	
	@RequestMapping(value="/addHotel", method = RequestMethod.POST)
	public @ResponseBody String AddHotel(@RequestParam("hotel_name") String hotel_name, @RequestParam("address") String address, @RequestParam("city") String city){
		System.out.println(hotel_name);
		System.out.println(address);
		System.out.println(city);
		return hotelService.addHotel(hotel_name, address, city);
			
	}
	
	@RequestMapping(value="/updateHotel", method = RequestMethod.POST)
	public @ResponseBody String updateHotel(@RequestParam("hotel_name") String hotel_name, @RequestParam("address") String address, @RequestParam("city") String city, @RequestParam("hotel_id") String hotel_id){
		System.out.println(hotel_name);
		System.out.println(address);
		System.out.println(city);
		return hotelService.updateHotel(hotel_name, address, city, hotel_id);
			
	}
	

	@RequestMapping(value="/list_hotels", method = RequestMethod.GET)
	public @ResponseBody List<Hotel> list_hotels(){
		
		return hotelService.getHotelList();
			
	}

}
