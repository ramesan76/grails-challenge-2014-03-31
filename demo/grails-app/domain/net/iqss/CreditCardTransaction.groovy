package net.iqss

import java.util.Date;

class CreditCardTransaction {

	Date dateCreated
	Boolean paid
	Long amount
	String currency
	Boolean refunded
	Customer customer

	static belongsTo = Customer
	
	static constraints = {
		dateCreated(nullable: false)
		paid(nullable: false)
		amount(nullable: false)
		currency(nullable: false, blank: false)
		refunded(nullable: false)
	}
	
}
