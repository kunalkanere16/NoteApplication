
	
	
	
	
	<!-- Bootstrap Navbar -->
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<a href="#" class="navbar-brand">Notes Management</a>
			<button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse navHeaderCollapse">
				<ul class="nav navbar-nav navbar-right">
					<li class='<c:if test="${active eq 1 }">active</c:if>'><a href="home.page">Home</a></li>
					<li class='<c:if test="${active eq 2 }">active</c:if>'><a href="createNote.page">New Note</a></li>
					<li class='<c:if test="${active eq 3 }">active</c:if>'><a href="viewNoteList.page">View Notes</a></li>
				</ul>
			</div>
		</div>
	</div>
	