function validarLogin() {
	let login = frmUsuario.login.value
	let senha = frmUsuario.senha.value
	let loginError = document.getElementById("login-error");
    let senhaError = document.getElementById("senha-error");

	loginError.textContent = "";
    senhaError.textContent = "";

	  if (login === "") {
        loginError.textContent = "Preencha o campo login";
        frmUsuario.login.focus();
        return false;
    } else if (senha === "") {
        senhaError.textContent = "Preencha o campo senha";
        frmUsuario.senha.focus();
        return false;
    } else if (senha.length < 8) {
        senhaError.textContent = "A senha deve ter pelo menos 8 caracteres";
        frmUsuario.senha.focus();
        return false;
    } else {
        document.forms["frmUsuario"].submit();
    }
}


 
function validarIndex() {
	let login = frmUsuario.login.value
	let senha = frmUsuario.senha.value
	let loginError = document.getElementById("login-error");
    let senhaError = document.getElementById("senha-error");
	let mensagemError = document.getElementById("mensagem-error");
	
	loginError.textContent = "";
    senhaError.textContent = "";
	mensagemError.textContent = "";

	  if (login === "") {
        loginError.textContent = "Preencha o campo login";
        frmUsuario.login.focus();
        return false;
    } else if (senha === "") {
        senhaError.textContent = "Preencha o campo senha";
        frmUsuario.senha.focus();
        return false;
   // } else if (senha.length < 8) {
      //  senhaError.textContent = "A senha deve ter pelo menos 8 caracteres";
      //  frmUsuario.senha.focus();
      //  return false;
    } else if (mensagemError.textContent.trim() !== "") {
		 alert("Conta inválida!");
	} else {
        document.forms["frmUsuario"].submit();
    }
}