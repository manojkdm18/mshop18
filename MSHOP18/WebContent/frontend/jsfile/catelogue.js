/**
 * manojkdm18
 */

$(document).ready(function(){
	let url = "ajax.jsp?flag=loadheader";
	 $.ajax({
		 url: url,
	     type:"get",
	     success:function(data){
	     }
		 
	 });


	});

$(document).on("click","#myShopingCart",function(e){
	let URL = $("#url").val();
	let url = URL+"/ajax.jsp?flag=myShopingCart";
	 $.ajax({
		 url: url,
	     type:"post",
	     success:function(data){
	    	 let resp = data;
	    	 console.log(resp);
	    	 if(resp != null){
	    		 $("#cart__data").empty().append(resp);
	    	 }
	    	
	     }
		
	 });

});

$(document).on("click","#user_login__btn",function(e){
	let URL = $("#req_url").val();
	let mobileNo = $("#usermobile").val();
	let upassword = $("#userpassword").val();
	let params = {'mobileNo':mobileNo,'upassword':upassword}
	if(validateValues(mobileNo)){
		$(".loginmobile-err").html("**Please enter Mobile Number");
		$(".loginmobile-err").show();
		return false;
	}else if(!IsMobile(mobileNo)){
		$(".loginmobile-err").html("**Please enter valid Mobile Number");
		$(".loginmobile-err").show();
		return false;
	}
	else{
		$(".loginmobile-err").hide();
	}
	if(validateValues(upassword)){
		$(".loginpass-err").html("**Please enter password");
		$(".loginpass-err").show();
		return false;
	}else{
		$(".loginpass-err").hide();
	}
	
	let url = URL+"/ajax.jsp?flag=login";
	 $.ajax({
		 url: url,
		 data:params,
	     type:"post",
	     success:function(data){
	    	 let resp = data;
	    	 console.log(resp);
	    	 if(resp.trim() == 'LOGIN_SUCCESS'){
	    		 location.reload(); 
	    	 }else{
	    		 $("#login__msg").empty().append(resp.trim());
	    	 }
	    	
	     }
		
	 });

});


$(document).on("click","#register__btn",function(e){
	let URL = $("#req_url").val();
	let firstName = $("#firstName").val();
	let lastName = $("#lastName").val();
	let emailId = $("#emailId").val();
	let mobileNo = $("#mobileNo").val();
	let upassword = $("#upassword").val();
	let params = {'firstName':firstName,'lastName':lastName,'emailId':emailId,'mobileNo':mobileNo,'upassword':upassword}
	if(validateValues(firstName)){
		$(".fn-err").html("**Please enter First Name");
		$(".fn-err").show();
		return false;
	}else{
		$(".fn-err").hide();
	}
	
	if(validateValues(lastName)){
		$(".ln-err").html("**Please enter Last Name");
		$(".ln-err").show();
		return false;
	}else{
		$(".ln-err").hide();
	}
	
	if(validateValues(emailId)){
		$(".email-err").html("**Please enter Email ID");
		$(".email-err").show();
		return false;
	}else if(!IsEmail(emailId)){
		$(".email-err").html("**Please vaild Email ID");
		$(".email-err").show();
		return false;
	}else{
		$(".email-err").hide();
	}
	
	if(validateValues(mobileNo)){
		$(".mob-err").html("**Please enter Mobile Number");
		$(".mob-err").show();
		return false;
	}else if(!IsMobile(mobileNo)){
		$(".mob-err").html("**Please enter  valid Mobile Number");
		$(".mob-err").show();
		return false;
	}
	else{
		$(".mob-err").hide();
	}
	
	if(validateValues(upassword)){
		$(".pass-err").html("**Please enter Password");
		$(".pass-err").show();
		return false;
	}else if(upassword.length < 8){
		$(".pass-err").html("**please enter atleast 8 digit Password");
		$(".pass-err").show();
		return false;
	}else{
		$(".pass-err").hide();
	}
	
	let url = URL+"/ajax.jsp?flag=signup";
	 $.ajax({
		 url: url,
		 data:params,
	     type:"post",
	     success:function(data){
	    	 let resp = data;
	    	 console.log(resp);
	    	 if(resp != null){
	    		 $("#signUp__msg").empty().append(resp);
	    	 }
	    	
	     }
		
	 });

});

$(document).on("click","#signUp_link",function(){
	$("#loginModal").hide();
	
});


  function validateValues(value){
	  if(value == null || value== "" || value == undefined){
		  return true;
	  }else{
		  return false;
	  }
  }
  
  function IsEmail(email) {
	  var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  if(!regex.test(email)) {
	    return false;
	  }else{
	    return true;
	  }
  }

  function IsMobile(mob) {
	  var regex = /^[6-9]{1}[0-9]{9}$/;
	  if(!regex.test(mob)) {
	    return false;
	  }else{
	    return true;
	  }
  }
  
  $(document).on("click","#close_reg",function(){
		location.reload();
	});
