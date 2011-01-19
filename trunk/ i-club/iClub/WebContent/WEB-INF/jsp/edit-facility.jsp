<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Facility</title>
<jsp:include page="css_include.jsp"></jsp:include>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div id="content">
<form:form modelAttribute="facility" action="edit-facility.do" method="POST">
<table width="67%" border="0" align="left">
  <tr>
    <td width="30%">Facility Code</td>
    <td width="286"><label for="textfield"></label>
    <form:hidden path="facilityId"/>
     <form:input path="facilityCode" size="45%" /><form:errors path="facilityCode"/></td>
  </tr>
  <tr>
    <td width="30%">Description</td>
    <td width="286"><label for="textfield"></label>
     <form:input path="facilityDescription" size="45%" /><form:errors path="facilityDescription"/></td>
  </tr>        
  <tr>
    <td>&nbsp;</td>
    <td align="right"><input type="submit" name="button" id="button" value=" Save " />
      <input type="submit" value="Delete" onclick="this.form.action='delete-facility.do';this.form.method='POST';this.form.submit();"/>
      <input type="submit" name="button2" id="button2" value="Cancel" onclick="this.form.action='list-facility.do';this.form.method='GET';this.form.submit();"/></td>

  </tr>
</table>
</form:form>
</div>
</body>
</html>