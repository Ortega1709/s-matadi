package com.ortega.smatadi.repository;



import com.ortega.smatadi.models.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SongRepository extends MongoRepository<Song, UUID> {

}
