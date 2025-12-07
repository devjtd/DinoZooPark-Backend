package com.dinozoopark.web.controller;

import com.dinozoopark.web.model.FormularioContacto;
import com.dinozoopark.web.model.MensajeRespuesta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacto")
public class ContactoController {

    @PostMapping("/enviar")
    public ResponseEntity<MensajeRespuesta> enviarMensaje(@RequestBody FormularioContacto formulario) {

        System.out.println("=== MENSAJE DE CONTACTO RECIBIDO ===");
        System.out.println("Nombre: " + formulario.getNombre());
        System.out.println("Email: " + formulario.getEmail());
        System.out.println("Dinosaurio Favorito: " + formulario.getDinosaurioFavorito());
        System.out.println("Mensaje: " + formulario.getMensaje());
        System.out.println("=====================================");

        MensajeRespuesta respuesta = new MensajeRespuesta(
                "¡Mensaje recibido correctamente! El Centro de Control ha sido notificado.",
                true);

        return ResponseEntity.ok(respuesta);
    }
}
