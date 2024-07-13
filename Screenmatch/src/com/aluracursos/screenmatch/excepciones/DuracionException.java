package com.aluracursos.screenmatch.excepciones;

//Cuando nuestra excepcion extiende Throwable,
//se crea una excepcion de tipo Checkable,
//lo cual obliga a nuestra clase que lanza la excepcion a implementar un throws
//Sin embargo, si extendemos de RuntimeException,
//la excepcion se convierte en no-checkeable,
//lo cual NO obliga a nuestra clase que lanza la excepcion a implementar un throws.
public class DuracionException extends RuntimeException {

    private String mensaje;

    public DuracionException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
