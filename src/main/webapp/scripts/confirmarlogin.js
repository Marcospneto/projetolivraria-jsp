function validar() {
	let login = frmUsuario.login.value
	let senha = frmUsuario.senha.value
	
	if (login === "") {
		alert("Preencha o campo login")
		frmUsuario.login.focus()
		return false
	} else if (senha === "") {
		alert("Preencha o campo senha")
		frmUsuario.senha.focus()
		return false
	} else {
		document.forms["frmUsuario"].submit()
	}
}