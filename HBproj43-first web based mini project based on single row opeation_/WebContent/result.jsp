<%@page isELIgnored="false"%>

<h1 style="color: red;" align="center">result page</h1>

<%
	if (request.getAttribute("ptdo") != null) {
%>

<table border="1" align="center">
	<tr>
		<th>product id</th>
		<th>name</th>
		<th>price</th>
		<th>quntity</th>
		<th>catagory</th>
	</tr>
	<tr>
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
%>

<br>
<br>
<a href="index.html">home page</a>




