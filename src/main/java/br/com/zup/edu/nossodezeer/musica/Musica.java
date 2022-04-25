package br.com.zup.edu.nossodezeer.musica;

import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(mappedBy = "musica", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private NumeroDeOuvintesMusica numeroDeOuvintes;

    @OneToOne(mappedBy = "musica", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeLikesMusica quantidadeLikes;

    @Column(nullable = false)
    private LocalDateTime criadoEm = now();

    @Column(nullable = false)
    private LocalDateTime atualiazadoEm = now();

    @Version
    private int versao;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Musica() {}

    public Musica(String nome) {
        this.nome = nome;
        this.numeroDeOuvintes = new NumeroDeOuvintesMusica(this);
        this.quantidadeLikes = new QuantidadeLikesMusica(this);
    }

    public void aumentarOuvinte() {
        this.numeroDeOuvintes.incrementar();
    }

    public void aumentarLikes() {
        this.quantidadeLikes.incrementar();
    }

}
