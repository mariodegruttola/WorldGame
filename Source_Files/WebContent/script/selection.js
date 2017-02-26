function controlSelSped(){
	var s = document.sceltaSp.sceltaSped;
	if(s.value == ""){
		alert("Seleziona un tipo di spedizione")
		return false;
	}
	else {
		return true;
	}
}

function controlSelPag(){
	var s = document.sceltaPa.sceltaPaga;
	if(s.value == ""){
		alert("Seleziona un tipo di pagamento")
		return false;
	}
	else {
		return true;
	}
}