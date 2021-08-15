package ru.franq.library.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.franq.library.dto.GenreDTO;
import ru.franq.library.exception.DuplicateEntryException;
import ru.franq.library.exception.EntityNotFoundException;
import ru.franq.library.exception.NotEnoughParamsException;
import ru.franq.library.factory.GenreDTOFactory;
import ru.franq.library.service.GenreService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @Autowired
    GenreDTOFactory genreDTOFactory;

    @GetMapping("/list")
    public List<GenreDTO> getGenreList() {
        return genreDTOFactory.createGenreDTOList(genreService.getGenreList());
    }

    @GetMapping("/{id}")
    public GenreDTO getGenre(@PathVariable Long id) throws EntityNotFoundException {
        return genreDTOFactory.createGenreDTO(genreService.getGenreById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createGenre(@RequestBody GenreDTO dto)
            throws DuplicateEntryException, NotEnoughParamsException {
        if (dto.getTitle() == null){
            throw new NotEnoughParamsException("Недостаточно параметров для создания нового жанра!");
        }

        genreService.createGenre(dto);

        return ResponseEntity.ok(String.format("Новый жанр '%s' успешно создан!", dto.getTitle()));
    }

}
