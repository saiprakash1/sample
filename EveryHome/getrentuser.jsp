<%@page import="java.text.SimpleDateFormat"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="java.util.*,java.sql.*,java.io.*" %>
 <%@page import="javax.servlet.*" %> 
 <%@page import="javax.servlet.http.*" %> 
 <html> <head> 
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
 <title>Welcome to Computer Educational Institution </title>
 </head>

 <body>
 <%!Connection con; %> 
 <%!Statement s; %> 
 <%!ResultSet rs; %>
 <% String firstname=request.getParameter("q");
 try{
 Class.forName("oracle.jdbc.driver.OracleDriver");
 con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","sai","password"); 
 s=con.createStatement();
 System.out.println("Connection established successfully select * from employee where firstname='"+firstname+"'");
 rs=s.executeQuery("select * from employee where firstname='"+firstname+"'"); 
 }
 catch(Exception e)
 { e.printStackTrace(); } %>
 <div id="dtl_table">
 <table border='3' cellpadding='5' cellspacing='2' width="400px"> 
 <tr bgcolor="66FF00"> 
 <th>Id</th>
 <th>FirstName</th>
 <th>LastName</th> 
 </tr>
 <tr> <% while(rs.next()) { %> 
 <% System.out.println("This is debug from while loop");%>
 <td><%=rs.getInt(1)%></td> 
 <td><%=rs.getString(2)%></td> 
 <td><%=rs.getString(3)%></td> 
 <% } %> 
 </tr> 
 </table></div> 
 </body> 
 </html> 
