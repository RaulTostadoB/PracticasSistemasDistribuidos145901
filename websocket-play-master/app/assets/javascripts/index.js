
$(function() {
	var speech = ["Bienvenidos a la Aplicación","Hoy es un buen día",
              "No es cierto esta nublado","Yo creo que no",
              "Es lo de menos",
              "OK",
              "Sale nos Vemos",
              "Homero Simpson",
              "Es amarillo"];
var contador = 0;
		var ws;
	ws = new WebSocket($("body").data("ws-url")); //Se toma La URL del Tag en Body
	ws.onmessage = function(event) {
	var message;
	message = JSON.parse(event.data);
		switch (message.type) {
		case "message":
		return $("#board tbody").append("<tr><td>"+ message.msg + "</td></tr>");
		default:
		
		
      return console.log(message);
  }
};

$("#msgform").submit(function(event) {
  event.preventDefault();
  console.log($("#msgtext").val());
  ws.send(JSON.stringify({ //Enviar el mensaje en el formulario como JSON.
    msg: $("#msgtext").val()
  }));
  return $("#msgtext").val("");
});

window.setInterval(function(){
	
	ws.send(JSON.stringify({ //Enviar el mensaje en el formulario como JSON.
    msg: speech[contador]
  }));
  contador = contador + 1;
  return $("#msgtext").val("");	
}, 4000); // Tiempo en milisegundos


	
});
