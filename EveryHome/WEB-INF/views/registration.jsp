<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Tenant Registration Form</title>
	  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
 
<style>
 
    .error {
        color: #ff0000;
    }
	
	table{border-collapse:collapse; }
#div1 { width: 300px; height: 410px}

#div2 { text-align:center}
#div3 {position:relative;}
#div4 { background: #444; }
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script src="http://code.angularjs.org/1.2.1/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>

function showuser(str) { 
var xreq; 
if(str=="") 
{ 
document.getElementById("showtext").innerHTML=""; 
return; } 
if(window.XMLHttpRequest) {
document.getElementById("debugtext").innerHTML="Entered xmlhttp request"+str;
 xreq=new XMLHttpRequest(); }
 else { 
 xreq=new ActiveXObject("Microsoft.XMLHTTP");
 }
 xreq.onreadystatechange=function () {
 document.getElementById("debuginfo").innerHTML="Entered onreadystatechange";
 if((xreq.readyState==4) && (xreq.status==200)) { 
 document.getElementById("showtext").innerHTML =xreq.responseText; 
 } 
 }
 xreq.open("get","getrentuser.jsp?q="+str,"true"); 
 xreq.send(); 
 }
 $(
function(){
var available=["sai","prakash","reddy","sahi","sayi","sayyyi"]
$('#name').autocomplete({source:available}); 
} );

var app=angular.module("calciapp",[]);
app.controller("CalculatorCtrl",CalculatorCtrl);

function CalculatorCtrl(){
this.buttonclicked= function(button){
this.selectedoperation=button;
document.getElementById("debugtext").innerHTML="called calculator ctrl";
}
this.computeresult=function(){
var resultvalue=0;
var number1=parseFloat(this.input1);
document.getElementById("debugtext").innerHTML="called compute result";
var number2=parseFloat(this.input2);
if(this.selectedoperation=='+'){
this.resultvalue=number1+number2;
document.getElementById("debugtext").innerHTML="plus called"+resultvalue;
}
else if(this.selectedoperation==='-'){
this.resultvalue=number1-number2;
}
else if(this.selectedoperation==='*'){
this.resultvalue=number1*number2;
}
else if(this.selectedoperation==='/'){
this.resultvalue=number1/number2;
}
}
}


</script>

 
</head>
 
<body>
 
    <h2>Registration Form</h2>
  <div class="container">
  <div class="row">
  <div class="col-sm-6">
    <form:form method="POST" modelAttribute="renter">
     <!--   <form:input type="hidden" path="id" id="id"/> -->
        <table  >
		
		<tr>
                <td><label for="id">Id: </label> </td>
                <td><form:input path="id" id="id"/></td>
                <td><form:errors path="id" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="name">Name: </label> </td>
                <td><form:input path="name" id="name" /></td>
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
						<div id="div2">
                            <input type="submit" value="Register"/>
							</div>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
	
    <br/>
    <br/>
	</div>
	<div class="col-sm-6">
    Go back to <a href="<c:url value='/list' />">List of Renters</a>
	<form> 
	<select name="user" onchange="showuser(this.value)" >
	<option value="">Select Course name....</option> 
	<option value="sai"> sai </option>
	<option value="cpp">C++ </option> 
	<option value="adam">Android with Advanced Java</option> 
	<option value="net">Networking</option>
	</select> 
	</form>
	<br /> 
	<div id="showtext">The Course response will come here</div>
	<div id="debugtext">debug message comes here</div>
	<div id="debuginfo">debug info comes here</div>
<div id="div3" ng-app="calciapp" ng-controller="CalculatorCtrl as ctrl" >
<h1>Handy Calci</h1>
<input type="text" ng-model="ctrl.input1"></input>
<span ng-bind="ctrl.selectedoperation"></span>
<input type="text" ng-model="ctrl.input2"></input>
<button ng-click="ctrl.computeresult()">=</button>
<span ng-bind="ctrl.resultvalue"> </span>

<p>
Choose Operation:
<button ng-click="ctrl.buttonclicked('+')">+</button>
<button ng-click="ctrl.buttonclicked('-')">-</button>
<button ng-click="ctrl.buttonclicked('*')">*</button>
<button ng-click="ctrl.buttonclicked('/')">/</button>

</p>
</div>
</div>
</div>
</div>
</body>
</html>