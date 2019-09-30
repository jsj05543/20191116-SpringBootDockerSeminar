package com.mit.artist.service;

import com.mit.artist.domain.Artist;
import com.mit.artist.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    public List<Artist> find(String name) {
        if (name == null || "".equals(name)) {
            return artistRepository.findAll();
        } else {
            return artistRepository.findByName(name);
        }
    }

    public Artist findById(Integer id) {
        return artistRepository.findById(id).orElse(null);
    }

    public Artist create(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist upadte(Artist artist) {
        return artistRepository.save(artist);
    }

    public void delete(Integer id) {
        artistRepository.deleteById(id);
    }
}
