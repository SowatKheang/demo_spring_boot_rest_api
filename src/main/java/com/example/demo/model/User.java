package com.example.demo.model;
import javax.persistence.*;
@Entity
@Table(name = "users")
public class User {
    
    @Id
	private int id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "username")

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String username;

    public int getId() {
        return this.id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", uuid=" + uuid + "]";
	}

}
