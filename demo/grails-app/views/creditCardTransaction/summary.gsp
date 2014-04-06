<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<g:set var="entityName" value="${message(code: 'creditCardTransaction.label', default: 'CreditCardTransaction')}" />
		<title><g:message code="transaction.summary.label" /></title>
	</head>
	<body>
		<a href="#list-creditCardTransaction" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-creditCardTransaction" class="content scaffold-list" role="main">
			<g:each in="${transactionsList}" var="transactions">
				
			<g:set var="transactionType" value="${message(code: transactions.key)}" />
			<h1><g:message code="transactions.list.name" args="[transactionType]" /></h1>
			<table>
				<thead>
					<tr>
						<th><g:message code="creditCardTransaction.customer.name.label" default="Customer Name" /></th>
						<th><g:message code="creditCardTransaction.amount.label" default="Amount" /></th>
						<th><g:message code="creditCardTransaction.dateCreated.label" default="Date" /></th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${transactions.value}" status="i" var="transaction">
						<g:if test="${transactions.key=='Failed' }">
							<tr style="background-color:#FF0000">
						</g:if>
						<g:elseif test="${transactions.key=='Refunded' }">
							<tr style="background-color:#FF5400">
						</g:elseif>
						<g:else>
							<tr>
						</g:else>
							<td>${transaction.customer}</td>
							<td>${transaction.amount}</td>
							<td>${transaction.dateCreated}</td>
					</g:each>
				</tbody>
			</table>
			</g:each>
	</body>
</html>