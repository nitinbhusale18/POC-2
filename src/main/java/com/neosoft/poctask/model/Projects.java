package com.neosoft.poctask.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Projects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projId;
	
	private String projName;
	
	private String projDuration;
	

	

	
	
	
	
	

}
