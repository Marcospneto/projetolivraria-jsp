function validarPerfil() {
	let perfil = frmAlterarPerfil.perfil.value
	
	
	if (perfil === "") {
		alert("Preencha o campo perfil")
		frmAlterarPerfil.perfil.focus()
		return false
	
	} else {
		document.forms["frmAlterarPerfil"].submit()
	}
}