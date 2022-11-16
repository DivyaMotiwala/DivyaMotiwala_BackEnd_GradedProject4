package com.divyamotiwala.gradedproject4.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "userId")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String userName;
	private String password;
	private String emailAddress;
	
	/*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
   // @JsonBackReference
	private List<Role> roles;
	*/
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name="users_roles",
				joinColumns = @JoinColumn(name="userId"),
				inverseJoinColumns = @JoinColumn(name="roleId")
			)
	private List<Role> roles;
	
	public void addRole(Role role)
	{
		if(this.roles == null)
			this.roles = new ArrayList<>();
		this.roles.add(role);
		//role.setUser(this);
			
	}
}
