package net.iqss

class Customer {

	String firstName
	String lastName
	
	static hasMany = CreditCardTransaction
	
    static constraints = {
		firstName(nullable: false, blank: false, maxSize: 50)
		lastName(nullable: false, blank: false, maxSize: 50)
    }
	
	String toString() {
		return "${firstName} ${lastName}"
	}
}
