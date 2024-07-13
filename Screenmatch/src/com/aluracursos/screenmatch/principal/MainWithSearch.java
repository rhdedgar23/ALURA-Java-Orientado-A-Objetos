package com.aluracursos.screenmatch.principal;

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

        System.out.println(response.body());
    }
}
