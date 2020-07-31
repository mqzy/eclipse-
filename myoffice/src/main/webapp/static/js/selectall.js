// JavaScript Document
function selectall(){
	var input=form2.getElementsByTagName("input");
	for(var i=0;i<input.length;i++){
		if(input[i].type=="checkbox"){
			if(input[i].name=="selectAll"){
				continue;
			} else {
				input[i].checked=true;
			}
		}
	}
}
function opposite(){ 
	var input=form2.getElementsByTagName("input");
	for(var i=0;i<input.length;i++){
		if(input[i].type=="checkbox"){
			if(input[i].name!="selectAll"){
				input[i].checked=!input[i].checked;
			}
		}
	}
}
function selectf(){
	var input=form2.getElementsByTagName("input");
	for(var i=0;i<input.length;i++){
		if(input[i].type=="checkbox"){
			if(input[i].name=="selectAll"){
				continue;
			} else {
				input[i].checked=false;
			}
		}
	}
}