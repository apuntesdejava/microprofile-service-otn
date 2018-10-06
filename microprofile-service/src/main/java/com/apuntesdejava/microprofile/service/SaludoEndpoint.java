package com.apuntesdejava.microprofile.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Diego Silva <diego.silva@apuntesdejava.com>
 */
@Path("saludo")
public class SaludoEndpoint {

    @GET
    public String saludar(@QueryParam("nombre") String nombre) {
        return "Hola " + nombre;
    }
}
