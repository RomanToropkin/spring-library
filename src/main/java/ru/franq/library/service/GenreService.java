package ru.franq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.franq.library.dto.GenreDTO;
import ru.franq.library.entity.Genre;
import ru.franq.library.exception.DuplicateEntryException;
import ru.franq.library.exception.EntityNotFoundException;
import ru.franq.library.repo.GenreRepository;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public void createGenre(GenreDTO dto) throws DuplicateEntryException {

        if (genreRepository.existsByTitle(dto.getTitle())){
            throw new DuplicateEntryException("Жанр с таким названием уже существует!");
        }

        genreRepository.saveAndFlush(convertGenreToEntity(dto));
    }

    public Genre getGenreById(Long id) throws EntityNotFoundException {
        return genreRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Жанр с id = %s не найден!", id)));
    }

    public List<Genre> getGenreList() {
        return genreRepository.findAll();
    }

    private Genre convertGenreToEntity(GenreDTO dto) {

        Genre genre = new Genre();
        genre.setTitle(dto.getTitle());
        return genre;

    }
}
