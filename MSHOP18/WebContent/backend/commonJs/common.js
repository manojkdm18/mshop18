/**
 * 
 */

$(document).ready(function(e){
	
});
	
 function checkAllFiled(){
	 let req = $(".compulsory");

	 for(let i=0;i<req.length;i++){
		 if(req[i].value==""){
			 $(req[i]).next().html("This filed is reqiured.");
			 $(req[i]).next().css({'color':'red','font-size':'14px'});
			 $(req[i]).next().show();
			 return false;
		 }else{
			 removeClass(req[i]);
		 }
	 }
 }
function removeClass(filed){
		 if(filed.value !=""){
			 $(filed).next().hide();
		 }
}

$(document).ready(function() {
	$('.mdb-select').materialSelect();
	});