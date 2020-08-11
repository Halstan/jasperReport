package com.jasper.demo.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @Column(name = "id_pedido")
    private Integer id_pedido;

    @Column(name = "id_cliente")
    private String id_cliente;

    @Column(name = "id_empleado")
    private Integer id_empleado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pedido")
    private Date fecha_pedido;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega")
    private Date fecha_entrega;

    @Column(name = "forma_envio")
    private Integer forma_envio;

}
