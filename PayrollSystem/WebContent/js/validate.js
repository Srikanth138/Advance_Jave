//validate.js
function validate() {
	//alert("client side executed");
	
	document.getElementById("pname").innerHTML="";
	document.getElementById("pid").innerHTML="";
	
	let name=frm.name.value; //form name & attribute name & value
	let id=frm.id.value;
	let flag=true;
	
	if(name==""){
		document.getElementById("pname").innerHTML="person name is requierd";
		frm.name.focus(); //blink the cruser this name text box
		flag=false;
	}
	else if(name.length<2){
		document.getElementById("pname").innerHTML="person name must 3 Charecters";
		frm.name.focus();
		flag=false;
	}
	
	if(id==""){
		document.getElementById("pid").innerHTML="person id is requierd";
		frm.age.focus();
		flag=false;
	}
	else if(isNaN(id)){ //isNaN() NaN Not A Number -> means number or not checking
		document.getElementById("pid").innerHTML="person id is not a number";
		frm.age.focus();
		flag=false;
	}
	else if(id<1 || id>125){
		document.getElementById("pid").innerHTML="person id must 1 to 125";
		frm.age.focus();
		flag=false;
	}
	
	frm.vflag.value="yes";
	return flag;
}