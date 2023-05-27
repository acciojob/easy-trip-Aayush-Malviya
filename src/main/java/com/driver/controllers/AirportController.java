package com.driver.controllers;


import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class AirportController {

    AirportService airportService = new AirportService();
    @PostMapping("/add_airport")
    public String addAirport(@RequestBody Airport airport){
        airportService.addAirport(airport);
        return "SUCCESS";
    }

    @GetMapping("/get-largest-aiport")
    public String getLargestAirportName(){

       return airportService.getLargestAirportName();
    }

    @GetMapping("/get-shortest-time-travel-between-cities")
    public double getShortestDurationOfPossibleBetweenTwoCities(@RequestParam("fromCity") City fromCity, @RequestParam("toCity")City toCity){

        double shortestDuration = airportService.getShortestDurationOfPossibleBetweenTwoCities(fromCity, toCity);
       return shortestDuration;
    }

    @GetMapping("/get-number-of-people-on-airport-on/{date}")
    public int getNumberOfPeopleOn(@PathVariable("date") Date date,@RequestParam("airportName")String airportName){

        int noOfPeople = airportService.getNumberOfPeopleOn(date, airportName);
        return noOfPeople;
    }

    @GetMapping("/calculate-fare")
    public int calculateFlightFare(@RequestParam("flightId")Integer flightId){

        int ans = airportService.calculateFlightFare(flightId);
       return ans;

    }


    @PostMapping("/book-a-ticket")
    public String bookATicket(@RequestParam("flightId")Integer flightId,@RequestParam("passengerId")Integer passengerId){

        String ans = airportService.bookATicket(flightId, passengerId);
        return ans;
    }

    @PutMapping("/cancel-a-ticket")
    public String cancelATicket(@RequestParam("flightId")Integer flightId,@RequestParam("passengerId")Integer passengerId){

        String ans = airportService.cancelATicket(flightId, passengerId);
       return ans;
    }


    @GetMapping("/get-count-of-bookings-done-by-a-passenger/{passengerId}")
    public int countOfBookingsDoneByPassengerAllCombined(@PathVariable("passengerId")Integer passengerId){

        int ans = airportService.countOfBookingsDoneByPassengerAllCombined(passengerId);
        return ans;
    }

    @PostMapping("/add-flight")
    public String addFlight(@RequestBody Flight flight){

        airportService.addFlight(flight);
       return "SUCCESS";
    }


    @GetMapping("/get-aiportName-from-flight-takeoff/{flightId}")
    public String getAirportNameFromFlightId(@PathVariable("flightId")Integer flightId){

        return airportService.getAirportNameFromFlightId(flightId);
    }


    @GetMapping("/calculate-revenue-collected/{flightId}")
    public int calculateRevenueOfAFlight(@PathVariable("flightId")Integer flightId){

        int ans = airportService.calculateRevenueOfAFlight(flightId);
        return ans;
    }

    @PostMapping("/add-passenger")
    public String addPassenger(@RequestBody Passenger passenger){

        airportService.addPassenger(passenger);
       return "SUCCESS";
    }
}