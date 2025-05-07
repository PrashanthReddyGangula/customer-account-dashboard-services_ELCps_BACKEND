package com.simulation.doctors_pi_manipulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.simulation.doctors_pi_manipulator.persist.entity.Details;
import com.simulation.doctors_pi_manipulator.persist.repository.DoctorsRepository;
import com.simulation.doctors_pi_manipulator.persist.service.DoctorsService;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @InjectMocks
    private DoctorsService recordService;

    @Mock
    private DoctorsRepository recordRepository;

    @Test
    public void testGetRecordById_Success() {
        // Mock data
    	Details mockRecord = new Details();
        mockRecord.setDoctorID("Ranee190");
        mockRecord.setFullName("Dr. Raniel Lee");
        mockRecord.setEmailAddress("raniel.lee@example.com");
        mockRecord.setPhoneNumber("456-789-0124");
        mockRecord.setCountry("India");
        mockRecord.setSpecialization("Dermatology");
        Mockito.when(recordRepository.findById("Ranee190")).thenReturn(Optional.of(mockRecord));

        // Call the service method
        Optional<Details> record = recordService.getDoctorById("Ranee190");

        if (record.isPresent()) {
            Details details = record.get(); 
            // Access fields of the Details object
            String id = details.getDoctorID(); 
            String name = details.getFullName(); 
            // Assert the result
            
            assertEquals("Ranee190", id);
            
            assertEquals("Dr. Raniel Lee", name);
        } else {
            // Handle the case where no record was found
            System.out.println("Record not found.");
        }
       
    }

    @Test
    public void testGetRecordById_NotFound() {
        Mockito.when(recordRepository.findById("Ranee190")).thenReturn(Optional.empty());

        Optional<Details> record = recordService.getDoctorById("Ranee190");

        assertTrue(record.isEmpty()); 
    }
}

