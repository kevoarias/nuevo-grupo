package com.kevin.portalincidencias.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table (name = "Tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column (name = "estado",length = 250, nullable = false)
    private EstadoTicket estado = EstadoTicket.RECIBIDO;

    @Column (name = "descripcion",length = 250, nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria",nullable = false)
    private Categoria categoria;

    @Column(name = "fecha_creacion",nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion = LocalDateTime.now();

    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "asignado_id",length = 250)
    private Integer asignadoId;

    @Column(name = "subcategoria_id",nullable = false)
    private Integer subcategoriaId;

}
