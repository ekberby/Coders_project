package com.example.web_demo0.Service

import com.example.web_demo0.Model.Entity.Trip
import com.example.web_demo0.Model.dto.TripDto
import com.example.web_demo0.Repository.TripRepository
import com.example.web_demo0.Service.Impl.TripServiceImpl
import spock.lang.Specification

class TripServiceTest extends Specification{
    private TripRepository tripRepository = Mock();
    private TripService tripService = new TripServiceImpl(tripRepository);

    def "test create(Trip trip)"(){
        def trip = Trip.builder().address("a").name("a").build()

        when:

        tripService.create(trip)
        then:

        1*tripRepository.save(trip)

    }

    def "test getAll()"(){
        List<TripDto> tripDtos = new ArrayList<>()

        def tripDto = TripDto.builder().name("a").address("a").build()

        List<Trip> tripList = new ArrayList<>()

        def trip = Trip.builder().address("a").name("a").build()

        tripDtos.add(tripDto)

        tripList.add(trip)
        when:
        def result = tripService.getAll()
        then:

        1*tripRepository.findAll() >> tripList
        result == tripDtos
    }

    def "test delete()"(){
        def name = "mock"

        when:
        tripService.deleteTripByID(name)

        then:
        1*tripRepository.deleteById(name)
    }
}
