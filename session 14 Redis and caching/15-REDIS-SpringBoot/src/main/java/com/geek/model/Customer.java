package com.geek.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer implements Serializable {
	@Id
private int cid;
private String cname;

}
