var stars = document.querySelectorAll('.star-icon');
var container = document.querySelector('.avaliacao');
var selectedStar = null;

container.addEventListener('mouseover', function (e) {
    var hoveredStar = e.target;

    if (hoveredStar.classList.contains('star-icon')) {
        var index = Array.from(stars).indexOf(hoveredStar);

        for (var i = 0; i <= index; i++) {
            stars[i].classList.add('ativo');
        }
    }
});

container.addEventListener('mouseout', function (e) {
    if (!selectedStar) {
        stars.forEach(function (star) {
            star.classList.remove('ativo');
        });
    }
});

container.addEventListener('click', function (e) {
    var clickedStar = e.target;

    if (clickedStar.classList.contains('star-icon')) {
        selectedStar = clickedStar;

        stars.forEach(function (star) {
            star.classList.remove('ativo');
        });

        var index = Array.from(stars).indexOf(clickedStar);

        for (var i = 0; i <= index; i++) {
            stars[i].classList.add('ativo');
        }

        // Atualiza o valor da nota no campo escondido
        document.getElementById('nota').value = index + 1;
    }
});

function validarAvaliacao() {
    // Se alguma estrela foi selecionada, enviar a avaliação
    const nota = document.getElementById('nota').value;
    if (nota > 0) {
        document.forms["frmAvaliacao"].submit();
    } else {
        alert("Por favor, selecione uma avaliação.");
    }
}
