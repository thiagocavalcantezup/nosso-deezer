package br.com.zup.edu.nossodezeer.musica;

import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer numeroDeOuvintes;

    @Column(nullable = false)
    private Integer quantidadeLikes;

    private LocalDateTime criadoEm = now();

    private LocalDateTime atualiazadoEm = now();

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Musica() {}

    public Musica(String nome) {
        this.nome = nome;
    }

    public void aumentarOuvinte() {
        this.numeroDeOuvintes++;
    }

    public void aumentarLikes() {
        this.quantidadeLikes++;
    }

}
