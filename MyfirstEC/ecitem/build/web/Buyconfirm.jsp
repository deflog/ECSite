<%-- 
    購入しますか？YES/NO
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="page.Syouhindatabeans"
        import="page.*"%>
<%
ArrayList<Syouhindatabeans> shd = (ArrayList)request.getAttribute("shd");
int goukei = 0;
HttpSession hs = request.getSession(false);
hs.setAttribute("buyitem",shd);
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
                background: url("image/YUKATIMGL0441_TP_V1.jpg");
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
        <title>Buy comfirm</title>
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
            <input type="hidden" name="path" value="<%=(String)hs.getAttribute("path")%>">
             <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            </div>
            <button type="submit">
                <span><i class="glyphicon glyphicon-plus-sign white"></i></span>
            </button>
        </form>
            <%}else{%>
            <form class="navbar-form navbar-right" action="Login" method="POST">
                 <input type="hidden" name="path" value="<%=(String)hs.getAttribute("path")%>">
                 <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <button type="submit">
                <span><i class="glyphicon glyphicon-minus-sign white"></i></span>
            </button>
            </form>
            <form class="navbar-form navbar-right" action="Mydata" method="POST">
            <input type="hidden" name="path" value="<%=(String)hs.getAttribute("path")%>">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <button type="submit">
                <span><i class="glyphicon glyphicon-user white"></i></span>
            </button>  
            </form>
            <%}%>
             <form class="navbar-form navbar-right" action="cart" method="POST">
            <input type="hidden" name="path" value="<%=(String)hs.getAttribute("path")%>">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <button type="submit">
                <span><i class="glyphicon glyphicon-shopping-cart white"></i></span>
            </button>
            </form>
             <form class="navbar-form navbar-right" action="Registration" method="POST">
            <input type="hidden" name="path" value="<%=(String)hs.getAttribute("path")%>">
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
                    <h1>Purchase</h1>
                </div>
            </header>
            <div class="container main-content">
          <div class="row">
            <table class="table table-hover">
             
            <tr>
                <th>Image</th>
                <th>Price/yen</th>
                <th>Item</th>
                
            </tr>
             <%for(int i=0;i<shd.size();i++){%>
             <%goukei+=shd.get(i).getPrice();%>
            <tr>
                <td><img src="<%= shd.get(i).getImage()%>" alt="" width="100"height="100"></td>
                <td><%=shd.get(i).getPrice()%></td>
                <td><a href="Resultdetail?id=<%=shd.get(i).getCode()%>"><%= shd.get(i).getName()%></a></td>
                
                
            </tr>
            
             <%}%>
             <tr>
                 <th>TotalPrice</th>
                 <td><%=goukei%></td>
             </tr>
            </table>
             
          </div>
             <p>Shopping method</p>
             <form action="Buycomp" method="POST">
                <input type="radio" name="type" value="1" checked="checked">クロネコ
                <input type="radio" name="type" value="2">カンガルー
                <input type="radio" name="type" value="3">ネズミ
                <h1 class="text-center">Purchase?</h1>
                <input type="hidden" name="goukei" value="<%=goukei%>">
                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <button type="submit" class="btn btn-primary" style="margin:0px; float:left;">YES YES YES!</button>
             </form>
                <form action="cart" method="buy">
                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <input type="hidden" name="path" value="<%=hs.getAttribute("path")%>">
                <button type="submit" class="btn btn-warning" style="margin:0px; float:left;">Cart</button>
            </form>
                <form action="<%=hs.getAttribute("path")%>">
                    <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                    <button class="btn btn-default" type="submit">Back</button>
            </form>
       </div>
       <footer class="container-fluid">
          <small><a href="Search">Copyright (C) 2017 MAY All Rights Reserved.</a></small>
      </footer>
             
    </body>
</html>
