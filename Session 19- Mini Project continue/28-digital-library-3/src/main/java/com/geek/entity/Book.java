package com.geek.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@NamedQuery(query = "select b from Book b where genre= :g",
name = "searchBook")
public class Book implements Serializable{
	@Id
private int bookId;
private String bookName;
@Enumerated(EnumType.STRING)
private Genre genre;
private float cost;
private int stock;
@ManyToOne
@JoinColumn(name = "authourId")
@JsonIgnore
private Authour authour;
}
