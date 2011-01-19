<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Club Facility</title>
<%
    String contextPath = request.getContextPath();
%>
<link rel="stylesheet" href="<%=contextPath %>/css/date_input.css" type="text/css">
<jsp:include page="css_include.jsp"></jsp:include>
</head>
<script language="JavaScript" src="<%=contextPath %>/js/jquery-latest.js"></script>
<script language="JavaScript" src="<%=contextPath %>/js/jquery.date_input.js"></script>
<body>
<script>
$($.date_input.initialize);
</script>
<jsp:include page="menu.jsp"></jsp:include>
<div id="content">
<form:form modelAttribute="clubFacility" action="edit-clubFacility.do" method="POST">
<table width="67%" border="0" align="left">
  <tr>
    <td>Club</td>
    <td>
    <form:hidden path="id"/>
    <form:select itemValue="clubId" itemLabel="clubLongName" path="clubId" items="${clubList}" /></td>
  </tr>
  <tr>
  <tr>
    <td>Facility</td>
    <td><form:select itemValue="facilityId" itemLabel="facilityCode" path="facilityId" items="${facilityList}" /></td>
  </tr>
  <tr>  
    <td width="30%">Date Available</td>
    <td width="286"><label for="textfield"></label>
    <form:input path="dateAvailbleStr" cssClass="date_input"/>
  </tr>
  <tr>  
    <td width="30%">Date Not Available</td>
    <td width="286"><label for="textfield"></label>
    <form:input path="dateNotAvailableStr" cssClass="date_input"/>
  </tr>
  <tr>  
    <td width="30%">Facility Cost</td>
    <td width="286"><label for="textfield"></label>
    <form:input path="facilityCost"/>
  </tr>    
  <tr>
    <td>&nbsp;</td>
    <td align="right"><input type="submit" name="button" id="button" value=" Save " />
      <input type="submit" value="Delete" onclick="this.form.action='delete-clubFacility.do';this.form.method='POST';this.form.submit();"/>
      <input type="submit" name="button2" id="button2" value="Cancel" onclick="this.form.action='list-clubFacility.do';this.form.method='GET';this.form.submit();"/></td>
  </tr>
</table>
</form:form>
</div>
</body>
</html>