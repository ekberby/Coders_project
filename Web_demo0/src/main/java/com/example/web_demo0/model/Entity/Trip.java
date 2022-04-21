package com.example.web_demo0.model.entity;

import com.example.web_demo0.model.enums.TripType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trips")
public class Trip {
    @Id
    private String name;
    private String address;
    private int price;
    private int numberOfDays;
    @Enumerated(EnumType.STRING)
    private TripType tripType;
    @OneToMany
    List<User> userList;
}

