package com.wts.where_to_watch.movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    void deleteByTitulo (String titulo);
    Optional<Movie> findByid(UUID id);
}
