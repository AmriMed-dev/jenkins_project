package com.devglan.model;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String description;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "user_id", insertable = false, updatable = false)
   	@Fetch(FetchMode.JOIN)
    @JsonIgnore
    private User user ;

    
    
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Role(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	
	
	public Role(String name, String description, User user) {
		super();
		this.name = name;
		this.description = description;
		this.user = user;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
    
    
    

}
