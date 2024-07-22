package com.geek.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentAddress {

private String flatNo;
private String placeName;

public String getFlatNo() {
	return flatNo;
}
public void setFlatNo(String flatNo) {
	this.flatNo = flatNo;
}
public String getPlaceName() {
	return placeName;
}
public void setPlaceName(String placeName) {
	this.placeName = placeName;
}
}
