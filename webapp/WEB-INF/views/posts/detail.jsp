<%@ include file="../includes/header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-sm-12 col-md-12">
			<div class="panel panel-default">
				<div class="panel-body">
			
					<h3>${post.title}</h3>
					<hr/>
					
					<p>${post.summary}</p>
					
					<p>${post.content}</p>
					
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>