package com.mit.artist.repository;

import com.mit.artist.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    @Query("select a from Artist a where name like %:name% order by name asc")
    List<Artist> findByName(String name);
}
