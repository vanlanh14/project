<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/lanh.css">
</head>
<body>
    <header>
        <div class="collapse bg-dark" id="navbarHeader">
          <div class="container">
            <div class="row">
              <div class="col-sm-8 col-md-7 py-4">
                <h4 class="text-white">About</h4>
                <p class="text-muted">Add some information.</p>
              </div>
              <div class="col-sm-4 offset-md-1 py-4">
                <h4 class="text-white">Contact</h4>
                <ul class="list-unstyled">
                  <li><a href="#" class="text-white">Follow on Twitter</a></li>
                  <li><a href="#" class="text-white">Like on Facebook</a></li>
                  <li><a href="#" class="text-white">Email me</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="navbar navbar-dark bg-dark box-shadow">
            <div class="container d-flex justify-content-between">
                <a href="#" class="navbar-brand d-flex align-items-center">
                <img src="images/online-store.png" style="width: 40px;  height: 40px;"/>
                <strong>Shop</strong>
                </a>
                <div class="pull-right">
                    <a class="thumbnail pull-left" href="/springmvc/cart" style="padding-right: 15px;">
                        <img class="media-object" src="images/online-store.png" style="width: 40px; height: 40px;">
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
            </div>
        </div>
    <main>
       <div class="container">
           <div style="margin: 10px 0;">
               <nav class="breakdcrumb">
                   <a class="breakdcrumb-item" href="/springmvc/home">Home /</a>
                   <a class="breakdcrumb-item" href="#">Phone /</a>
                   <span class="breakdcrumb-item active">SamSung</span>
               </nav>
           </div>
           <div class="row">
               <div class="col-md-5 item-photo">
                   <img style="max-width:100%;" src="${product.image}"/>
               </div>
               <div class="col-md-7" style="border:0px solid gray">
                   <!--info-->
                   <h3>${product.title}</h3>
                   <h5 style="color:337ab7">Brand: ${product.brand}<a href="#">SamSung</a></h5>
                   <small style="color: #337ab7">(5054 votes)</small>
                   <!--price-->
                   <h6 class="tittle-price"><small>Price</small></h6>
                   <h3 style="margin-top: 0px;">${product.price}</h3>
                   <!--product detail choice-->
                   <div class="section" style="padding-bottom: 20px;">
                       <h6 class="tittle-attr"><small>Quantity</small></h6>
                       <div>
                           <div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>
                           <input value="1"/>
                           <div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>
                       </div>
                   </div>
                   <!--add to cart-->
                   <div class="section" style="padding-bottom: 20px;">
                        <form action="cart/buy?id=${product.idp}" method="POST">
                       <button class="btn btn-success" type="submit">
                           <span style="margin-right: 20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                           Add to cart
                       </button>
                        </form>
                   </div>
               </div>
               <div class="col-xs-9">
                   <ul class="menu-items">
                        <li class="active">Product Detail</li>
                        <li>Guarantee</li>
                        <li>Buyer</li>
                        <li>Comments</li>
                   </ul>
                   <di style="width: 100%; border-top: 1px solid silver;">
                       <p style="padding: 15px;">
                           <small>
                                stay connected either on the phone or the Web with the Galaxy C9 Pro from SamSung.
                           </small>
                       </p>
                       <samll>
                           <ul>
                               <li>
                                   ${product.description}
                               </li>
                           </ul>
                       </samll>
                   </di>
               </div>
            </div>
       </div>
     </from>
    </main>
    <section id ="footer">
        <div class="container">
            <p>Coppyright Mstia.</p>
        </div>
    </section>
    <script src="javascript/jquery-3.3.1.slim.min.js"></script>
    <script src="javascript/bootstrap.min.js"></script>
    <script src="javascript/productDetail.js"></script>
</body>
</html>