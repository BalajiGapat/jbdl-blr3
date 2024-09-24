package com.geek.dto;

import com.geek.entity.Genre;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
@Data
public class BookDto {
private int bookId;
private String bookName;
@Enumerated(EnumType.STRING)
private Genre genre;
private float cost;
private int stock;
private int authourId;
}
