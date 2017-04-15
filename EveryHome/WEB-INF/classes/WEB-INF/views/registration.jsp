<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Registration Form</h2>
  
    <form:form method="POST" modelAttribute="renter">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="name">Name: </label> </td>
                <td><form:input path="name" id="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="joiningDate">Joining Date: </label> </td>
                <td><form:input path="joiningDate" id="joiningDate"/></td>
                <td><form:errors path="joiningDate" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="advance">Advance: </label> </td>
                <td><form:input path="advance" id="advance"/></td>
                <td><form:errors path="advance" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="aan">aan: </label> </td>
                <td><form:input path="aan" id="aan"/></td>
                <td><form:errors path="aan" cssClass="error"/></td>
            </tr>
     
     
     
     
      
            
     
            <tr>
                <td><label for="portionhired">Portionhired </label> </td>
                <td><form:input path="portionhired" id="portionhired"/></td>
                <td><form:errors path="portionhired" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="leavingDate">leavingDate: </label> </td>
                <td><form:input path="leavingDate" id="leavingdate"/></td>
                <td><form:errors path="leavingDate" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="occupation">Occupation: </label> </td>
                <td><form:input path="occupation" id="occupation"/></td>
                <td><form:errors path="occupation" cssClass="error"/></td>
            </tr>
            
           
       
            <tr>
                <td><label for="phone_number">Phonenumber: </label> </td>
                <td><form:input path="phone_number" id="phonenumber"/></td>
                <td><form:errors path="phone_number" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="crowd">Crowd: </label> </td>
                <td><form:input path="crowd" id="crowd"/></td>
                <td><form:errors path="crowd" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="vehicle_number">vehiclenumber: </label> </td>
                <td><form:input path="vehicle_number" id="vehiclenumber"/></td>
                <td><form:errors path="vehicle_number" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="vehicles">vehicles: </label> </td>
                <td><form:input path="vehicles" id="vehicles"/></td>
                <td><form:errors path="vehicles" cssClass="error"/></td>
            </tr>
     
     
            <tr>
                <td><label for="home_village">homevillage: </label> </td>
                <td><form:input path="home_village" id="homevillage"/></td>
                <td><form:errors path="home_village" cssClass="error"/></td>
            </tr>
     
     
       <tr>
                <td><label for="pay_online">payonline: </label> </td>
                <td><form:input path="pay_online" id="payonline"/></td>
                <td><form:errors path="pay_online" cssClass="error"/></td>
            </tr>
     
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/list' />">List of All Employees</a>
</body>
</html>