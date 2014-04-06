package net.iqss

class CreditCardTransactionController {

    def scaffold = true
	
	def summary() {
		def successfulTransactionList = CreditCardTransaction.findAllByPaidAndRefunded(true, false)
		def failedTransactionList = CreditCardTransaction.findAllByPaidAndRefunded(false, false)
		def refundedTransactionList = CreditCardTransaction.findAllByPaidAndRefunded(true, true)
		[transactionsList:["Failed": failedTransactionList,
			"Refunded": refundedTransactionList, "Success":successfulTransactionList]]
	}
}
