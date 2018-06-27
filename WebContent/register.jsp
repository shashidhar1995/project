<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration Form</title>                
<style type="text/css">
h3{font-family: Calibri; font-size: 22pt; font-style: normal; font-weight: bold; color:SlateBlue;
text-align: center; text-decoration: underline }
table{font-family: Calibri; color:white; font-size: 11pt; font-style: normal;width: 50%;
text-align:; background-color: SlateBlue; border-collapse: collapse; border: 2px solid navy}
table.inner{border: 0px}                         
</style>
</head>                                                                                                                           
<body>                    
<h3>Enter your <u>Details</u> to make an Order</h3>          
<form action="RegisterServlet" method="post">
<table align="center" cellpadding = "10">
<tr>
<td>Name</td>                     
<td><input type="text" name="name" maxlength="30" required/>              

</td>            
</tr>

<tr>         
<td>Last Name</td>
<td><input type="text" name="lastName" maxlength="30" required/>
</td>                          
</tr>
<tr>
<td>Phone no</td>
<td><input type="text" name="phone" maxlength="30" required/>
                                            
</td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="email" maxlength="100" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"/></td>
</tr>
                              
<tr>
<td>Password</td>
<td><input type="text" name="password" maxlength="100" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"/></td>
</tr>
<tr><td>
Country</td><td><select name="country"  required style="width: 145px; height: 22px">
              <option value="india">India</option>
			<option value="australia">Australia</option>
			<option value="southafric">South Africa</option>
			<option value="england">England</option>
		  	<option value="newzealand">New Zealand</option>
			<option value="pakisthan">Pakistan</option>
			<option value="argentina">Argentina</option>
			<option value="romania">Romania</option>
			<option value="spain">Spain</option>
              </select></td>
        
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</td>
</tr>
</table>
</form>
</body>
</html>