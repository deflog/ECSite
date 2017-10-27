<%-- 
    リクエスト受け取って個別表示
--%>
<%@page import="page.jums"%>
<%@page import="page.Syouhindatabeans"
        import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"%>
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
                background: url("image/GREEN20160902172018_TP_V.jpg");
                background-position:center center;
                background-size: cover;
                color:#101010;    
            }
            div.jumbotron{
                 background: url("image/tomDSC08971_TP_V1.jpg");
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
            i.red{
                color: #d43f3a;
            }
         footer{
             text-align: center;
             padding: 10px;
             background: #101010;
         }
     </style>
        <title>MyCart</title>
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
              <%if(hs.getAttribute("user")!=null){%>
              <%
               String cartname = (String)request.getAttribute("cart");
    ArrayList<Syouhindatabeans> shd= (ArrayList)hs.getAttribute(cartname);
              %>
        <%if(shd!=null){
          %>
        
        <%if(shd.size()>0){%>
            <table class="table table-hover">
             
            <tr>
                <th>Image</th>
                <th>Price/yen</th>
                <th>Item</th>
                <th>Remove</th>
                
            </tr>
             <%for(int i=0;i<shd.size();i++){%>
            <tr>
                <td><img src="<%= shd.get(i).getImage()%>" height="50" width="50"></td>
                <td><%= shd.get(i).getPrice()%></td>
                <td><%= shd.get(i).getName()%></td>
                <td>          
                    <form action="Delete" method="POST">
                <input type="hidden" name="cart" value="<%=cartname%>">
                <input type="hidden" name="number" value="<%=i%>">
                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <input type="hidden" name="path" value="<%=hs.getAttribute("path")%>">
                <button type="submit">
                    <span><i class="glyphicon glyphicon-remove red"></i></span>
                </button>
                </form>
            </td>
            </tr>
            <%}%>
        </table>
            
        
        <form action="Buyconfirm" method="POST">
            <input type="hidden" name="cart" value="<%=cartname%>">
            <input type="hidden" name="path" value="<%=request.getAttribute("path")%>">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <input type="hidden" name="number" value="buyall">
            <button type="submit" class="btn btn-primary">Purchase All</button>
        </form>
            <%}else{%>
            <div class="jumbotron">
            <h1 class="text-center">Empty Cart</h1>
           <br><%}%>
            
            
            <%}else{%>
            <h1 class="text-center"> Empty Cart</h1>
            
            <br>
            </div>
           
            <%}%>
            <%}else{%>
            <div class="panel panel-default">
            <form action="Login" method="POST">
                <table class="table table-hover">
                    <tr>
                        <th>User</th>
                        <td><input type="text" name="id" maxlength="10"></td>
                    </tr>
                    <tr>
                        <th>Password</th>
                        <td><input type="password" name="pass" maxlength="8"></td>
                    </tr>
                </table>
            
            <input type="hidden" name="path" value="<%=(String)hs.getAttribute("path")%>">
             <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
             <button type="submit" class="btn btn-primary">Sign in</button>
            </form>
            </div>
          
<%}%>
                <div class="text-center">
                <form action="Search" method="POST">
                                <input type="hidden" value="<%=hs.getAttribute("path")%>">
                                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                                <button type="submit" class="btn btn-default">TOP</button>
                            </form>
                </div>
          </div>
         </div>
        <footer class="container-fluid">
          <small><a href="Search">Copyright (C) 2017 MAY All Rights Reserved.</a></small>
      </footer>
    </body>
</html>
