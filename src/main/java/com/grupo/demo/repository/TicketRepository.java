package com.grupo.demo.repository;

import com.grupo.demo.model.Ticket;
import com.grupo.demo.model.Categoria;
import com.grupo.demo.model.EstadoTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByUsuarioId(Integer usuarioId);

    // SELECT * FROM tickets WHERE asignado_id = ?
    List<Ticket> findByAsignadoId(Integer asignadoId);

    // SELECT * FROM tickets WHERE categoria = ?
    List<Ticket> findByCategoria(Categoria categoria);

    // SELECT * FROM tickets WHERE estado = ?
    List<Ticket> findByEstado(EstadoTicket estado);

    // SELECT * FROM tickets WHERE subcategoria_id = ?
    List<Ticket> findBySubcategoriaId(Integer subcategoriaId);
}
