
 function addToCart(e){
	 let id = e.id;
		console.log(id);
		let psku = $('#psku_'+id).val();
		console.log(psku);
	let URL = $("#url").val();
	let params = {'psku':psku};
	let url = URL+"/ajax.jsp?flag=addToCart";
	 $.ajax({
		 data:params,
		 url: url,
	     type:"post",
	     success:function(data){
	    	 let resp = data.trim();
	    	 if(resp != null){
	    		if(resp == "ADDED"){
	    			alert("Item added to Cart Successfully.");
	    		}else if(resp == "NOTADDED"){
	    			alert("Item Already Present..");
	    		}else{
	    			alert("cannot added.")
	    		}
	    		 location.reload();
	    	 }
	     }
		 
	 });

}

function deleteItem(e){
	let id = e.id;
	console.log(id);
	let psku = $('#psku_'+id).val();
	console.log(psku);
	let URL = $("#url").val();
	let params = {'psku':psku};
	let url = URL+"/ajax.jsp?flag=deleteItem";
	 $.ajax({
		 data:params,
		 url: url,
	     type:"post",
	     success:function(data){
	    	 let resp = data;
	    	 if(resp != null){
	    		 console.log(resp)
	    		 $("#cart__data").empty().append(resp);
	    	 }
	     }
		 
	 });

}

function updateCart(e){
	let id = e.id;
	console.log(id);
	let psku = $('#psku_'+id).val();
	console.log(psku);
	let qty = $(".qty_"+id).val();
	let URL = $("#url").val();
	let params = {'psku':psku,"qty":qty};
	let url = URL+"/ajax.jsp?flag=updateCart";
	 $.ajax({
		 data:params,
		 url: url,
	     type:"post",
	     success:function(data){
	    	 let resp = data;
	    	 if(resp != null){
	    		 console.log(resp)
	    		 $("#cart__data").empty().append(resp);
	    	 }
	     }
		 
	 });

}
$(document).on("click",'.crossbtn',function(e){
	location.reload();
});

$(document).on("click",".mspimages",function(e){
	let id = this.id;
	let subImg = this.src;
	let mainImg = $('#myimage').attr('src');
	if(subImg != null && subImg != undefined){
	$("#myimage").attr("src", subImg);	
	}
	if(mainImg != null && mainImg != undefined){
		$(id).attr("src", mainImg);	
	}

});
