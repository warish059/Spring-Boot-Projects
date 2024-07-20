package com.example.demo.controller;

import java.util.Random;

import org.springframework.http.MediaType;
//import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.binding.TrainBooking;
import com.example.demo.outputbinding.TicketStatus;

@RestController
public class TrainController {
	
	@PostMapping(value="/bookticket",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> bookTicket(@RequestBody TrainBooking book){
		TicketStatus status = new TicketStatus();
		Long id = generateRandomId();
		status.setUserId(id);
		status.setEmail(book.getEmail());
		status.setName(book.getName());
		status.setMobile(book.getMobile());
		status.setPreferdSeat(book.getPreferdSeat());
		status.setPayPrice(book.getPayPrice());
		 status.setBookingStatus(book.getBookingStatus());
		 status.setConfirmation(book.getConfirmation());
//		if("yes".equals(book.getConfirmation())) {
		 if ("yes".equals(book.getConfirmation())) {
		        status.setBookingStatus("Ticket Booked Successfully");
		    } else {
		        status.setBookingStatus("Failed to book ticket");
		    }
		
		return ResponseEntity.ok(status);
		
		
	}
	private Long generateRandomId() {
		Random random = new Random();
		Long range = 999999999999L - 100000000000L + 1;
		Long fraction = (long)(range*random.nextDouble());
		return fraction+100000000000L;
	}
}
