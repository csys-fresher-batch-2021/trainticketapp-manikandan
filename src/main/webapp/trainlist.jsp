<%@page import="java.util.Map"%>
<%@page import="in.mani.service.TrainDetailSevices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Train List</title>
<style type="text/css">
table, td, th {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1>List of Trains</h1>
		<%
		Map<Integer, String> trainList = TrainDetailSevices.getAllTrainList();
		Map<String, Integer> trainClass = TrainDetailSevices.getAllTrainClass();
		%>
		<h3>
			<%
			out.println("Available Trains : " + trainList.size());
			%>
		</h3>
		<table class="table table-bordered">
			<caption>Train List</caption>
			<thead>
				<tr>
					<th id="siNo">SI.No</th>
					<th id="trainNo">Train No</th>
					<th id="trainName">Train Name</th>
					<th id="class">Class</th>
					<th id="fare">Fare(Rs./-)</th>
				</tr>
			</thead>
			<tbody>
				<%
				int i = 0;
				for (int trainNumber : trainList.keySet()) {
					i++;
				%>
				<tr>
					<td rowspan=4><%=i%></td>
					<td rowspan=4><%=trainNumber%></td>
					<td rowspan=4><%=trainList.get(trainNumber)%></td>
				</tr>

				<%
				for (String trainClassType : trainClass.keySet()) {
				%>
				<tr>
					<td><%=trainClassType%></td>
					<td><%=trainClass.get(trainClassType)%></td>
					<%
					}
					%>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>