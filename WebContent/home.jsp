<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {box-sizing: border-box;}
.img-zoom-container {
  position: relative;
}
.img-zoom-lens {
  position: absolute;
  border: 1px solid #d4d4d4;
  /*set the size of the lens:*/
  width: 100px;
  height: 80px;
}
.img-zoom-result {
  border: 1px solid #d4d4d4;
  /*set the size of the result div:*/
  width: 500px;
  height: 400px;
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
</style>
<script>
function imageZoom(imgID, resultID) {
  var img, lens, result, cx, cy;
  img = document.getElementById(imgID);
  result = document.getElementById(resultID);
  /*create lens:*/
  lens = document.createElement("DIV");
  lens.setAttribute("class", "img-zoom-lens");
  /*insert lens:*/
  img.parentElement.insertBefore(lens, img);
  /*calculate the ratio between result DIV and lens:*/
  cx = result.offsetWidth / lens.offsetWidth;
  cy = result.offsetHeight / lens.offsetHeight;
  /*set background properties for the result DIV:*/
  result.style.backgroundImage = "url('" + img.src + "')";
  result.style.backgroundSize = (img.width * cx) + "px " + (img.height * cy) + "px";
  /*execute a function when someone moves the cursor over the image, or the lens:*/
  lens.addEventListener("mousemove", moveLens);
  img.addEventListener("mousemove", moveLens);
  /*and also for touch screens:*/
  lens.addEventListener("touchmove", moveLens);
  img.addEventListener("touchmove", moveLens);
  function moveLens(e) {
    var pos, x, y;
    /*prevent any other actions that may occur when moving over the image:*/
    e.preventDefault();
    /*get the cursor's x and y positions:*/
    pos = getCursorPos(e);
    /*calculate the position of the lens:*/
    x = pos.x - (lens.offsetWidth / 2);
    y = pos.y - (lens.offsetHeight / 2);
    /*prevent the lens from being positioned outside the image:*/
    if (x > img.width - lens.offsetWidth) {x = img.width - lens.offsetWidth;}
    if (x < 0) {x = 0;}
    if (y > img.height - lens.offsetHeight) {y = img.height - lens.offsetHeight;}
    if (y < 0) {y = 0;}
    /*set the position of the lens:*/
    lens.style.left = x + "px";
    lens.style.top = y + "px";
    /*display what the lens "sees":*/
    result.style.backgroundPosition = "-" + (x * cx) + "px -" + (y * cy) + "px";
  }
  function getCursorPos(e) {
    var a, x = 0, y = 0;
    e = e || window.event;
    /*get the x and y positions of the image:*/
    a = img.getBoundingClientRect();
    /*calculate the cursor's x and y coordinates, relative to the image:*/
    x = e.pageX - a.left;
    y = e.pageY - a.top;
    /*consider any page scrolling:*/
    x = x - window.pageXOffset;
    y = y - window.pageYOffset;
    return {x : x, y : y};
  }
  
}
</script>
</head>
<body bgcolor="#ff0060">
          
<form action="controller" method="post">
<table align="center" cellpadding = "10">
                    

    <img src="images/rooter.jpg" alt="Girl in a jacket" width="150" height="150">
    <input type="checkbox" name="pro1" value="rooter">      
    <img src="images/chessboard.jpg" alt="Girl in a jacket" width="150" height="150">
    <input type="checkbox" name="pro2" value="chess_board"> 
    <img src="images/bag.jpg" alt="Girl in a jacket" width="150" height="150">
    <input type="checkbox" name="pro3" value="bag"> <br>
    <img src="images/belt.jpg" alt="Girl in a jacket" width="150" height="150">
    <input type="checkbox" name="pro4" value="belt">        
    <img src="images/globe.jpg" alt="Girl in a jacket" width="150" height="150">
    <input type="checkbox" name="pro5" value="globe">       
    <img src="images/book.jpg" alt="Girl in a jacket" width="150" height="150">
    <input type="checkbox" name="pro6" value="book"> <br>   
    <img src="images/phone.jpg" alt="Girl in a jacket" width="150" height="150">
    <input type="checkbox" name="pro7" value="i-phone"> 
    <img src="images/cricket.jpg" alt="Girl in a jacket" width="150" height="150">
    <input type="checkbox" name="pro8" value="cricket-kit">
   
    <img src="images/rubix-cube.jpg" alt="Girl in a jacket" width="150" height="150">
    <input type="checkbox" name="pro10" value="rubix_cube">  <br><br><br><br><br>      
                      
<input colspan="2" align="center" type="submit" value="Submit">
</form>            
<div class="img-zoom-container">                        
  <img id="myimage" src="images/cricket.jpg" width="300" height="200">
  <div id="myresult" class="img-zoom-result"></div>
 
</div>  
<script>
                     
imageZoom("myimage", "myresult");                                           
</script>
</body>        
</html>                   