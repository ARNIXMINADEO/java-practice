package com.example.demo3.Entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_customers")
@AllArgsConstructor @NoArgsConstructor @Builder
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El numero de documento es obligatorio")
    @Size(min = 7, max = 7, message = "El rango de campo debe ser de 7 numeros")
    @Column(name = "number_id", unique = true,length = 7, nullable = false)
    private String numberId;

    @NotEmpty(message = "El nombre es obligatorio")
    @Size(min = 3, max = 30, message = "El rango de campo debe ser de 3 a 30 caracteres")
    @Column(name = "first_name", nullable = false)
    private String firstname;

    @NotEmpty(message = "El apellido es obligatorio")
    @Column(name = "last_name", nullable = false)
    private String lastname;

    @NotEmpty(message = "El email es obligatorio")
    @Email(message = "La direccion no es correcta o esta mal formateada")
    @Column(unique = true,nullable = false)
    private String email;

    @Column(name = "photo_url")
    private String photoUrl;

    @Valid
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @NotNull(message = "La region es obligatoria")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    private String state;
}
