package com.dinozoopark.web.controller;

import com.dinozoopark.web.model.Faq;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/faq")
public class FaqController {

        private final List<Faq> faqs = new ArrayList<>(Arrays.asList(
                        new Faq(1L, "¿Cuál es el horario del parque?",
                                        "DinoZoo Park está abierto de lunes a viernes de 9:00 AM a 6:00 PM, y sábados y domingos de 8:00 AM a 8:00 PM. Los días festivos tenemos horario especial."),
                        new Faq(2L, "¿Es seguro visitar el parque?",
                                        "Absolutamente. Contamos con sistemas de seguridad de última generación, cercas eléctricas de 10,000 voltios, y personal de seguridad altamente capacitado. Todos nuestros dinosaurios están monitoreados 24/7."),
                        new Faq(3L, "¿Cuánto cuesta la entrada?",
                                        "Adultos: $50, Niños (4-12 años): $30, Estudiantes con credencial: $40, Menores de 4 años: Gratis. Ofrecemos paquetes familiares y descuentos para grupos."),
                        new Faq(4L, "¿Puedo alimentar a los dinosaurios?",
                                        "Solo en las zonas designadas y bajo supervisión de nuestros cuidadores. Ofrecemos experiencias de alimentación programadas para herbívoros como Triceratops y Brachiosaurus."),
                        new Faq(5L, "¿Qué debo hacer en caso de emergencia?",
                                        "Siga las instrucciones del personal de seguridad inmediatamente. Diríjase a los refugios de emergencia señalizados. NO intente correr o hacer movimientos bruscos cerca de los dinosaurios."),
                        new Faq(6L, "¿Hay restricciones de edad?",
                                        "Los niños menores de 12 años deben estar acompañados por un adulto en todo momento. Algunas atracciones tienen restricciones de altura por seguridad."),
                        new Faq(7L, "¿Puedo tomar fotografías?",
                                        "Sí, se permiten fotografías y videos para uso personal. No se permite el uso de flash cerca de los dinosaurios carnívoros, ya que puede alterarlos."),
                        new Faq(8L, "¿Qué pasa si llueve?",
                                        "El parque permanece abierto bajo lluvia ligera. En caso de tormentas eléctricas, algunas áreas pueden cerrarse temporalmente por seguridad. Los boletos son válidos para otra fecha."),
                        new Faq(9L, "¿Hay restaurantes en el parque?",
                                        "Sí, contamos con 3 restaurantes temáticos, 5 cafeterías y múltiples puestos de comida. Ofrecemos opciones vegetarianas, veganas y sin gluten."),
                        new Faq(10L, "¿Puedo comprar souvenirs?",
                                        "Tenemos 4 tiendas de regalos con mercancía exclusiva de DinoZoo Park, incluyendo réplicas de fósiles, peluches, ropa y libros educativos.")));

        @GetMapping
        public List<Faq> obtenerTodas() {
                return faqs;
        }

        @GetMapping("/{id}")
        public Faq obtenerPorId(@PathVariable Long id) {
                return faqs.stream()
                                .filter(f -> f.getId().equals(id))
                                .findFirst()
                                .orElse(null);
        }
}
