/**
 * 
 */

$(document).on("click","#search_btn",function(e){
	let productName = $("#productName").val();
	let productSku = $("#productSku").val();
	let subcatrfnum = $("#subcatrfnum").val();
	let isActive = $("#isActive").val();
	let params = {'productName':productName,'productSku':productSku,'subcatrfnum':subcatrfnum,'isActive':isActive};
	let url = "productAjax.jsp?flag=searchProduct";
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
	 