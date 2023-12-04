function validarComentario() {
	 console.log("Função validarComentario chamada.");
	let comentario = frmComentario.comentario.value
	
	
	if (comentario === "") {
		alert("O campo comentario está vazio")
		frmComentario.comentario.focus()
		return false
	
	} else {
		document.forms["frmComentario"].submit()
	}
}