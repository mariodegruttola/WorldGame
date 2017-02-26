function valChProd(){

	var nm = document.inserimentoProd.Nome.value;
	var pr = document.inserimentoProd.Prezzo.value;
	var qn = document.inserimentoProd.Quantita.value;
	var ds = document.inserimentoProd.Descrizione.value;
	
	if(ValNome(nm)){
		if(ValPrezzo(pr)){
			if(ValQuantita(qn)){
				if(ValDescrizione(ds)){
					return true;
				}
			}
		}
	}
	return false;
}

function valModProdPrezzo(){

	var pr = $("#upPrezzo").val();
	
	if(ValPrezzo(pr)){
		return true;
	}
	else{
		return false;
	}
}

function valModProdQuantita(){
	
	var pr = $("#upPrezzo").val();

	if(ValQuantita(qn)){
		return true;
	}
	return false;
}

function ValNome(nm){

	if(nm === ""){
		alert("Inserisci Nome Prodotto");
		return false;
	}
	else {
		return true;
	}
}

function ValPrezzo(pr){
	
	var pattern = /^[0-9]{0,3}(\.[0-9]{0,2})?$/;

	if(pr.match(pattern) && pr != ""){
		return true;
	}
	else {
		alert("Inserire prezzo valido. Es 142.00");
		return false;
	}
}

function ValQuantita(cs){
	
	var numbers = /^[0-9]+$/;
	
		if(cs.match(numbers))
		{
			return true;
		}
		else
		{
			alert("Quantita' puo contenere solo caratteri numerici");
			return false;
		}
	
}

function ValDescrizione(ds){
	
	if(ds === ""){
		alert("Inserisci Descrizione Prodotto");
		return false;
	}
	else {
		return true;
	}
}

function valQuantitaProdottoCarrello(){
	var quantita = document.carrelloQuantita.quantita.value;
	var numbers = /^[0-9]+$/;
	
	if(quantita.match(numbers)) 
	{
		return true
	}
	else
	{
		alert("Inserire un numero, maggiore o uguale a zero, per indicare la quantita del prodotto");
		return false;
	}
}