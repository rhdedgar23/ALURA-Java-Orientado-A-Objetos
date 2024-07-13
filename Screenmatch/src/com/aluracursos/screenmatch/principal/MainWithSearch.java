package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.excepciones.DuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el nombre de la pelicula que buscas: ");
        var busqueda = scanner.nextLine();
        String direccion = "https://www.omdbapi.com/?t=" + busqueda + "&apikey=5f5d4d86";

        try{
        //Usamos un modelo cliente-servidor
        //Necesitamos un cliente para hacer un request.
        HttpClient client = HttpClient.newHttpClient();
        //El request es lo que le solicitas al servidor.
        //Para el request usamos un patron de diseño llamado Builder.
        //
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        //El response es lo que vamos a recibir.
        //Hace uso del client.send()
        //client.send manda nuestro objeto request como primer parametro
        //y el body handler como segundo parametro.
        //Body handler interpreta el mensaje que vamos a recibir.
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(response.body());

        //Gson es un serializador/deserializador para archivos JSON
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//Gson reconoce las variables en minusculas
                //y las convierte en camel case
                //En este caso, nuestras variables en minusculas se encuentran en el Record TituloOmdb.java
                .create();
        //Titulo miTitulo = gson.fromJson(json, Titulo.class);
        //miTitulo.imprimeNombreFechaLanzamiento();
        TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(miTituloOmdb);

        //Para pasar los valores del archivo JSON a nuestra propia instancia de Titulo,
        //creamos un constructor especial

            Titulo miTitulo = new Titulo(miTituloOmdb);
            miTitulo.imprimeTitulo();
        }
        catch(NumberFormatException e){
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println("Error en la URI, verifique la direccion.");
        }
        catch(DuracionException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("Ocurrio un error inesperado!!");
        }
        System.out.println("Fin de programa!");
        //Un error sucede cuando sucede algo fuera de nuestro alcance,
        //como cuando se acaba la memoria.
        //Una excepcion es algo que nosotros podemos prevenir.
    }
}
