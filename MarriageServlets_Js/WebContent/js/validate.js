function validate() {
	//alert("client side executed");
	
	document.getElementById("pname").innerHTML="";
	document.getElementById("page").innerHTML="";
	
	let name=frm.name.value; //form name & attribute name & value
	let age=frm.age.value;
	let flag=true;
	
	if(name==""){
		document.getElementById("pname").innerHTML="person name is requierd";
		frm.name.focus();
		flag=false;
	}
	else if(name.length<5){
		document.getElementById("pname").innerHTML="person name must 5 Charecters";
		frm.name.focus();
		flag=false;
	}
	
	if(age==""){
		document.getElementById("page").innerHTML="person age is requierd";
		frm.age.focus();
		flag=false;
	}
	else if(isNaN(age)){ //isNaN() -> means number or not checking
		document.getElementById("page").innerHTML="person age is not a number";
		frm.age.focus();
		flag=false;
	}
	else if(age<1 || age>125){
		document.getElementById("page").innerHTML="person age must 1 to 125";
		frm.age.focus();
		flag=false;
	}
	
	frm.vflag.value="yes";
	return flag;
}