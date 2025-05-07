package com.simulation.doctors_pi_manipulator;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.simulation.doctors_pi_manipulator.persist.entity.Details;
import com.simulation.doctors_pi_manipulator.persist.repository.DoctorsRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:applicationTest.properties")
public class DoctorsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DoctorsRepository recordRepository;

    @BeforeEach
    public void setUp() {
        // Initialize mock data in the H2 database
    	
    	Details mockRecord = new Details();
        mockRecord.setDoctorID("Ranee190");
        mockRecord.setFullName("Dr. Raniel Lee");
        mockRecord.setEmailAddress("raniel.lee@example.com");
        mockRecord.setPhoneNumber("456-789-0124");
        mockRecord.setCountry("India");
        mockRecord.setSpecialization("Dermatology");
    	
        recordRepository.save(mockRecord);
    }

    @AfterEach
    public void tearDown() {
        // Clean up the database
        recordRepository.deleteAll();
    }

    @Test
    public void testGetRecordById_Success() throws Exception {
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
        mockMvc.perform(get("/doctors/details/{id}", "Lanee190"))
                .andExpect(status().isNotFound());
    }
}
