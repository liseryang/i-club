<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Member Listing</title>
<link rel="stylesheet"  type="text/css" href="<%=request.getContextPath()%>/css/displaytag.css"/>
<jsp:include page="css_include.jsp"></jsp:include>
</head>
<body>
<div id="content">
<jsp:include page="menu.jsp"></jsp:include>
<div id="add"> <a href="add-member.do">Add Member</a></div>
     	 <display:table name="memberList" requestURI="/report.do?reqCode=goReport&searchType=1" 
      				id="member" uid="member"  excludedParams="*"    
      				class="displaytag" cellpadding="0" style="width:800px" pagesize="20">
           		<display:column title="Name"><a href="edit-member.do?id=${member.memberId}">${member.person.name}</a></display:column>
           		<display:column property="person.email" title="Email"/>
           </display:table>
</div>
</body>
</html>