<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title> 
             <style>
  article, aside, figure, footer, header, hgroup, 
  menu, nav, section { display: block; }
     
  .box {
     position: absolute;       
     margin-top:20px;
     margin-right:20px;
     img: src="images/globe.jpg";
     top: 0px;
     right:0px;
     width: 50px;         
     height: 50px;                       
    background-color: #e5e5e5; 
     border-radius: 50%;     
     /*  display: inline-block;  */
   border:solid black 2px;
  }     
  .hr { 
	    display: block;
	    margin-top: 0.5em;
	    margin-bottom: 0.5em;
	    margin-left: auto;
	    margin-right: auto;
	    border-style: inset;
	    border-width: 1px;
	}
  
  .inner-box {     
    /* border: solid 10px blue; */
   
    position: absolute;                           
    top:0px;
    right :0px;     
    width: 25px;
    height: 25px;      
    @shadow: rgba(0 , 0, 0, 0);
    background-color: red;                
    border-radius: 50%;                
    display: inline-block;       
    vertical-align:middle;      
    color: white;                                       
    text-align:center;      
  }
</style>                                                                 
</head>       
<body><% ServletContext ses=getServletContext();  Object value=ses.getAttribute("value");
if(value==null)value=0;
%>
      <header>                                                                                        
       <div class="box" class="box">  
    <!--    <img src="images/globe.jpg" class="box"> -->
      <div class="inner-box"> <%=value %> </div> </div>  
     <h1 center>Cart List Items</h1>      
    <hr>  
    </header>
</body>                         
</html>                                    