package com.incubate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;


import com.incubate.models.Hotel;

@Repository
public class HotelDAOImpl implements HotelDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public List<Hotel> getHotelsList() {
		
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT hotel_name, address, city FROM hotel ORDER BY hotel_id DESC LIMIT 50";

		@SuppressWarnings("unchecked")
		List<Hotel> hotelList = (List<Hotel>) session
			.createSQLQuery(sql)
			.addScalar("hotel_name", new StringType())
			.addScalar("address", new StringType())
			.addScalar("city", new StringType())
			.setResultTransformer(Transformers.aliasToBean(Hotel.class)).list();
		
		return hotelList;
	}

	@Override
	public String addHotel(String hotel_name, String address, String city) {
		Session session = sessionFactory.getCurrentSession();
		String sql ="INSERT INTO hotel (hotel_name, address, city) VALUES (:hotel_name, :address, :city)";
		session.createSQLQuery(sql)
		.setParameter("hotel_name", hotel_name)
		.setParameter("address", address)
		.setParameter("city", address)
		.executeUpdate();
		
		return "Hotel Added!";
	}

	@Override
	public Hotel getHotel(String hotel_id) {
		
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT * FROM hotel WHERE hotel_id =:hotel_id";
		Hotel hotel = (Hotel)session
				.createSQLQuery(sql)
				.setParameter("hotel_id", hotel_id)
				.uniqueResult();
		
		return hotel;
	}

	@Override
	public String updateHotel(String hotel_name, String address, String city, String hotel_id) {
		Session session = sessionFactory.getCurrentSession();
		String sql ="UPDATE hotel SET hotel_name=:hotel_name , address = :address, city = :city WHERE hotel_id= :hotel_id";
		session.createSQLQuery(sql)
		.setParameter("hotel_name", hotel_name)
		.setParameter("address", address)
		.setParameter("city", address)
		.setParameter("hotel_id", hotel_id)
		.executeUpdate();
		
		return "Hotel Updated!";
	}


	


}
