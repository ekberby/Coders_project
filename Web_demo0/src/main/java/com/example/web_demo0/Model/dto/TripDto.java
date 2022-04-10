package com.example.web_demo0.model.dto;

import com.example.web_demo0.model.enums.TripType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
