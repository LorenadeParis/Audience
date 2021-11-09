package com.audience.audience.entity;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Reservation")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name="audienceId")
    @JsonIgnoreProperties("reservations")
    private Audience audience;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    private String score ;

    public Integer getIdReservation() {
        return idReservation;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Audience getAudience() {
        return audience;
    }
    public void setAudience(Audience audience) {
        this.audience = audience;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
   


   }
