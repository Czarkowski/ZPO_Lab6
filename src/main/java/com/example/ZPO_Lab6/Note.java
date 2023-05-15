package com.example.ZPO_Lab6;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;


@Entity
@Table(name="note")
@Data
public class Note {

    @Id
    private int id;

    private String content;

    @Enumerated(EnumType.STRING)
    private Importance importance;

    private Timestamp timestamp;
}
