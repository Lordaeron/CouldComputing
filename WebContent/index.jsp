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
	String name = ses.getAttribute("displayname").toString();
    String current = ses.getAttribute("current").toString();%>
	<%@page import="appdatabase.*, java.util.*" %>
	<%
	readappdb rdb = new readappdb();
	rdb.readapp();
	ArrayList<appdb> apps = rdb.returnList(); 
	%>
	
	
	
</head>


<body>
    <div class="container">
    <nav class="navbar navbar-inverse navbar-static-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="start.jsp">CloudComputing</a>
        </div>
          <ul class="nav navbar-nav navbar-right"> 
            <li><a href="#"><span class="glyphicon glyphicon-user"></span><%= name%></a></li>
            <li>
            <form  type ="hidden" action="LogOff" method="POST">
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
         
            <div class="mainpanel col-md-9">
                <div class="row">
                <%
                Iterator<appdb> i = apps.iterator();
                while(i.hasNext()){
                	appdb a = i.next();
                	out.println("<div class='col-lg-3 col-md-6'>");
                	out.println("<div class='panel panel-primary'>");
                	out.println("<div class='panel-heading'>");
                	out.println("<div class='row'>");
                	out.println("<div class='col-xs-3'>");
                	out.println("<img scr="+a.getUrl()+"/Test.png, alt=' icon ', height='50', width = '50'>");
                	out.println("</div><div class='col-xs-9 text-right'>");
                	out.println("<div>"+a.getName()+"</div>");
                	out.println("</div></div></div>");
			out.println(" <input id='curUrl' data-url='"+a.getUrl()+"'><a href="+a.getUrl()+">");
                	//out.println(" <a href="+"#"+">");
                	out.println("<div class='testpost' class='panel-footer'>");
                	out.println("<span class='pull-left'>View Details</span>");
                	out.println("<span class='pull-right'><i class='fa fa-arrow-circle-right'></i></span>");
                	out.println("<div class='clearfix'></div>");
                	out.println("</div></a></div></div>");
                }
                
                %>

                </div>
                </div>
             </div>
            </div>

            <form id="postdata" action="moneybalance" method="POST">
                  <input id="inputdata" type="hidden" name="url" value="yes">
            </form>
       

        </div>
   </div>


    
    <script src="https://code.jquery.com/jquery-3.2.1.js"
      integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
      crossorigin="anonymous" >  
    </script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <script>
        $(document).ready(function(){
        $(".testpost").click(function(){
            $('input#curUrl').on('click',function(){
           	 var curUrl = $(this).data('url');
           	    
            	$("#inputdata").val(curUrl);
            	$("postdata").submit();
            	alert("you will pay 10 pranuts")
            });
		});
      });
     
    </script>
</body>

</html>
