package com.example.Event;

import com.example.Event.Controller.Eventcontroller;
import com.example.Event.enums.eventcategory;
import com.example.Event.enums.location;
import com.example.Event.modal.Event;
import com.example.Event.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class EventcontrollerTest {

    private MockMvc mockMvc;

    @Mock
    private EventService eventService;

    @InjectMocks
    private Eventcontroller eventController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
        objectMapper = new ObjectMapper();
    }


    @Test
    void testAfficherEvent() throws Exception {
        List<Event> events = Arrays.asList(
                Event.builder().eventId(1).eventName("Event 1").build(),
                Event.builder().eventId(2).eventName("Event 2").build()
        );
        when(eventService.showEvents()).thenReturn(events);

        mockMvc.perform(get("/getEvents"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].eventName").value("Event 1"))
                .andExpect(jsonPath("$[1].eventName").value("Event 2"));

        verify(eventService).showEvents();
    }

    @Test
    void testAfficherEventById() throws Exception {
        Event event = Event.builder()
                .eventId(1)
                .eventName("Test Event")
                .build();
        when(eventService.showEvent(anyInt())).thenReturn(event);

        mockMvc.perform(get("/getEvent").param("Idevent", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.eventId").value(1))
                .andExpect(jsonPath("$.eventName").value("Test Event"));

        verify(eventService).showEvent(1);
    }

    @Test
    void testDeleteEvent() throws Exception {
        when(eventService.deleteEvent(anyInt())).thenReturn("Event deleted");

        mockMvc.perform(delete("/admin/deleteEvent/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Event deleted"));

        verify(eventService).deleteEvent(1);
    }

   




}