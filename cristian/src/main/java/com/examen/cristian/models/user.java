package com.examen.cristian.models;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "Title", nullable = false, length = 100)
    private String Title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate due_date;

    @Column(name = "assigned_to", nullable = false, length = 100)
    private String assigned_to;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, length = 20)
    private Status Status;


    public user() {
    }


    public user(String id, String title, LocalDate due_date, String assigned_to,
            com.examen.cristian.models.user.Status status) {
        this.id = id;
        Title = title;
        this.due_date = due_date;
        this.assigned_to = assigned_to;
        Status = status;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getTitle() {
        return Title;
    }


    public void setTitle(String title) {
        Title = title;
    }


    public LocalDate getDue_date() {
        return due_date;
    }


    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }


    public String getAssigned_to() {
        return assigned_to;
    }


    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }


    public Status getStatus() {
        return Status;
    }


    public void setStatus(Status status) {
        Status = status;
    }


    public enum Status{
        finalizada,
        pendiente,
        vencida,
        terminada_vencida
    }

}
