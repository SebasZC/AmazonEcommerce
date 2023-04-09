package com.Amazon.ecommerce.Modelos;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    @Id
    @SequenceGenerator(
            name = "producto_sequence",
            sequenceName = "producto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "producto_sequence"
    )
    @Column(name = "producto_id")
    private Integer productoId;

    //private static int contadorProductos = 0;  //=> static -> atributo que le pertenece a la CLASE, no al OBJETO

    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String nombre;

    @Column(nullable = false, columnDefinition = "DOUBLE")
    private Double precio;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private Boolean disponible;

    @Column(nullable = false, columnDefinition = "VARCHAR(300)")
    private String foto;

    @Column(name = "foto_catalogo", nullable = false, columnDefinition = "VARCHAR(300)")
    private String fotoCatalogo;

    @Column(nullable = false, columnDefinition = "DOUBLE")
    private double calificacion;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "producto")
    private List<Comentario> comentarios;



    @Override
    public String toString() {
        return "Producto{" +
                "productoId=" + productoId +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", foto='" + foto + '\'' +
                ", fotoCatalogo='" + fotoCatalogo + '\'' +
                ", calificacion=" + calificacion +
                ", comentarios=" + comentarios +
                '}';
    }

//    public void getCalificacion(){
//        this.calificacion = 0.0;
//    }
//
//    public void addComentario(Comentario comentario){
//        if(this.comentarios == null){
//            this.comentarios = new ArrayList<>();
//        }
//        this.comentarios.add(comentario);
//    }


}
