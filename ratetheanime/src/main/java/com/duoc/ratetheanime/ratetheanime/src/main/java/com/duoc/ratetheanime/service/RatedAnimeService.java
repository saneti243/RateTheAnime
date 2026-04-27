package com.duoc.ratetheanime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.ratetheanime.model.RatedAnime;
import com.duoc.ratetheanime.repository.RatedAnimeRepository;

@Service
public class RatedAnimeService {
    
    @Autowired
    private RatedAnimeRepository ratedAnimeRepository;

    public List<RatedAnime> getRatedAnimes() {
        return ratedAnimeRepository.findAll();
    }

    public RatedAnime saveRatedAnime(RatedAnime ratedAnime) {
        return ratedAnimeRepository.save(ratedAnime);
    }

    public RatedAnime getRatedAnimeById(Integer id) {
        return ratedAnimeRepository.findById(id).orElse(null);
    }

    public RatedAnime updateRatedAnime(RatedAnime ratedAnime){
        if (!ratedAnimeRepository.existsById(ratedAnime.getId())) {
            return null;
    }
        return ratedAnimeRepository.save(ratedAnime);
    }

    public void deleteRatedAnime(Integer id) {
        ratedAnimeRepository.deleteById(id);
    }
}
