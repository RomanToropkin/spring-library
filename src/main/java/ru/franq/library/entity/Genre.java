package ru.franq.library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "genre")
@Data
@Table(name = "genre",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title")
        })
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @Column(name = "is_deleted")
    private boolean isDeteled;

}
