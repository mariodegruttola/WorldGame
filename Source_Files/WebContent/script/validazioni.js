function validaReg()
{
var uemail = document.registration.Email;
var passid = document.registration.Password;
var ucodf = document.registration.CodFisc;
var uname = document.registration.Nome;
var ucogn = document.registration.Cognome;
var uadd = document.registration.Indirizzo;
var utel = document.registration.Telefono;
var ucit = document.registration.Citta;
var uzip = document.registration.CAP;
var uprov = document.registration.Provincia;
var scadCarta = document.registration.ScadenzaCarta;
var numCarta = document.registration.NumeroCarta;
var pinCarta = document.registration.PinCarta;

if(validaNumeroCarta(numCarta)){
	if(validaPinCarta(pinCarta)){
		if(validateEmail(uemail)){
			if(passid_validation(passid,7,12)){
				if(codicefiscale(ucodf)){
					if(campoObbligatorio(uname)){ 
						if(campoObbligatorio(ucogn)){
							if(campoObbligatorio(uadd)){
								if(phonenumber(utel)){
									if(campoObbligatorio(ucit)){
										if(allnumeric(uzip)){
											if(campoObbligatorio(uprov)){
												if(validateDate(scadCarta)){
													return true;
												} else { alert('Inserire una data nel formato yyyy-mm-dd'); }
											} else { alert('Il campo Provincia è obbligatorio'); }
										}
									} else { alert('Il campo Città è obbligatorio'); }
								}
							} else { alert('Il campo Indirizzo è obbligatorio'); }
						} else { alert('Il campo Cognome è obbligatorio'); }
					} else { alert('Il campo Nome è obbligatorio'); }
				}
			}
		}
	}
}
return false;
}

function validaLog(){
	var uemail = document.log.Email;
	var upass = document.log.Password;
	
	if(ValidateEmail(uemail)){
		if(passid_validation(upass, 7, 12)){
			return true;
		}
	}
	return false;
}

function validaNumeroCarta(x){
	var pat = /^\d{16}$/;
	if(x.value.match(pat)) {
		return true;
	}
	else {
		alert("Numero carta di credito non valido");
		x.focus();
		return false;
	}
}

function validaPinCarta(x){
	var pat = /^\d{3}$/;
	if(x.value.match(pat)) {
		return true;
	}
	else {
		alert("Pin carta di credito non valido");
		x.focus();
		return false;
	}
}

function codicefiscale(cod){
	var pattern = /^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$/;
	if(cod.value.match(pattern)){
		return true;
	}
	else {
	    alert("Il valore inserito non è un codice fiscale!");
	    cod.focus();
		return false;
	}
}

function phonenumber(inputtxt) {
	var phoneno = /^\d{10}$/;
	if(inputtxt.value.match(phoneno)) {
		return true;
	}
	else {
		alert("Numero di telefono non valido");
		inputtxt.focus();
		return false;
	}
}

function passid_validation(passid,mx,my) {
	var passid_len = passid.value.length;
	if (passid_len == 0 ||passid_len >= my || passid_len < mx) {
		alert("Lunghezza della password copresa tra "+mx+" e "+my);
		passid.focus();
		return false;
	}
	return true;
}

function allnumeric(uzip) {
	var numbers = /^[0-9]+$/;
	if(uzip.value.match(numbers)) {
		return true;
	}
	else {
		alert('CAP puo contenere solo caratteri numerici');
		uzip.focus();
		return false;
	}
}

function validateEmail(uemail) {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(uemail.value.match(mailformat)) {
		return true;
	}
	else {
		alert("Hai inserito un email non valida!");
		uemail.focus();
		return false;
	}
}

function campoObbligatorio(x) {
	
	if ((x.value == "") || (x.value == "undefined")) {
		   x.focus();
		   return false;
		}
	else {
		return true;
	}
}
function validateDate(data) {
	  var regEx = /^\d{4}-\d{2}-\d{2}$/;
	  dateString = data.value;

	  if(!dateString.match(regEx))
	    return false;  // Invalid format 

	  var parms = dateString.split(/[\.\-\/]/);
	  var dd = parseInt(parms[2],10);
	  var mm   = parseInt(parms[1],10);
	  var yyyy   = parseInt(parms[0],10);

	  var newDate = new Date();
	  var presentDate = newDate.getDate();
	  var presentMonth = newDate.getMonth();
	  var presentYear = newDate.getFullYear();
	     
	  if ((mm < 1) || (mm > 12)) 
	    {
	        alert('Data non valida');
	    return false;
	        }
	    else if ((dd < 1) || (dd> 31)) 
	    {
	        alert('Data non valida')
	    return false;
	        }
	    else if ((mm==4 || mm==6 || mm==9 || mm==11) && dd ==31) 
	    {
	        alert('Data non valida')
	    return false;
	        }
	    else if (mm == 2){ 
	    var isleap = (yyyy % 4 == 0 && (yyyy % 100 != 0 || yyyy % 400 == 0));
	    if (dd> 29 || (dd ==29 && !isleap)) 
	    {
	        alert('Data non valida')
	    return false;
	        }
	    }
	    else if((yy>presentYear)||(yy+70<presentYear))
	        {
	        alert('Data non valida')
	        return false;
	        }
	    else if(yy==presentYear)
	        {
	        if(mm>presentMonth+1)
	            {
	            alert('Data non valida')
	            return false;
	            }
	        else if(mm==presentMonth+1)
	            {
	            if(dd>presentDate)
	                {
	                alert('Data non valida')
	                return false;
	                }
	            }
	        }
	  	return true;
}