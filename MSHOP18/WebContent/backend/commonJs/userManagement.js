
$(document).on("click","#search_btn",function(e){
	let firstName = $("#firstName").val();
	let email = $("#email").val();
	let smobile = $("#smobile").val();
	let isActive = $("#isActive").val();
	let params = {'sfirstName':firstName,'semailId':email,'smobile':smobile,'isActive':isActive};
	let url = "userAjax.jsp?flag=searchUser";
	 $.ajax({
		 data:params,
		 url: url,
	     type:"post",
	     success:function(data){
	    	
	    	 if(data != null){
	    		 $("#serach__Result").empty();
	    		 $("#serach__Result").append(data);
	    	 }
	     }
		 
	 });
});
	 
	 $(document).on("click","#login_btn",function(e){
			let username = $("#username").val();
			let userpass = $("#userpass").val();
			let usertype = $("#usertype").val();
			let params = {'username':username,'userpass':userpass,'usertype':usertype};
			let url = "adminAjax.jsp?flag=login";
			 $.ajax({
				 data:params,
				 url: url,
			     type:"post",
			     success:function(data){
			    	 if(data != null){
			    		 $("#error__for__login").empty();
			    		 $("#error__for__login").append(data);
			    	 }
			     }
			 });
	 });
