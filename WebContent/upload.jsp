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
	<%HttpSession ses = request.getSession(true);
	String name = ses.getAttribute("displayname").toString();%>
    <title>Sheffield CloudComputing</title>

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
            <li><a href="#"><span class="glyphicon glyphicon-user"></span><%= name%></a></li> 
            <form action="LogOff" method="POST">
            <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logoff</a></li> 
            </form>
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

      <div class="filepanel col-md-9">
      <div class="table table-striped " class="files" id="previews">
      <div id="template" class="file-row">
        <div class="page-header">
            <h1>Upload your java File </h1>
            <p>Please upload a game application in JAR, ZIP or WAR format. </p>
        </div>
      <div>
        <span class="preview"><img data-dz-thumbnail /></span>
      </div>
      <div>
        <p class="name" data-dz-name></p>
        <strong class="error text-danger" data-dz-errormessage></strong>
      </div>
      <div>
        <p class="size" data-dz-size></p>
        <div class="progress progress-striped active" role="progressbar" aria-valuemin="50" aria-valuemax="100" aria-valuenow="0">
          <div class="progress-bar progress-bar-success" style="width:70%;" data-dz-uploadprogress></div>
        </div>
      </div>
      <div>

        <form action="Uploaderservlet" method="post" enctype="multipart/form-data">
        <input type="text" method="post" name="appname"> </input>
        <input type="text" method="post" name="aboutapp"> </input>
        <input type="file" name="file"> </input>
        <button type="submit" class="btn btn-default">submit</button>
        </form>
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
</body>

</html>