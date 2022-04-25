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
@Table(name = "numeros_de_ouvintes_musica")
public class NumeroDeOuvintesMusica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numero;

    @Version
    private int versao;

    @OneToOne
    private Musica musica;

    public NumeroDeOuvintesMusica() {}

    public NumeroDeOuvintesMusica(Musica musica) {
        this.musica = musica;
        this.numero = 0;
    }

    public void incrementar() {
        numero++;
    }

    public Long getId() {
        return id;
    }

}
