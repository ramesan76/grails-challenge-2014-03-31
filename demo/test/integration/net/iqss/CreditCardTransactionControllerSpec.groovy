package net.iqss

import org.junit.*
import grails.test.mixin.*
import grails.plugin.spock.IntegrationSpec

class CreditCardTransactionControllerSpec extends IntegrationSpec {

	def creditCardTransactionController
	
	void setup(){
		creditCardTransactionController = new CreditCardTransactionController()
	}
	
	def "Verifying lists count on the screen"() {
		when:
		println "Verifying lists count on the screen"
        def model = creditCardTransactionController.summary()

        then:
        assert creditCardTransactionController.response.status == 200
		assert model.transactionsList != null
        assert model.transactionsList.size() == 3
	}
	
	def "Verifying transactions count on the screen"() {
		when:
		println "Verifying transactions count on the screen"
        def model = creditCardTransactionController.summary()

        then:
        assert creditCardTransactionController.response.status == 200
		assert model.transactionsList != null
        assert model.transactionsList.size() == 3
		assert model.transactionsList.Success != null
		assert model.transactionsList.Success.size == 10
		assert model.transactionsList.Failed != null
		assert model.transactionsList.Failed.size == 5
	}
}