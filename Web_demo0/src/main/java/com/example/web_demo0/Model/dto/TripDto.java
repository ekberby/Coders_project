package com.example.web_demo0.Model.dto;

import com.example.web_demo0.Model.Enum.TripType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {
    private String name;
    private String address;
    private int price;
    private int numberOfDays;
    private TripType tripType;
}
