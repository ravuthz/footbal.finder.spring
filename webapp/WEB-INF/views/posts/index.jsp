<%@ include file="../includes/header.jsp" %>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>List Posts</h1>
			</div>
			
			<div class="col-sm-10 col-md-6 text-left">
				<form role="search" action="${basePath}/posts/search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Enter keywork here to find your posts" name="key" value="<%= request.getParameter("key") %>">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
						</div>
					</div>
				</form>
			</div>
			
			<div class="col-sm-2 col-md-6 text-right">
				<a href="${basePath}/posts/new" class="btn btn-primary">New Post</a>
			</div>
		</div>
		<hr/>
		<table class="table table-bordered">
			<tr>
				<th class="text-center" width="5%">Id</th>
				<th class="text-center" width="40%">Title</th>
				<th class="text-center hidden-sm">Summary</th>
				<th class="text-center" width="18%">Action</th>
			</tr>
			<c:forEach items="${posts}" var="post">
				<tr>
					<td>${post.id}</td>
					<td>${post.title}</td>
					<td class="hidden-sm">${post.summary}</td>
					<td class="text-center">
						<form action="${basePath}/posts/delete/${post.id}" method="POST">
							<a href="${basePath}/posts/edit/${post.id}" class="btn btn-sm btn-primary">Update</a>
							&nbsp;
							<button type="submit" class="btn btn-sm btn-danger" name="submit">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	
<%@ include file="../includes/footer.jsp" %>