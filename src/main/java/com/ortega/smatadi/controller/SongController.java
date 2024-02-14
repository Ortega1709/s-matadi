package com.ortega.smatadi.controller;



import com.ortega.smatadi.models.Song;
import com.ortega.smatadi.services.SongService;
import com.ortega.smatadi.utils.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.ortega.smatadi.utils.Constant.SUCCESS_MSG;


@RestController
@RequestMapping("api/v1/songs")
@AllArgsConstructor
public class SongController {

    private SongService songService;

    @GetMapping
    public ResponseEntity<Object> getAllSongs() {
        try {
            List<Song> songResponse = songService.getAllSongs();
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, songResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> saveSong(@RequestPart("song") Song song, @RequestPart("file") MultipartFile file) {

        try {
            Song songResponse = songService.saveSong(song, file);
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, songResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSongById(@PathVariable String id) {
        try {
            Optional<Song> songResponse = songService.getSongById(UUID.fromString(id));
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, songResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping("")
    public ResponseEntity<Object> updateSong(@RequestBody Song song) {
        try {
            songService.updateSong(song);
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSongById(@PathVariable String id) {
        try {
            songService.deleteSong(UUID.fromString(id));
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

}
