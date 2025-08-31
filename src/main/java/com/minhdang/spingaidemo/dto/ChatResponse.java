package com.minhdang.spingaidemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ChatResponse(
        String conversationId,
        String response,
        TravelItinerary itinerary
) {

    @Builder
    public record TravelItinerary(
            String title,
            String description,
            @JsonFormat(pattern = "yyyy-MM-dd")
            LocalDate startDate,
            @JsonFormat(pattern = "yyyy-MM-dd")
            LocalDate endDate,
            int duration,
            String destination,
            Budget budget,
            List<DayPlan> dayPlans,
            List<String> recommendations,
            List<String> warnings
    ) {}

    @Builder
    public record Budget(
            BigDecimal totalCost,
            String currency,
            BigDecimal accommodationCost,
            BigDecimal transportationCost,
            BigDecimal foodCost,
            BigDecimal activityCost,
            BigDecimal miscellaneousCost
    ) {}

    @Builder
    public record DayPlan(
            int dayNumber,
            @JsonFormat(pattern = "yyyy-MM-dd")
            LocalDate date,
            String title,
            String description,
            List<Activity> activities,
            Accommodation accommodation,
            BigDecimal dailyCost
    ) {}

    @Builder
    public record Activity(
            String name,
            String description,
            String category,
            String location,
            @JsonFormat(pattern = "HH:mm")
            String startTime,
            @JsonFormat(pattern = "HH:mm")
            String endTime,
            int duration,
            BigDecimal cost,
            String difficulty,
            List<String> tags,
            boolean isRecommended
    ) {}

    @Builder
    public record Accommodation(
            String name,
            String type,
            String address,
            String location,
            BigDecimal pricePerNight,
            Float rating,
            List<String> amenities,
            String checkInTime,
            String checkOutTime
    ) {}
}
