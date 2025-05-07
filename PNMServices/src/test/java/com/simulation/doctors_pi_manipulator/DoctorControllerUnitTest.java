package com.simulation.doctors_pi_manipulator;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.simulation.doctors_pi_manipulator.persist.controller.DoctorsRestController;
import com.simulation.doctors_pi_manipulator.persist.entity.Details;
import com.simulation.doctors_pi_manipulator.persist.service.DoctorsService;

@WebMvcTest(DoctorsRestController.class)
public class DoctorControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorsService recordService;

    @Test
    public void testGetRecordById_Success() throws Exception {
        // Mock data
    	
    	Details mockRecord = new Details();
        mockRecord.setDoctorID("Ranee190");
        mockRecord.setFullName("Dr. Raniel Lee");
        mockRecord.setEmailAddress("raniel.lee@example.com");
        mockRecord.setPhoneNumber("456-789-0124");
        mockRecord.setCountry("India");
        mockRecord.setSpecialization("Dermatology");
        Mockito.when(recordService.getDoctorById("Ranee190")).thenReturn(Optional.of(mockRecord));

        // Perform GET request
        mockMvc.perform(get("/doctors/details/{id}", "Ranee190"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.doctorID").value("Ranee190"))
                .andExpect(jsonPath("$.fullName").value("Dr. Raniel Lee"))
                .andExpect(jsonPath("$.emailAddress").value("raniel.lee@example.com"))
                .andExpect(jsonPath("$.phoneNumber").value("456-789-0124"))
                .andExpect(jsonPath("$.country").value("India"))
                .andExpect(jsonPath("$.specialization").value("Dermatology"));
    }

    @Test
    public void testGetRecordById_NotFound() throws Exception {
        Mockito.when(recordService.getDoctorById("Ranee190")).thenReturn(Optional.empty());
             

        mockMvc.perform(get("/doctors/details/{id}", "Ranee190"))
                .andExpect(status().isNotFound());
    }
}
