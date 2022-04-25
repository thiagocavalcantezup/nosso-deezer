package br.com.zup.edu.nossodezeer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.zup.edu.nossodezeer.musica.Musica;
import br.com.zup.edu.nossodezeer.musica.MusicaRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final MusicaRepository musicaRepository;

    public DataLoader(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (musicaRepository.count() == 0) {
            load();
        }
    }

    private void load() {
        Musica musica = new Musica("Lilypad");

        musicaRepository.save(musica);
    }

}
