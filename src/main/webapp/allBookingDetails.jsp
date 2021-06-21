<%@page import="in.mani.dto.UserDTO"%>
<%@page import="in.mani.dto.TicketDTO"%>
<%@page import="in.mani.service.TicketService"%>
<%@page import="in.mani.dto.TrainDTO"%>
<%@page import="in.mani.dao.TrainDAO"%>
<%@page import="in.mani.model.Train"%>
<%@page import="java.util.List"%>
<%@page import="in.mani.service.TrainDetailSevices"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>All Bookings</title>
</head>
<body onload="filterDetails()">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">USER'S BOOKING DETAILS</h4>
				<p class="text-center"><jsp:include page="message.jsp"></jsp:include></p>
				<form>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 130px;">JOURNEY
								DATE</span>
						</div>
						<input type="date" style="width: 150px;" id="date" name="date"
							onchange="filterDetails()">
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 130px;">TRAIN
								NAME</span>
						</div>
						<input type="text" style="width: 150px;" id="train" name="train"
							oninput="filterDetails()" placeholder="Train Name">
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width: 130px;">STATUS</span>
						</div>
						<select id="status" style="width: 150px;" id="status"
							name="status" onchange="filterDetails()">
							<option value="" selected>All</option>
							<option value="BOOKED">BOOKED</option>
							<option value="CANCELLED">CANCELLED</option>
							<!-- <option value="FINISHED">FINISHED</option> -->
						</select>
					</div>
					<div class="form-group">
						<button type="reset" class="btn btn-primary btn-block"
							onclick="clearFilters()">Clear Filters</button>
					</div>
				</form>
			</article>
		</div>
		<table class="table table-bordered">
			<caption>My Booking Details</caption>
			<thead>
				<tr>
					<th id="S.no">SI.NO</th>
					<th id="user">USERNAME</th>
					<th id="trainName">TRAIN</th>
					<th id="pnrNumber">PNR NUMBER</th>
					<th id="bookedDate">BOOKED DATE</th>
					<th id="journeyDate">JOURNEY DATE</th>
					<th id="journeyTime">JOURNEY TIME</th>
					<th id="tickets">TOTAL TICKETS</th>
					<th id="passengers">PASSENGERS</th>
					<th id="price">TOTAL FARE</th>
					<th id="status">STATUS</th>
				</tr>
			</thead>
			<tbody id="bookings">
			</tbody>
		</table>
	</main>
</body>
<script type="text/javascript">
		function filterDetails(){
			event.preventDefault();
			let filterDate = document.querySelector("#date").value;
			console.log(filterDate);
			let trainname = document.querySelector("#train").value;
			console.log(trainname)
			let status = document.querySelector("#status").value;
			console.log(status)
			let url = "AllBookingDetailsServlet";
			fetch(url).then(res=>res.json()).then(res=>{
			let data = [];
			data = res;
			if(trainname!=""){
				data=filterTrains(data,trainname);
			}
			if(status!=""){
				data=filterStatus(data,status);
			}
		 	if(filterDate!=""){
				data= dateFilter(data,filterDate);
		} 
			displayDetails(data);
			});
			}
		  function filterTrains(res,trainname){	
			 data = res.filter(res =>  res.train.trainName.toLowerCase().includes(trainname.toLowerCase()));
			 return data;		 
			 } 
			 function filterStatus(res,status){
				 data = res.filter(res =>  res.status.toLowerCase().includes(status.toLowerCase()));
				 return data;
			 }
			 function dateFilter(res,filterDate){
			 data = res.filter(res => JSON.stringify(res.journeyDate).includes(filterDate));
			 return data;
			 }
		function displayDetails(data){				
			let content="";		
			let j=0;
			 for(i = 0; i < data.length; i++){
				 if(data.length != 0){
				content+="<tr><td>"+ ++j + "</td><td>" + data[i].user.userName + "</td><td>" + data[i].train.trainName +"(" + data[i].train.trainNumber + ")</td>";
				content+="<td>" + data[i].pnrNumber + "</td><td>" + data[i].bookingDate + "</td>";
				console.log(data[i].journeyDate)
				let journeyDate = data[i].journeyDate;
				let arr = journeyDate.split('-') ;
				filterDate = arr[2] + "-" + arr[1] + "-" + arr[0];
				console.log(filterDate)
				content+="<td>" + filterDate + "</td><td>" + data[i].journeyTime + "</td>";
				content+="<td>" + data[i].noOfTickets + "</td><td>" + data[i].passengers + "</td>";
				content+="<td>" + data[i].totalPrice + "</td>";
				content+="<td>" + data[i].status + "</td></tr>";
			}else{
				content+="<tr><td>" + "No Records Found" + "</td></tr>"; 
			}
			}
			document.querySelector("#bookings").innerHTML= content;
			}	
		
		function clearFilters(){
			 event.preventDefault();
			 	 document.querySelector("#date").value = "";
				document.querySelector("#train").value = "";
				 document.querySelector("#status").value ="";					
				filterDetails();
		 }
</script>
</html>