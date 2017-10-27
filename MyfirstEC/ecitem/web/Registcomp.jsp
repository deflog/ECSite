<%-- 
    登録情報表示して元ページに戻る
--%>
<%@page import="page.jums"%>
<%
HttpSession hs = request.getSession(false);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="boot/css/bootstrap.min.css" rel="stylesheet">
        <style>
            header.jumbotron {
                background: url("image/tomcatDSC08480_TP_V1.jpg");
                background-position:center center;
                background-size: cover;
                color:#fff;  
            }
            
          
            button{
               border:0;
               background:none;
               width:auto;
               overflow:visible;
            }
        i.white{
                color: #fff;
            }
         footer{
             text-align: center;
             padding: 10px;
             background: #101010;
         }
     </style>
        <title>COMPLETED</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
          <div class="navbar-header">
              <!--ロゴ-->
              <a class="navbar-brand" href="Search">MadinMAY</a>
              <!--トグルボタン-->
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nav-content">
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
              </button>
          </div>
          <div id="nav-content" class="collapse navbar-collapse">
              <!--リンクリスト-->
              <!--ul class="nav navbar-nav">
                  <li><a href="">Link1</a></li>
                  <li><a href="">Link1</a></li>
                  <li><a href="">Link1</a></li>
                  <li><a href="">Link1</a></li>
              </ul-->
              <%if(hs.getAttribute("user")==null){%>
        <form class="navbar-form navbar-right" action="Login" method="POST">
            <div class="form-group">
            
            <input type="text" name="id" maxlength="10"class="form-control" placeholder="user">
            
            <input type="password" name="pass" maxlength="8"class="form-control" placeholder="password">
            <input type="hidden" name="path" value="<%=hs.getAttribute("path")%>">
             <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            </div>
            <button type="submit">
                <span><i class="glyphicon glyphicon-plus-sign white"></i></span>
            </button>
        </form>
            <%}else{%>
            <form class="navbar-form navbar-right" action="Login" method="POST">
                 <input type="hidden" name="path" value="<%=hs.getAttribute("path")%>">
                 <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <button type="submit">
                <span><i class="glyphicon glyphicon-minus-sign white"></i></span>
            </button>
            </form>
            <form class="navbar-form navbar-right" action="Mydata" method="POST">
            <input type="hidden" name="path" value="<%=hs.getAttribute("path")%>">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <button type="submit">
                <span><i class="glyphicon glyphicon-user white"></i></span>
            </button>  
            </form>
            <%}%>
             <form class="navbar-form navbar-right" action="cart" method="POST">
            <input type="hidden" name="path" value="<%=hs.getAttribute("path")%>">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <button type="submit">
                <span><i class="glyphicon glyphicon-shopping-cart white"></i></span>
            </button>
            </form>
             <form class="navbar-form navbar-right" action="Registration" method="POST">
            <input type="hidden" name="path" value="<%=hs.getAttribute("path")%>">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <button type="submit">
                <span><i class="glyphicon glyphicon-leaf white"></i></span>
            </button>
            </form>
            <form class="navbar-form navbar-right" action="Search" method="POST">
                <button type="submit">
                <span><i class="glyphicon glyphicon-home white"></i></span>
            </button>
            </form>
            
          </div>
          
      </nav>
            <header class="jumbotron">
                <div class="container">
                  <h1>COMPLETED</h1>
                </div>
            </header>
            <h1 class="text-center">Regist Completed</h1>
        <form class="text-center"action="<%=hs.getAttribute("path")%>" method="GET">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <button type="submit" class="btn btn-default">Back</button>
        </form>
            <footer class="container-fluid">
          <small><a href="Search">Copyright (C) 2017 MAY All Rights Reserved.</a></small>
      </footer>
             
    </body>
    
</html>
