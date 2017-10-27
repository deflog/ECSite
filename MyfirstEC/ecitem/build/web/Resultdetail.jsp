<%-- 
   個別詳細
--%>
<%@page import="page.Syouhindatabeans"
        import="java.util.ArrayList"
        import="page.jums"%>
<%
HttpSession hs = request.getSession(false);
Syouhindatabeans shd = (Syouhindatabeans)hs.getAttribute("item");
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
                background: url("image/GREEN20160902172018_TP_V.jpg");
                background-position:center center;
                background-size: cover;
                color:#101010;    
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
        <title>Detail</title>
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
            <input type="hidden" name="path" value="<%=(String)request.getAttribute("path")%>">
             <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            </div>
            <button type="submit">
                <span><i class="glyphicon glyphicon-plus-sign white"></i></span>
            </button>
        </form>
            <%}else{%>
            <form class="navbar-form navbar-right" action="Login" method="POST">
                 <input type="hidden" name="path" value="<%=(String)request.getAttribute("path")%>">
                 <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <button type="submit">
                <span><i class="glyphicon glyphicon-minus-sign white"></i></span>
            </button>
            </form>
            <form class="navbar-form navbar-right" action="Mydata" method="POST">
            <input type="hidden" name="path" value="<%=(String)request.getAttribute("path")%>">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <button type="submit">
                <span><i class="glyphicon glyphicon-user white"></i></span>
            </button>  
            </form>
            <%}%>
             <form class="navbar-form navbar-right" action="cart" method="POST">
            <input type="hidden" name="path" value="<%=(String)request.getAttribute("path")%>">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <button type="submit">
                <span><i class="glyphicon glyphicon-shopping-cart white"></i></span>
            </button>
            </form>
             <form class="navbar-form navbar-right" action="Registration" method="POST">
            <input type="hidden" name="path" value="<%=(String)request.getAttribute("path")%>">
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
              <h1>Buy for Free</h1>
              <p>form</p>
              <p>好きなものを好きなだけ購入できる仮想ショッピングサイトです</p>
              
              <p><form action="Searchresult" method="GET">
                  <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                  <div class="input-group">
                  <input class="form-control" type="text" name="ward"placeholder="Search">
                  <span class="input-group-btn">
                  <button class="btn btn-default" type="submit">
                      <i class='glyphicon glyphicon-search'></i>
                 </button>
                  </span>
                  </div>
         
                  
              </form></p>
              
          </div>
            </header>
        <div class="container main-content">
          <div class="row">
                     <table class="table table-hover">
             
                        <tr>
                            <th>Image</th>
                            <th>Detail</th>
                            <th>Cart</th>
                        </tr>
                        <tr>
                            <td><img src="<%=shd.getImage()%>" alt="" width="200" height="200"></td>
                    <td>Item：<%=shd.getName()%><br>

                    Price：<%=shd.getPrice()%><br>
                    comment：<%=shd.getHeadline()%>
                    </td>
                    <td>
                    <form action="Additem" method="POST">
                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <button type="submit" class="btn btn-primary">Add</button>
              </form>
              <form action="Searchresult" method="GET">
                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <button type="submit" class="btn btn-default">Back</button>
              </form>
                    </td>
                </tr>
                     </table>
          </div>
        </div>
        <footer class="container-fluid">
          <small><a href="Search">Copyright (C) 2017 MAY All Rights Reserved.</a></small>
      </footer>
       
    </body>
</html>
