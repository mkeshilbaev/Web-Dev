function test(){
	var arr = document.getElementsByName("input");
	var text = "";
	for (var i = 0; i < arr.length; i++){
	     text += arr[i].value;
	}
	var mydiv = document.getElementById("mydiv");
	mydiv.innerHTML = text;
}



