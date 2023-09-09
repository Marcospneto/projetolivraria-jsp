function validar() {
	let titulo = frmLivro.titulo.value
	let genero = frmLivro.genero.value
	let quantidadePaginas = frmLivro.quantidadePaginas.value
	if (titulo === "") {
		alert("Preencha o campo titulo")
		frmLivro.titulo.focus()
		return false
	} else if (genero === "") {
		alert("Preencha o campo genero")
		frmLivro.genero.focus()
		return false
	} else if (quantidadePaginas === "") {
		alert("Preencha o campo quantidadePaginas")
		frmLivro.quantidadePaginas.focus()
		return false
	} else {
		document.forms["frmLivro"].submit()
	}
}