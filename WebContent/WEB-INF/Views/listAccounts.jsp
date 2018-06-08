<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accounts List</title>
</head>
<body>
	<div class="container">

		<%@ include file="header.jsp"%>

		<div class="row">
			<div class="col-12">
				<a href="<c:url value='/new' />" class="btn btn-lg btn-primary">Add New Account</a>
			</div>
		</div>
		
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-hover">
					<thead class="bg-success">
						<tr>
							<th><spring:message code="lbl.accountNo" /></th>
							<th><spring:message code="lbl.accountHolderName" /></th>
							<th><spring:message code="lbl.balance" /></th>
							<th>&nbsp;</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="account" items="${accounts}">
							<c:url var="updateLink" value="/edit">
								<c:param name="accountNo" value="${account.accountNo}" />
							</c:url>

							<c:url var="deleteLink" value="/delete">
								<c:param name="accountNo" value="${account.accountNo}" />
							</c:url>
							<tr>
								<td>${account.accountNo}</td>
								<td>${account.accountHolderName}</td>
								<td>${account.balance}</td>
								<td><a href="${updateLink}" class="btn btn-warning">Edit</a></td>
								<td><a href="${deleteLink}" class="btn btn-danger"
									onClick="if(!(confirm('Are you sure to delete'))) return false">
										Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<%@ include file="footer.jsp"%>

	</div>
</body>
</html>