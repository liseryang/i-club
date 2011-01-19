<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Member</title>
<jsp:include page="css_include.jsp"></jsp:include>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div id="content">
<form:form modelAttribute="person" action="add-member.do" method="POST">
<table width="67%" border="0" align="left">
  <tr>
    <td width="30%">Name</td>
    <td width="286"><label for="textfield"></label>
     <form:input path="person.name" size="45%" /><form:errors path="person.name"/></td>
  </tr>
  <tr>
    <td>Address</td>
    <td><label for="textarea"></label>
      <form:textarea path="person.address" cols="90%" rows="5"/><form:errors path="person.address"/></td>
  </tr>
  <tr>
    <td>Phone Number</td>
    <td><form:input path="person.phone" size="45%" /><form:errors path="person.phone"/></td>
  </tr>
  <tr>
    <td>Email Address</td>
    <td><form:input path="person.email" size="45%" /><form:errors path="person.email"/></td>
  </tr>
  <tr>
    <td>Member Status</td>
    <td><form:select itemValue="memberStatusId" itemLabel="description" path="member.memberStatus.memberStatusId" items="${memberStatusList}" /></td>
  </tr>
  <tr>
    <td>Member Type</td>
    <td><form:select itemValue="memberTypeId" itemLabel="description" path="member.memberType.memberTypeId" items="${memberTypeList}" /></td>
  </tr>
  <tr>
    <td>Club</td>
    <td><form:select itemValue="clubId" itemLabel="clubLongName" path="member.club.clubId" items="${clubList}" /></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="right"><input type="submit" name="button" id="button" value=" Save " />
      <input type="submit" name="button2" id="button2" value="Cancel" onclick="this.form.action='member.do';this.form.method='GET';this.form.submit();"/></td>
  </tr>
</table>
</form:form>
</div>
</body>
</html>