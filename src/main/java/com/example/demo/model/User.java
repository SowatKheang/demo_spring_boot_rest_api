package com.example.demo.model;
import javax.persistence.*;
@Entity
@Table(name = "users")
public class User extends BaseModel<User> {
    
    @Id
	private int id;

    @Column(name = "id_ref")
    private String uuid;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firtname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "status")
    private int status;

    public String getFirtname() {
        return this.firtname;
    }

    public void setFirtname(String firtname) {
        this.firtname = firtname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    @Override
    public User updateWith(User model) {
        // TODO Auto-generated method stub
        return null;
    }

}
