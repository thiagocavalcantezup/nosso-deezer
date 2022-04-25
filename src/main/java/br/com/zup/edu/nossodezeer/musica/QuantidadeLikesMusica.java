package br.com.zup.edu.nossodezeer.musica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "quantidades_likes_musica")
public class QuantidadeLikesMusica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Version
    private int versao;

    @OneToOne
    private Musica musica;

    public QuantidadeLikesMusica() {}

    public QuantidadeLikesMusica(Musica musica) {
        this.musica = musica;
        this.quantidade = 0;
    }

    public void incrementar() {
        quantidade++;
    }

    public Long getId() {
        return id;
    }

}
