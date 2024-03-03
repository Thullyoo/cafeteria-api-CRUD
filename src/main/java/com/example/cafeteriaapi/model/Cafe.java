package com.example.cafeteriaapi.model;


import com.example.cafeteriaapi.DTO.RequestCafe;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "cafe")
@Entity(name = "cafe")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private Integer quantidade;
    private Integer preco_in_cents;

    public Cafe(RequestCafe requestCafe){
        this.nome = requestCafe.nome();
        this.quantidade = requestCafe.quantidade();
        this.preco_in_cents = requestCafe.preco_in_cents();
    }
}
