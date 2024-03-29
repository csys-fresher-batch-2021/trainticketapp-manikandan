<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Train Ticket App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<link href="/your-path-to-fontawesome/css/fontawesome.css"
	rel="stylesheet">
<link href="/your-path-to-fontawesome/css/brands.css" rel="stylesheet">
<link href="/your-path-to-fontawesome/css/solid.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body id="setmin">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 300px;">
				<h4 class="card-title mt-3 text-center">BOOK TRAIN TICKET</h4>
				<p class="text-center"><jsp:include page="message.jsp"></jsp:include></p>
				<form action=SearchTrainToBookServlet method="GET">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><em class="fas fa-map-marked-alt" style="font-size:24px"></em>
							</span>
						</div>
						<input name="source" class="form-control" placeholder="From"
							autocomplete="off" type="text" required>
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><em class="fas fa-map-marked-alt" style="font-size:24px"></em>
							</span>
						</div>
						<input name="destination" class="form-control" placeholder="To"
							autocomplete="off" type="text" required>
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width:53px;"><em class="far fa-calendar-alt" style="font-size:24px"></em></span>
						</div>
						<input name="journeyDate" id="journeyDate" class="form-control"
							placeholder="Journey Date" autocomplete="off" type="date"
							required>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Search Trains</button>
					</div>
				</form>
			</article>
		</div>
	</main>
</body>
<script>
	document.getElementById("setmin").addEventListener("load", setMinMax());
	function setMinMax() {
		let todayStr = new Date().toJSON().substr(0, 10);
		document.querySelector("#journeyDate").setAttribute("min", todayStr);
		let endDate = new Date();
		endDate.setDate(endDate.getDate() + 28);
		let endDateStr = endDate.toJSON().substr(0, 10);
		document.querySelector("#journeyDate").setAttribute("max", endDateStr);
	}
</script>
</html>
