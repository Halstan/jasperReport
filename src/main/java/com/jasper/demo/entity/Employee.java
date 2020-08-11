package com.jasper.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "empleados")
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Id_empleado")
    private Integer Id_empleado;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "Tratamiento")
    private String tratamiento;

    @Temporal(TemporalType.DATE)
    @Column (name = "Fecha_nacimiento")
    private Date fecha_nacimiento;

    @Temporal(TemporalType.DATE)
    @Column (name = "Fecha_contratacion")
    private Date fecha_contratacion;

    @Column(name = "direccion")
    private String direccion;
}
