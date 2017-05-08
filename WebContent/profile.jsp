<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="siliang liu">
	<%HttpSession ses = request.getSession(true);
	String name = ses.getAttribute("displayname").toString();
	String current = ses.getAttribute("current").toString();%>
    <title>Profile</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

    <div class="container">
        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">CloudComputing</a>
            </div>
                <ul class="nav navbar-nav navbar-right"> 
                <li><a href="#"><span class="glyphicon glyphicon-user"></span><%= name %></a></li> 
                <li>
                <form action="LogOff" method="POST">
                <a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logoff</a>
                </form>
                </li> 
                <li><a href="#"><span class="glyphicon glyphicon-euro"></span><p><%=current %></p></a></li> 
                
                </ul> 
        </nav>


       <div class="raw">
           <div class="siderbar col-md-3">
                <ul class="nav">
                <li class="active">
                    <a href="index.jsp">
                        <i class="glyphicon glyphicon-th"> Dashboard</i>                   
                    </a>
                </li>
                <li>
                    <a href="profile.jsp">
                        <i class="glyphicon glyphicon-user"> Profile</i>
                    </a>
                </li>
                <li>
                    <a href="upload.jsp">
                        <i class="glyphicon glyphicon-upload"> Upload</i>
                    </a>
                </li>
                
                </li>
                <li>
                    <a href="about.jsp">
                        <i class="glyphicon glyphicon-flag"> About</i>
                    </a>
                </li>
                <li>
                    <a href="Analysis.jsp">
                        <i class="glyphicon glyphicon-align-left"> Analysis</i>
                    </a>
                </li>
               
                </ul>
           </div>
           <div class="content col-md-9">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Profile</h4>
                            </div>
                            <div class="content">
                                <form action="Profile" method="POST" >
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>City </label>
                                                <input type="text" name="city" class="form-control" disabled placeholder="Sheffield" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Username</label>
                                                <input type="text" name="username" class="form-control" placeholder="Username" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Email address</label>
                                                <input type="email" name="email" class="form-control" placeholder="Email" value="">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>First Name</label>
                                                <input type="text" name="fristname" class="form-control" placeholder="First Name" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Last Name</label>
                                                <input type="text" name="lastname" class="form-control" placeholder="Last Name" value="">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input type="text" name="address" class="form-control" placeholder="Home Address" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Postal Code</label>
                                                <input type="number" name="postcode" class="form-control" placeholder="ZIP Code">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>About Me</label>
                                                <input rows="5" name="aboutme" class="form-control" placeholder="Here can be your description" value=""> 
                                                </input>
                                            </div>
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-info btn-fill pull-right">Update Profile</button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="advertisment">
   
                        </div>
                    </div>

                </div>
            </div>
           </div>
        </div>
    </div>
 
    <!-- jQuery -->
    <script
  	src="https://code.jquery.com/jquery-2.2.4.js"
  	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  	crossorigin="anonymous"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

     <script>
      //  var money; 
/*         var data = "current="+"Yshi29@sheffield"; 
     	$(document).ready(function() {		
    		$.ajax({
            	type: "POST",
            	url:  "/CloudComputing/DatabaseAPI",
            	data: data,
            	success: function (res) {
                	money = res;
                	console.log(money);
            }})
		});
		$("#money").text(money); */

     </script>
</body>

</html>
