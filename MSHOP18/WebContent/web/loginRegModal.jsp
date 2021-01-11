<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Vertically centered scrollable modal -->
<!-- Modal -->
 <!-- login modal start -->
<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h2 class="modal-title" id="exampleModalLabel">Login</h2>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="close_logins">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <div class="logincontainer">
  <form action="">
    <div class="rows">
      <div class="vl">
        <span class="vl-innertext">or</span>
      </div>

      <div class="cols">
        <a href="#" class="fb btns text-center nav-link small">
          <i class="fa fa-facebook fa-fw"></i><small>Login with Facebook</small> 
         </a>
        <a href="#" class="twitter btns text-center small nav-link">
          <i class="fa fa-twitter fa-fw"></i> <small>Login with Twitter</small>
        </a>
        <a href="#" class="google btns text-center nav-link small"><i class="fa fa-google fa-fw">
          </i> <small>Login with Google+</small>
        </a>
      </div>

      <div class="cols">
        <div class="hide-md-lg">
          <p>Or sign in manually:</p>
        </div>
        <div class="">
          <input type="text" name="usermobile" class="btns" placeholder="mobile" id="usermobile" required>
          <p class="loginmobile-err error small"></p>
        </div>
          <div class=" my-4">
        <input type="password" name="userpassword" class="btns" placeholder="Password" id="userpassword" required>
        <p class="loginpass-err error small"></p>
        </div>
        <div class="my-4">
        <input type="button" value="Login" class="btn btn-danger btn-block" id="user_login__btn">
          </div>
           <div class="my-4">
        	<p class="error" id="login__msg"></p>
          </div>
        </div>
        </div>
  </form>
  
<div class="bottom-container my-4">
  <div class="rows">
    <div class="cols">
      <a href="#" style="color:white" class="btns" data-toggle="modal" data-target="#signupModal" id="signUp_links" class="close" data-dismiss="modal">Sign up</a>
    </div>
    <div class="cols">
      <a href="#" style="color:white" class="btns">Forgot password?</a>
    </div>
  </div>
</div>
       </div>
      </div>
    </div>
  </div>
</div>
      <!-- login modal end -->
      
      <!-- register modal start -->
      <!-- Button trigger modal -->
<!-- Modal -->
<div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h2 class="modal-title" id="exampleModalLabel">Sign Up.</h2><span></span>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="close_regs">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <h3 class="text-success text-center" id="signUp__msg"></h3>
      <div class="logincontainer">
  <form action="">
    <div class="rows">
      <div class="vl">
        <span class="vl-innertext">or</span>
      </div>

      <div class="cols my-4">
        <a href="#" class="fb btns text-center nav-link small">
          <i class="fa fa-facebook fa-fw"></i> <small>Login with Facebook</small>
         </a>
        <a href="#" class="twitter btns text-center nav-link small">
          <i class="fa fa-twitter fa-fw"></i> <small>Login with Twitter</small>
        </a>
        <a href="#" class="google btns text-center nav-link small"><i class="fa fa-google fa-fw">
          </i> <small>Login with Google+</small>
        </a>
      </div>

      <div class="cols">
      <div class="form-group">
          <input type="text" name="firstName" class="form-control" placeholder="First Name" id="firstName" required>
          <p class="fn-err error small"></p>
        </div>
        <div class="form-group">
          <input type="text" name="lastName" class="form-control" placeholder="Last Name" id="lastName" required>
            <p class="ln-err error small"></p>     
        </div>
        <div class="form-group">
          <input type="text" name="emailId" class="form-control" placeholder="Email" id="emailId" required>
            <p class="email-err error small"></p>         
        </div>
        <div class="form-group">
          <input type="text" name="mobileNo" class="form-control" placeholder="Mobile" id="mobileNo" required>
             <p class="mob-err error small"></p>     
        </div>
          <div class="form-group">
        <input type="password" name="upassword" class="form-control" placeholder="Password" id="upassword" required>
          <p class="pass-err error small"></p>
        </div>
        <div class="form-group">
        <input type="button" value="Sign Up" class="btn btn-danger btn-block btns" id="register__btn">
          </div>
          <div class="my-4">
          <small>Already have an account ?</small><a href="#" data-toggle="modal" data-target="#loginModal"data-dismiss="modal" aria-label="Close" id="sigin_links">Sign In</a>
           </div> 
        </div>
        </div>
  </form>
       </div>
      </div>
    </div>
  </div>
</div>
   <input type="hidden" id="req_url" value="${pageContext.request.contextPath}/faces/web">
   
</body>
</html>