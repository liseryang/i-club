<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Club</title>
<jsp:include page="css_include.jsp"></jsp:include>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div id="content">
<form:form modelAttribute="club" action="edit-club.do" method="POST">

<table width="67%" border="0" align="left">
<tr><td colspan="2"><font color='red'>${errorMsg}</font></td></tr>
  <tr>
    <td width="30%">Club Short Name</td>
    <td width="286"><label for="textfield"></label>
     <form:hidden path="clubId" />
     <form:input path="clubShortName" size="45%" /><form:errors path="clubShortName"/></td>
  </tr>
  <tr>
    <td width="30%">Club Fees</td>
    <td width="286"><label for="textfield"></label>
     <form:input path="clubFees" size="45%" /><form:errors path="clubFees"/></td>
  </tr>
  <tr>
    <td width="30%">Club Long Name</td>
    <td width="286"><label for="textfield"></label>
     <form:input path="clubLongName" size="45%" /><form:errors path="clubLongName"/></td>
  </tr>
  <tr>
    <td width="30%">Club Description</td>
    <td width="286"><label for="textfield"></label>
     <form:textarea path="clubDescription" size="45%" cols="90%" rows="5" /><form:errors path="clubDescription"/></td>
  </tr>
  <tr>
    <td width="30%">Club Other Details</td>
    <td width="286"><label for="textfield"></label>
     <form:textarea path="clubOtherDetails" size="45%" cols="90%" rows="5" /><form:errors path="clubOtherDetails"/></td>
  </tr>        
  <tr>
    <td>&nbsp;</td>
    <td align="right"><input type="submit" name="button" id="button" value=" Save " />
      <input type="submit" value="Delete" onclick="this.form.action='delete-club.do';this.form.method='POST';this.form.submit();"/>
      <input type="submit" name="button2" id="button2" value="Cancel" onclick="this.form.action='member.do';this.form.method='GET';this.form.submit();"/></td>

  </tr>
</table>
</form:form>
</div>
</body>
</html>