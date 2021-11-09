package com.audience.audience.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Message")
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name="audienceId")
    @JsonIgnoreProperties({"messages","client","audiences","reservations"})
    private Audience audience;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages","client","audiences","reservations","category"})
    private Client client;


    public Integer getIdMessage() {
        return idMessage;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Audience getAudience() {
        return audience;
    }
    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    
}
