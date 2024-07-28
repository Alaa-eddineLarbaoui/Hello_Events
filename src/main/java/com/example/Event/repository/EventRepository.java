package com.example.Event.repository;

import com.example.Event.modal.Event;
import com.fasterxml.jackson.databind.DatabindException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> , QuerydslPredicateExecutor<Event> {

    List<Event> findByEventDate(Date eventDate);
}
