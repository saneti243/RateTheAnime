package com.duoc.ratetheanime.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.ratetheanime.model.RatedAnime;
import com.duoc.ratetheanime.service.RatedAnimeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ratedanimes")

public class RatedAnimeController {
    
    @Autowired
    private RatedAnimeService ratedAnimeService;

    @GetMapping
    public ResponseEntity<List<RatedAnime>> listarRatedAnimes() {
        return ResponseEntity.ok(ratedAnimeService.getRatedAnimes());
    }

    @PostMapping
    public ResponseEntity<RatedAnime> agregarRatedAnime(@Valid @RequestBody RatedAnime ratedAnime) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratedAnimeService.saveRatedAnime(ratedAnime));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatedAnime> buscarRatedAnime(@PathVariable int id) {
        RatedAnime ratedAnime = ratedAnimeService.getRatedAnimeById(id);
        if (ratedAnime == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ratedAnime);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatedAnime> actualizarRatedAnime(@PathVariable int id, @Valid @RequestBody RatedAnime ratedAnime){
        ratedAnime.setId(id);
        RatedAnime actualizado = ratedAnimeService.updateRatedAnime(ratedAnime);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRatedAnime(@PathVariable int id) {
        ratedAnimeService.deleteRatedAnime(id);
        return ResponseEntity.noContent().build();
    }

}
