package com.geek.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Authour implements Serializable{
	@Id
private int authourId;
	@NotBlank
private String name;
	@OneToMany(mappedBy ="authour" )
	private List<Book> books;

}
