/**
 * 
 */

$(document).ready(function(e){
	let url = "adminAjax.jsp?flag=dashboardDetails";
	 $.ajax({
		 url: url,
	     type:"get",
	     success:function(resp){
	    		if(resp != null){
	    			$("#dashboard_data").empty().append(resp);
	    		}
	     }
	 });
});