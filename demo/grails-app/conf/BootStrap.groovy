import grails.util.Environment;
import grails.util.GrailsUtil
import net.iqss.CreditCardTransaction
import net.iqss.Customer

class BootStrap {

    def init = { servletContext ->
		if (Environment.current in [Environment.DEVELOPMENT, Environment.TEST]) {
			println "Creating Bootstrap Values..."
			def customerNames = [["John", "Flow"], ["Raj","Jamnis"], ["Andrew", " Chung"], ["Mike", "Smith"]]
			println "Creating Customers..."
			List<Customer> customers = createCustomers(customerNames)
			println "...Created Customers"
			println "Creating Successful Transactions..."
			createTransactions("Success", [[customers[0],5], [customers[1],3], [customers[2],1], [customers[3],1]])
			println "...Created Successful Transactions"
			println "Creating Failed Transactions..."
			createTransactions("Failed", [[customers[2],3], [customers[3],2]])
			println "...Created Failed Transactions"
			println "Creating Refunded Transactions..."
			createTransactions("Refunded", [[customers[0],4], [customers[1],2]])
			println "...Created Refunded Transactions"
		}
    }
	
    def destroy = {
    }
	
	private List<Customer> createCustomers(List customerNames) {
		List<Customer> customerList = new ArrayList<Customer>()
		customerNames.each { customerName ->
			customerList << new Customer(firstName: customerName[0], lastName: customerName[1]).save(failOnError: true, flush: true)
		}
		return customerList
	}
	
	private void createTransactions(String transactionType, List transactionDetails) {
		def amount = 2000
		
		transactionDetails.each {transactionDetail->
			(1..transactionDetail[1]).each {
				switch (transactionType) {
					case 'Success':
						createTransaction(transactionDetail[0], amount, true, false)
						break
					case 'Failed':
						createTransaction(transactionDetail[0], amount, false, false)
						break
					case 'Refunded':
						createTransaction(transactionDetail[0], amount, true, true)
						break
				}
				amount += 500
			}
		}
	}
	
	private void createTransaction(Customer customer, long amount, boolean paid, boolean refunded) {
		new CreditCardTransaction(dateCreated:Calendar.getInstance().getTime(),
			paid: paid, amount: amount, currency: "gbp", refunded: refunded,
			customer: customer).save(failOnError: true, flush: true)
	}
	
}
