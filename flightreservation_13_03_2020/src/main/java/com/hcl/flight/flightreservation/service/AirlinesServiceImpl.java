package com.hcl.flight.flightreservation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flight.flightreservation.dao.AirlinesRepository;
import com.hcl.flight.flightreservation.dao.PassengerRepository;
import com.hcl.flight.flightreservation.dao.ReservationRepository;
import com.hcl.flight.flightreservation.dao.UserRepository;
import com.hcl.flight.flightreservation.dto.BookingHistory;
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
	public List<Airline> findAirlines(String source, String destination, Date dateReceived) {
		return airlinesRepository.findBySourceAndDestinationIgnoreCaseAndJourneyTime(source, destination,dateReceived);
	}



	@Override
	public String createReservation(Long userId, Long airlineId, ReservationRequest reservationRequest) throws RuntimeException {
		
		List<PassengerDTO> list = reservationRequest.getList();
		List<Passenger> passengers=new ArrayList<>();
		UserBooking userBooking=null;
		
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
		
		UserBooking booking=new UserBooking();
		Optional<Airline> airline = airlinesRepository.findById(airlineId);			
		booking.setAirline(airline.get());
		Optional<User> user = userRepository.findById(userId);
		booking.setUser(user.get());
	    userBooking = reservationRepository.save(booking);
	    Passenger passengerSaved=null;
		for(Passenger passenger:passengers) {
			
		    passenger.setUserBooking(userBooking);
		    passengerSaved = passengerRepository.save(passenger);
		}
		if(passengerSaved!=null) {
			return "reservation success";
		} else {
			throw new RuntimeException("Error while making booking");
		}


	}



	@Override
	public List<BookingHistory> findAllBookingHistory(Long usedId, Date fromDate, Date toDate) {
		
		Optional<User> user = userRepository.findById(usedId);
		
		List<BookingHistory> bookingHistories=new ArrayList<>();
		 if(user.isPresent()) {
			User user2 = user.get();
			List<UserBooking> userBookings = user2.getUserBookings();
			userBookings.forEach(booking ->{
				Airline airline = booking.getAirline();
				String airlineNumber = airline.getAirlineNumber();
				List<Passenger> passengers = booking.getPassengers();
				BookingHistory bookingHistory=new BookingHistory();
				
			});
			
			
			 // personByCity =  people.stream()
              //.collect(Collectors.groupingBy(Person::getCity));
			
		}
		
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String removeAirlineById(Long airlineId) {
		airlinesRepository.deleteById(airlineId);
		return airlineId+"deleted";
	}

}
