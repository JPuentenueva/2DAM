$(function(){
	var $write = $('#write'),
		shift = false,
		capslock = false;

	//Al pulsar la tecla
	$('textarea').keypress(function(){
		var teclasLetra = $('#keyboard li.letter');
		var teclasSimbolo = $('#keyboard li.symbol span');
		var teclaLetraPulsada = String.fromCharCode(event.which);
		var teclaSimboloPulsada = String.fromCharCode(event.which);

		$("#ver").text(event.charCode);

		teclasLetra.each(function() {
			letraActual = $(this);

			if(teclaLetraPulsada == letraActual.text()) {
				letraActual.attr("style", "background-color: grey;");
			}
		});

		teclasSimbolo.each(function() {
				simboloActual = $(this);

				if (teclaSimboloPulsada == simboloActual.text()) {
					var idPadre = simboloActual.closest("li").attr("id");
					var elementoPadre = $("#"+idPadre);
					elementoPadre.attr("style", "background-color: grey;");
				}

				/*if (shift === true) {
					if(teclaSimboloPulsada == simboloActual[1].text()) {
						$(this).attr("style", "background-color: grey;");
					}
				} else {
					if(teclaSimboloPulsada == simboloActual.text()) {
						$(this).attr("style", "background-color: grey;");
					}
				}*/

		});

	});

	//Al levantar la tecla
	$('textarea').keyup(function(){
		var teclas = $('#keyboard li').attr("style", "background-color: white;");
	});

	$('#keyboard li').click(function(){
		var $this = $(this),
			character = $this.html(); // If it's a lowercase letter, nothing happens to this variable

		// Shift keys
		if ($this.hasClass('left-shift') || $this.hasClass('right-shift')) {
			$('.letter').toggleClass('uppercase');
			$('.symbol span').toggle();

			shift = (shift === true) ? false : true;
			capslock = false;
			return false;
		}

		// Caps lock
		if ($this.hasClass('capslock')) {
			$('.letter').toggleClass('uppercase');
			capslock = true;
			return false;
		}

		// Delete
		if ($this.hasClass('delete')) {
			var html = $write.html();

			$write.html(html.substr(0, html.length - 1));
			return false;
		}

		// Special characters
		if ($this.hasClass('symbol')) character = $('span:visible', $this).html();
		if ($this.hasClass('space')) character = ' ';
		if ($this.hasClass('tab')) character = "\t";
		if ($this.hasClass('return')) character = "\n";

		// Uppercase letter
		if ($this.hasClass('uppercase')) character = character.toUpperCase();

		// Remove shift once a key is clicked.
		if (shift === true) {
			$('.symbol span').toggle();
			if (capslock === false) $('.letter').toggleClass('uppercase');

			shift = false;
		}

		// Add the character
		$write.html($write.html() + character);
	});
});
