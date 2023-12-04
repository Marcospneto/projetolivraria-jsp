
function validarPerfil() {
	let perfil = frmUsuario.perfil.value
	
	if (perfil === "") {
		alert("Preencha o campo perfil")
		frmUsuario.perfil.focus()
		return false
	
	} else {
		console.log("Função validarPerfil chamada!");
		document.forms["frmUsuario"].submit()
	}
}