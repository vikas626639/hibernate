<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red;" align="center">RESULT PAGE</h1>

<c:choose>
<c:when test="${!empty ptdo || ptdo ne null }">

	<table border="1" align="center">
		<tr align="center">
			<th>PRODUCT ID</th>
			<th>NAME</th>
			<th>PRICE</th>
			<th>QUENTITY</th>
			<th>CATAGORY</th>
		</tr>
		<tr align="center">
			<td>${ptdo.PID}</td>
			<td>${ptdo.PNAME}</td>
			<td>${ptdo.PRICE}</td>
			<td>${ptdo.QTY}</td>
			<td>${ptdo.catagory}</td>
		</tr>
	</table>
</c:when>
<c:otherwise>
	<h1 style="color: red;" align="center">PRODUCT NOT FOUND</h1>
</c:otherwise>
</c:choose>


<br>
<br>
<a href="index.html">home page</a>





<%-- <%
	if (request.getAttribute("ptdo") != null) {
%>

<table border="1" align="center">
	<tr align="center">
		<th>PRODUCT ID</th>
		<th>NAME</th>
		<th>PRICE</th>
		<th>QUENTITY</th>
		<th>CATAGORY</th>
	</tr>
	<tr align="center">
		<td>${ptdo.PID}</td>
		<td>${ptdo.PNAME}</td>
		<td>${ptdo.PRICE}</td>
		<td>${ptdo.QTY}</td>
		<td>${ptdo.catagory}</td>
	</tr>
</table>
<%
	} //if
else {
%>
<h1 style="color: red;" align="center">no product found</h1>
<%
	}
%> --%>