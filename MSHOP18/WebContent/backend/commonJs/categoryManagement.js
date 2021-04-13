$(document).ready(function(){
		
	});

$(document).on("click","#categorysearchbtn",function(e){
	let catrfnum = $("#catrfnum").val();
	let catname = $("#catname").val();
	let isActive = $("#isActive").val();
	let params = {'catrfnum':catrfnum,'catname':catname,'isActive':isActive};
	let url = "ajax.jsp?flag=catList";
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

$(document).on("click","#subcategorysearchbtn",function(e){
	let catrfnum = $("#catrfnum").val();
	let catname = $("#catname").val();
	let isActive = $("#isActive").val();
	let params = {'catrfnum':catrfnum,'catname':catname,'isActive':isActive};
	let url = "ajax.jsp?flag=subcatList";
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