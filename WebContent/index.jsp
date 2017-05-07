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
    <meta name="author" content="">

    <title>Sheffield CloudComputing</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <%HttpSession ses = request.getSession(true);
	String name = ses.getAttribute("displayname").toString();%>
</head>

<body>
<form action = "TestSession", method = "POST">
    <div class="container">
    <nav class="navbar navbar-inverse navbar-static-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="start.jsp">CloudComputing</a>
        </div>
          <ul class="nav navbar-nav navbar-right"> 
            <li><a href="#"><span class="glyphicon glyphicon-user"></span><%= name%></a></li>
            <form action="LogOff" method="POST">
            <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logoff</a></li>
            </form>> 
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
         
            <div class="mainpanel col-md-9">
                <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    
                                    <img scr="/Arkanoid/Test.png", alt=" icon ", height="50", width = "50">
                                </div>
                                <div class="col-xs-9 text-right">
                             
                                    <div>Arkanoid</div>
                                </div>
                            </div>
                        </div>
                        <a href="/Arkanoid">
                            <div class="panel-footer">
                                <span class="pull-left">View Details<</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <img scr="/Roulette/Test.png", alt=" icon ", height="50", width = "50">
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div>Roulette</div>
                                </div>
                            </div>
                        </div>
                        <a href="/betgame">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <img scr="/FlappyBird/Test.png", alt=" icon ", height="50", width = "50">
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div>Flappy Bird</div>
                                </div>
                            </div>
                        </div>
                        <a href="/FlappyBird">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <img scr="/BlackJack/Test1.png", alt=" icon ", height="50", width = "50">
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div>Black Jack</div>
                                </div>
                            </div>
                        </div>
                        <a href="/blackjack/blackjack.html">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                </div>
             </div>
        </div>
    </div>
 


    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
   </form>
</body>

</html>
