<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<form action="${pageContext.request.contextPath }/admin/category/update" method="post">
  <label for="fname">Category name:</label><br>
  <input type="text" id="fname" name="fname" value="John" value="${cate.categoryname}"><br>
  <label for="lname">Images:</label><br>
  <input type="text" id="lname" name="lname" value="Doe"><br><br>
  <label for="fname">Status:</label><br>
  <input type="text" id="fname" name="fname" value="John"value="${cate.categoryname}"><br>
  <input type="submit" value="Submit">
</form> >