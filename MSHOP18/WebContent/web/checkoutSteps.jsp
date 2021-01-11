<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<jsp:include page="/web/mshopNavbar.jsp"></jsp:include>
</header>
  <div class="mshop_cat">
        <jsp:include page="/web/categoryBar.jsp"></jsp:include>
 </div>
 <div class="checkout__style">
 
    <div class="checkout__flow">
        <div class="flow_button my-5">
            <div class="row">
                <div class="col-3">
                  <h3><span class="badge w-100 badge-pill badge-danger">1.LOGIN</span></h3>
                </div>
                <div class="col-3">
                  <h3><span class="badge w-100 badge-pill badge-dark">2.SHIPPING ADDRESS</span></h3>
                </div>
                <div class="col-3">
                    <h3> <span class="badge w-100 badge-pill badge-dark">3.ORDER REVIEW</span></h3>

                </div>
                <div class="col-3">
                    <h3>  <span class="badge w-100 badge-pill badge-dark">4.PAYMENT </span></h3>

                </div>
            </div>
        </div>
    </div>

       <!-- shipping address form-->
       <div class="shipping__address_form">
           <div class="row">
               <div class="col-2">

               </div>
               <div class="col-5">
               <div class="card">
                   <div class="card-header">
                       <h5 class="text-muted">Shipping Address</h5>
                   </div>
                   <div class="card-body">
                    <form>
                        <div class="form-group">
                          <label for="exampleInputFirstName">First Name</label>
                          <input type="text" class="form-control" name="firstName" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter First Name">
                          <small id="emailHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputName">Last Name</label>
                          <input type="text" class="form-control"  id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Last Name">
                          <small id="emailHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail">Email address</label>
                          <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Email ID">
                          <small id="emailHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Mobile Number</label>
                          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Mobile Number">
                          <small id="emailHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Address</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Address">
                            <small id="emailHelp" class="form-text text-muted"></small>
                          </div>
                          <div class="form-group">
                            <label for="exampleInputEmail1">Land Mark</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Landmark">
                            <small id="emailHelp" class="form-text text-muted"></small>
                          </div>
                        <div class="form-group">
                        <label for="exampleInputEmail1">Pincode</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Pincode">
                        <small id="emailHelp" class="form-text text-muted"></small>
                      </div>
                      <div class="form-group">
                          <label for="exampleInputEmail1">City</label>
                          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter City" disabled>
                          <small id="emailHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">State</label>
                          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter State" disabled>
                          <small id="emailHelp" class="form-text text-muted"></small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Country</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter country" disabled>
                            <small id="emailHelp" class="form-text text-muted"></small>
                          </div>
                        <div class="form-check">
                            <div class="row">
                                <div class="col-3">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                                        <label class="form-check-label" for="exampleRadios1">
                                          Home
                                        </label>
                                      </div>
                                </div>
                                <div class="col-3">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                                        <label class="form-check-label" for="exampleRadios1">
                                          Office
                                        </label>
                                      </div>
           
                                </div>
                                <div class="col-3">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                                        <label class="form-check-label" for="exampleRadios1">
                                          Other
                                        </label>
                                      </div>

                                </div>
                                <div class="col-3">

                                </div>
                            </div>
                            </div>
                            <div class="my-4">
                                <button type="submit" class="my-2 btn btn-block btn-danger">Submit</button>
                            </div>
                      </form>
                   </div>
               </div>
               </div>
               <div class="col-3">
                <div class="card">
                    <div class="card-header">
                        <p>Address</p>
                    </div>
                    <div class="card-body">
                        <p>Manoj Kadam,</p>
                        <p>At Post Waloti,Chiplun 415605,</p>
                        <p>Ratnagiri,Maharastra</p>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                            <label class="form-check-label" for="defaultCheck1">
                              select
                            </label>
                            <span class="text-danger">delete</span>
                          </div>                          
                    </div>
                </div>
                <div class="card my-2">
                    <div class="card-header">
                        <p>Address</p>
                    </div>
                    <div class="card-body">
                        <p>Manoj Kadam,</p>
                        <p>At Post Waloti,Chiplun 415605,</p>
                        <p>Ratnagiri,Maharastra</p>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                            <label class="form-check-label" for="defaultCheck1">
                              select
                            </label>
                            <span class="text-danger">delete</span>
                          </div>                          
                    </div>
                </div>
               </div>
           </div>
       </div>
      <!-- Order review-->
      <div class="order__review">

      </div>

      <!--payment page-->
      <div class="payment_method my-4">
        <div class="row">
            <div class="col-1">

            </div>
            <div class="col-7">
                <div class="row">
                    <div class="col-4">
                      <div class="list-group" id="list-tab" role="tablist">
                        <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list" href="#list-home" role="tab" aria-controls="home">CASH ON DELIVERY</a>
                        <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list" href="#list-profile" role="tab" aria-controls="profile">NET BANKING</a>
                        <a class="list-group-item list-group-item-action" id="list-messages-list" data-bs-toggle="list" href="#list-messages" role="tab" aria-controls="messages">CREDIT CARD</a>
                        <a class="list-group-item list-group-item-action" id="list-settings-list" data-bs-toggle="list" href="#list-settings" role="tab" aria-controls="settings">PROMO CODE</a>
                      </div>
                    </div>
                    <div class="col-8">
                      <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">Enter Captcha</div>
                        <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">bbb</div>
                        <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">ccc</div>
                        <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">ddd</div>
                      </div>
                    </div>
                  </div>
              </div>
              <div class="col-3">
                <div class="card">
                    <div class="card-header">
                       <p>Order Details</p>
                    </div>
                       <div class="card-body">
                          <p>Sub Total INR 7777</p>
                          <p>Shoppig Items 3</p>
                          <p>Shipping Charge INR 60</p>
                          <p>Total INR 7777</p>
                       </div>
                </div>
              </div>
              <div class="col-1">
                  
              </div>
            </div>
        </div>
        <div class="d-flex justify-content-center">
          <div class="spinner-border text-danger" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
          </div>
        </div>
 </div>
</body>
</html>