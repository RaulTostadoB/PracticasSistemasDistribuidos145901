package controllers;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.api.libs.json.*;
import play.*;
import play.mvc.*;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.HashMap;

import views.html.*;



public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Hola Mundo, servicios web !!!"));
    }

    /*
* El siguiente método hace una multiplicación de enteros.
* @param a el primer  entero.
* @param b el segundo entero.
* @return Resultado en formato Json.
*/
    public static Result getMultiplicacion(int a, int b){
        ObjectNode result = Json.newObject();
        result.put("resultado", a*b );
        return ok(result);
    }

    /*
* El siguiente método verifica si una cadena es un palíndromo.
* @param word la palabra a validar.
* @return true o false en formato Json.
*/
    public static Result getPalindromo(String word){
        ObjectNode result = Json.newObject();
        String myWord = word.replaceAll("\\s+","");
        String reverse = new StringBuffer(myWord).reverse().toString();
        result.put("resultado", reverse.equalsIgnoreCase(myWord));
        return ok(result);
    }
    //Convertir dolares a pesos
    public static Result getDolaresaPesos(int a){
        ObjectNode result = Json.newObject();
        int b = 15;
        result.put("resultado", a*b );
        return ok(result);
    }
    //Convertir grador farenheit a centigrados
    public static Result getCentigrados(double a){
        ObjectNode result = Json.newObject();
        result.put("resultado", (a-32)/1.8 );
        return ok(result);
    }

    public static Result getCapital(String a){
        Hashtable<String, String> hash = new Hashtable<>();
		ObjectNode result = Json.newObject();
		String capitalSolicitada;
		
		hash.put("Alemania", "Berlin");
		hash.put("Austria", "Vienna");
		hash.put("Belgica", "Bruselas");
		hash.put("Dinamarca", "Copenhage");
		hash.put("España", "Madrid");
		hash.put("Finlandia", "Helsinki");
		hash.put("Francia", "Paris");
		hash.put("Irlanda", "Dublin");
		hash.put("Italia", "Roma");
		hash.put("Holanda", "Amsterda");
		hash.put("Polonia", "Warsaw");
		hash.put("Portugal", "Lisboa");
		hash.put("Inglaterra", "Londres");
		
		
		capitalSolicitada = hash.get(a);
		
		result.put("Capital",capitalSolicitada);
		
		
	return ok(result);
    }//Fin Get capital
	
	public static Result getEmbajada(String a){
		
		
        String tabla;
		
        ObjectNode result = Json.newObject();
		Hashtable<String, String> embajada = new Hashtable<>();
		
		embajada.put("Alemania", "52.5077843,13.3517587");//52.5077843,13.3517587
		embajada.put("Austria", "48.1998585,16.3700744");
		embajada.put("Belgica", "50.8083158,4.3849209");
		embajada.put("Dinamarca", "55.6864627,12.5918263");
		embajada.put("España", "40.4160947,-3.6973632");
		embajada.put("Finlandia", "60.1685662,24.9351516");
		embajada.put("Francia", "48.8648275,2.292344");
		embajada.put("Irlanda", "53.3303151,-6.2387368");
		embajada.put("Italia", "41.9133032,12.5097257");
		embajada.put("Holanda", "52.0899761,4.3059916");
		embajada.put("Polonia", "52.22499,20.99128");
		embajada.put("Portugal", "38.7375761,-9.2019543");
		embajada.put("Inglaterra", "51.513845,-0.1422097");//51.513845,-0.1422097
		 
		tabla = embajada.get(a);
		
	
	
	result.put("Resultado", tabla);
	return ok(result);
    }//Fin Get capital
	
	

}
