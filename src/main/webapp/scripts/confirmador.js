/**
 * Confirmação de exclusão de um contato
 */

function confirmar(id){
	let resposta = confirm ("Confirma a exclusão deste livro? ")
	if (resposta === true) {
		//alert (id)
		window.location.href = "delete?id=" + id
	}
}