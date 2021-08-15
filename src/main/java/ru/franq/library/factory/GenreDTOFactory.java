package ru.franq.library.factory;

import org.springframework.stereotype.Component;
import ru.franq.library.dto.GenreDTO;
import ru.franq.library.entity.Genre;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreDTOFactory {

    public GenreDTO createGenreDTO(Genre genre){
        return GenreDTO.builder()
                .id(genre.getId())
                .title(genre.getTitle())
                .build();
    }

    public List<GenreDTO> createGenreDTOList(List<Genre> genreList){
        return genreList
                .stream()
                .map(this::createGenreDTO)
                .distinct()
                .collect(Collectors.toList());
    }

}
