
function validar() {
	let titulo = frmLivro.titulo.value
	let genero = frmLivro.genero.value
	let quantidadePaginas = frmLivro.quantidadePaginas.value
	let isbn = frmLivro.isbn.value
	let sinopse = frmLivro.sinopse.value
	let autor = frmLivro.autor.value
	
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
	} else if (isbn === "") {
		alert("Preencha o campo Isbn")
		frmLivro.isbn.focus()
		return false
	} else if (sinopse === "") {
		alert("Preencha o campo Sinopse")
		frmLivro.sinopse.focus()
		return false
	} else if (autor === "") {
		alert("Preencha o campo autor")
		frmLivro.autor.focus()
		return false
	} else {
		document.forms["frmLivro"].submit()
	}
}