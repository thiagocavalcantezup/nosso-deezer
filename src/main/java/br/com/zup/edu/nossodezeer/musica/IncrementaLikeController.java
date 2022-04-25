package br.com.zup.edu.nossodezeer.musica;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class IncrementaLikeController {

    private final MusicaRepository musicaRepository;

    public IncrementaLikeController(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    @PatchMapping("/musicas/{id}/likes")
    @Transactional
    public ResponseEntity<?> incrementa(@PathVariable Long id) {
        Musica musica = musicaRepository.findById(id)
                                        .orElseThrow(
                                            () -> new ResponseStatusException(
                                                HttpStatus.NOT_FOUND,
                                                "Musica nao cadastrada no sistema."
                                            )
                                        );

        musica.aumentarLikes();

        return ResponseEntity.noContent().build();
    }

}
