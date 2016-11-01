<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
        	<div class="panel panel-default">
	            <div class="panel-body">
	                <div class="row">
	                	<div class="col-sm-12 col-md-offset-4 col-md-8">
	                		
	                		<h3>${formTitle}</h3>
	                		<hr/>
	                	
		                    <form action="${basePath}/${formAction}" method="POST" class="form">
								<c:if test="${not empty post.id}">
									<input type="hidden" name="id" value="${post.id}">								
								</c:if>
								
								<div class="form-group">
		                            <label for="category_id">Category: </label>
		                            <select name="category_id" class="form-control">
		                            	<c:forEach items="${categories}" var="cate">
			                            	<c:set var="selected" value=""></c:set>
		                            		<c:if test="${post.category.id == cate.id}">
		                            			<c:set var="selected" value="selected"></c:set>
		                            		</c:if>
		                            		<option ${selected} value="${cate.id}">${cate.title}</option>
		                            	</c:forEach>
		                            </select>	                            
		                        </div>
		                    	
		                        <div class="form-group">
		                            <label for="title">Title: </label>
		                            <input type="text" class="form-control" name="title" value="${post.title}">
		                        </div>
		                        
		                         <div class="form-group">
		                            <label for="content">Summary: </label>
		                            <textarea class="form-control" name="summary">${post.summary}</textarea>
		                        </div>
		
		                        <div class="form-group">
		                            <label for="content">Content: </label>
		                            <textarea class="form-control" name="content">${post.content}</textarea>
		                        </div>

		                		<div class="form-group">
		                            <button type="reset" class="btn btn-primary" name="rest">Reset</button>
		                            <button type="submit" class="btn btn-success" name="submit">Save</button>
		                            <a href="${basePath}/posts/" class="btn btn-default">Back</a>
		                        </div>
		
		                    </form>
		                </div>
	                </div>
	            </div>
	        </div>
        </div>
    </div>
</div>