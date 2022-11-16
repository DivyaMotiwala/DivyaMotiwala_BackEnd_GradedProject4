package com.divyamotiwala.gradedproject4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "role_name")
	private String roleName;

	/*
	 * @ManyToMany
	 * 
	 * @JoinColumns(joinColumn(name="user_id_fk") //, nullable = false)
	 * // @JsonManagedReference
	 * 
	 * private User user;
	 */
}
