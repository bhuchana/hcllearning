package com.hcl.flight.flightreservation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flight.flightreservation.dao.AirlinesRepository;
import com.hcl.flight.flightreservation.dao.PassengerRepository;
import com.hcl.flight.flightreservation.dao.ReservationRepository;
import com.hcl.flight.flightreservation.dao.UserRepository;
import com.hcl.flight.flightreservation.dto.PassengerDTO;
import com.hcl.flight.flightreservation.dto.ReservationRequest;
import com.hcl.flight.flightreservation.entity.Airline;
import com.hcl.flight.flightreservation.entity.Passenger;
import com.hcl.flight.flightreservation.entity.User;
import com.hcl.flight.flightreservation.entity.UserBooking;


@Service
public class AirlinesServiceImpl implements AirlinesService {
	
	@Autowired
	private AirlinesRepository airlinesRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Airline save(Airline airline) throws RuntimeException {
		
		return airlinesRepository.save(airline);
	}



	@Override
	public List<Airline> findAirlines(String source, String destination) {
		return airlinesRepository.findAirlines(source, destination);
	}



	@Override
	public String createReservation(Long userId, Long airlineId, ReservationRequest reservationRequest) {
		
		List<PassengerDTO> list = reservationRequest.getList();
		List<Passenger> passengers=new ArrayList<>();
		if(!list.isEmpty()) {
			 list.stream().forEach(passengerDTO ->{
				 Passenger passenger=new Passenger();
				 passenger.setAge(passengerDTO.getAge());
				 passenger.setFirstName(passengerDTO.getFirstName());
				 passenger.setLastName(passengerDTO.getLastName());
				 passenger.setGender(passengerDTO.getGender());
				 passenger.setMealPreferences(passengerDTO.getMealPreferences());
				 passengers.add(passenger);
			 });
			
		}
		
		for(Passenger passenger:passengers) {
			Passenger passengerSaved = passengerRepository.save(passenger);			
			UserBooking booking=new UserBooking();
			Optional<Airline> airline = airlinesRepository.findById(airlineId);			
			booking.setAirline(airline.get());
			Optional<User> user = userRepository.findById(userId);
			booking.setUser(user.get());
			booking.setPassenger(passengerSaved);
			reservationRepository.save(booking);
		}
		
//		passengers.stream().forEach(passenger->{
//			
//			Passenger passengerSaved = passengerRepository.save(passenger);			
//			UserBooking booking=new UserBooking();
//			Optional<Airline> airline = airlinesRepository.findById(airlineId);			
//			booking.setAirline(airline.get());
//			Optional<User> user = userRepository.findById(userId);
//			booking.setUser(user.get());
//			booking.setPassenger(passengerSaved);
//			reservationRepository.save(booking);
//		});
		
		return null;
	}

}
