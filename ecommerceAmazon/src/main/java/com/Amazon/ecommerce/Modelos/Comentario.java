package com.Amazon.ecommerce.Modelos;

import com.Amazon.ecommerce.Servicios.FuncionesValidacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "comentario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comentario {

    @Id
    @SequenceGenerator(
            name = "comentario_sequence",
            sequenceName = "comentario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comentario_sequence"
    )
    @Column(name = "comentario_id")
    private Integer comentarioId;

    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String usuario;

    @Column(nullable = false, columnDefinition = "TEXT")//0:48:59
    private String contenido;

    @Column(nullable = false, columnDefinition = "DOUBLE")
    private double calificacion;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "producto_id",
            referencedColumnName = "producto_id",
            nullable = false
    )
    private Producto producto;

    public Comentario(String usuario, String contenido, double calificacion) {
        FuncionesValidacion.validarCalificacion(calificacion);
        this.usuario = usuario;
        this.contenido = contenido;
        this.calificacion = calificacion;
    }


}
