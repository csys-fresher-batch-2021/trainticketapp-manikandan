<!-- CSS -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<%
String loggedInAdminId = (String) session.getAttribute("LOGGED_IN_ADMIN");
String loggedInUser = (String) session.getAttribute("LOGGED_IN_USER");
String role = (String) session.getAttribute("ROLE");
%>

<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">TRAIN TICKET APP</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<%
				if (loggedInAdminId == null || loggedInUser != null) {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">HOME<span class="sr-only">(current)</span></a></li>
					<%
				}
				%>
				<li class="nav-item active"><a class="nav-link" href="searchTrain.jsp">SEARCH TRAIN</a>
				</li>
				<%
				if (loggedInUser != null) {
				%>
				<li class="nav-item active"><a class="nav-link" href="UserBookingDetailsServlet">MY BOOKINGS</a></li>
				<%
				}
				%>
				<%
				if (loggedInAdminId != null && role != null && role.equalsIgnoreCase("ADMIN")) {
				%>
				<li class="nav-item active"><a class="nav-link" href="addTrains.jsp">ADD TRAIN</a></li>
				<li class="nav-item active"><a class="nav-link" href="allBookingDetails.jsp">USER BOOKINGS</a>
				</li>
				<%
				}
				%>
			</ul>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<%
				if (loggedInAdminId == null && loggedInUser == null) {
				%>
				<li class="nav-item dropdown active"><a
					class="nav-link dropdown-toggle" href="#" id="dropdownId"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">LOGIN</a>
					<div class="dropdown-menu" aria-labelledby="dropdownId">
						<a class="dropdown-item" href="adminLogin.jsp">ADMIN LOGIN</a> <a
							class="dropdown-item" href="userLogin.jsp">USER LOGIN</a>
					</div></li>
				<li class="nav-item active"><a class="nav-link" href="registerUser.jsp">REGISTER</a>
				</li>
				<%
				} else {
					if(loggedInAdminId != null){
				%>
				<li class="nav-item active"><a class="nav-link" href="#">Welcome <%=loggedInAdminId%></a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="AdminLogoutServlet">LOGOUT</a></li>
				<%}
				if(loggedInUser != null){%>
				<li class="nav-item active"><a class="nav-link" href="#">Welcome <%=loggedInUser%></a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="UserLogoutServlet">LOGOUT</a></li>
				<%
				}
				}
				%>
			</ul>
		</div>
	</nav>
</header>