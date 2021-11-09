package com.audience.audience.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="audience")
public class Audience implements Serializable  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String owner;
    private Integer capacity;
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("audiences")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="audience")
    @JsonIgnoreProperties({"audience","reservations","category","client"})
    public List<Message>messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="audience")
    @JsonIgnoreProperties({"audience","reservations","category","client"}) 
    public List<Reservation>reservations;

    public Integer getId() {
        return id;
    }
    
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
 
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
