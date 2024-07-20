package com.example.demo.outputbinding;



import lombok.Data;

@Data
public class TicketStatus {
	private Long userId;
	private String name;
	private String mobile;
	private String email;
	private String preferdSeat;
	private Double payPrice;
	private String confirmation;
	private String bookingStatus;
}
