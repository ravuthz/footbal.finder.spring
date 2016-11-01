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
								<c:if test="${not empty category.id}">
									<input type="text" name="id" value="${category.id}">								
								</c:if>
		
		                        <div class="form-group">
		                            <label for="title">Title: </label>
		                            <input type="text" class="form-control" name="title" value="${category.title}">
		                        </div>
		
		                        <div class="form-group">
		                            <label for="content">Content: </label>
		                            <textarea class="form-control" name="content">${category.content}</textarea>
		                        </div>

		                		<div class="form-group">
		                            <button type="reset" class="btn btn-primary" name="rest">Reset</button>
		                            <button type="submit" class="btn btn-success" name="submit">Save</button>
		                            <a href="${basePath}/categories/" class="btn btn-default">Back</a>
		                        </div>
		
		                    </form>
		                </div>
	                </div>
	            </div>
	        </div>
        </div>
    </div>
</div>