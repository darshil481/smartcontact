package com.example.smartContact.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int c_id;
    private String name;
    private String nickName;
    private  String work;
    private String email;
    private  String image;
    private  String description;
    private String phone;
    @ManyToOne()
    private User user;
}
