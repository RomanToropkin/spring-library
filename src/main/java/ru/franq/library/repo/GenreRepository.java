package ru.franq.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.franq.library.entity.Genre;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("select case when count(*) > 0 then true else false end\n" +
            "from genre g\n" +
            "where lower(g.title) like lower(:title) and g.isDeteled = 0")
    boolean existsByTitle(String title);

    @Query(
            "select g from genre g where id = :id and isDeteled = 0"
    )
    Optional<Genre> findById(Long id);

}
