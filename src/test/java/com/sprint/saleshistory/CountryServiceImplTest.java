package com.sprint.saleshistory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.saleshistory.dao.CountryRepository;
import com.sprint.saleshistory.entities.CountryEntity;
import com.sprint.saleshistory.exception.CountryDeleteException;
import com.sprint.saleshistory.exception.CountryServiceException;
import com.sprint.saleshistory.exception.InvalidCountryNameException;
import com.sprint.saleshistory.exception.InvalidRegionNameException;
import com.sprint.saleshistory.models.CountryInfo;
import com.sprint.saleshistory.service.CountryServiceImpl;

@SpringBootTest
class CountryServiceImplTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryServiceImpl countryService;


    @Test
    void testGetAllCountriesNoData() {
        // Mocking the behavior of countryRepository.findAll() when no data is found
        when(countryRepository.findAll()).thenReturn(Arrays.asList());

        // Call the actual method
        try {
            List<CountryEntity> result = countryService.getAllCountries();
            fail("Expected CountryServiceException to be thrown, but got a result: " + result);
        } catch (CountryServiceException e) {
            // Verify that the exception is thrown with the expected message
            assertEquals("no countries found", e.getMessage());
        }
    }

    @Test
    void testGetAllCountriesException() {
        // Mocking the behavior of countryRepository.findAll() to throw an exception
        when(countryRepository.findAll()).thenThrow(new RuntimeException("Simulated database error"));

        // Call the actual method
        try {
            List<CountryEntity> result = countryService.getAllCountries();
            fail("Expected CountryServiceException to be thrown, but got a result: " + result);
        } catch (CountryServiceException e) {
            // Verify that the exception is thrown with the expected message and cause
            assertEquals("no countries found", e.getMessage());
            assertNotNull(e.getCause());
            assertTrue(e.getCause() instanceof RuntimeException);
            assertEquals("Simulated database error", e.getCause().getMessage());
        }
    }
    

    
    
    
    
    
    @Test
    void testAddCountrySuccess() {
        // Mocking the behavior of countryRepository.save()
        when(countryRepository.save(Mockito.any())).thenReturn(new CountryEntity());

        // Create a sample CountryEntity for testing
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountryName("United States");

        // Call the actual method
        String result = countryService.addCountry(countryEntity);

        // Assertions
        assertEquals("Record Created Successfully", result);

        // Verify that countryRepository.save() was called once with the correct argument
        Mockito.verify(countryRepository, Mockito.times(1)).save(Mockito.eq(countryEntity));
    }

    @Test
    void testAddCountryInvalidName() {
        // Create a sample CountryEntity with an empty name for testing
        CountryEntity countryEntity = new CountryEntity();

        // Call the actual method and expect an IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            countryService.addCountry(countryEntity);
        });

        // Verify the exception message
        assertEquals("Country name cannot be empty", exception.getMessage());

        // Verify that countryRepository.save() was not called
        Mockito.verify(countryRepository, Mockito.never()).save(Mockito.any());
    }

    @Test
    void testAddCountryException() {
        // Mocking the behavior of countryRepository.save() to throw an exception
        when(countryRepository.save(Mockito.any())).thenThrow(new RuntimeException("Simulated database error"));

        // Create a sample CountryEntity for testing
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountryName("United States");

        // Call the actual method and expect a CountryServiceException
        CountryServiceException exception = assertThrows(CountryServiceException.class, () -> {
            countryService.addCountry(countryEntity);
        });

        // Verify the exception message and cause
        assertEquals("Error adding country", exception.getMessage());
        assertNotNull(exception.getCause());
        assertTrue(exception.getCause() instanceof RuntimeException);
        assertEquals("Simulated database error", exception.getCause().getMessage());

        // Verify that countryRepository.save() was called once with the correct argument
        Mockito.verify(countryRepository, Mockito.times(1)).save(Mockito.eq(countryEntity));
    }
    
    
    
    

    @Test
    void testUpdateCountrySuccess() {
        // Mocking the behavior of countryRepository.findById()
        when(countryRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new CountryEntity()));

        // Mocking the behavior of countryRepository.save()
        when(countryRepository.save(Mockito.any())).thenReturn(new CountryEntity());

        // Create a sample updated CountryEntity for testing
        CountryEntity updatedCountryEntity = new CountryEntity();
        updatedCountryEntity.setCountryName("Updated Country Name");

        // Call the actual method
        String result = countryService.updateCountry(1, updatedCountryEntity);

        // Assertions
        assertEquals("Record Updated Successfully", result);

        // Verify that countryRepository.findById() was called once with the correct argument
        Mockito.verify(countryRepository, Mockito.times(1)).findById(Mockito.eq(1));

        // Verify that countryRepository.save() was called once with the correct argument
        Mockito.verify(countryRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void testUpdateCountryNotFound() {
        // Mocking the behavior of countryRepository.findById() when the country is not found
        when(countryRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        // Create a sample updated CountryEntity for testing
        CountryEntity updatedCountryEntity = new CountryEntity();
        updatedCountryEntity.setCountryName("Updated Country Name");

        // Call the actual method and expect a CountryServiceException
        CountryServiceException exception = assertThrows(CountryServiceException.class, () -> {
            countryService.updateCountry(1, updatedCountryEntity);
        });

        // Verify the exception message
        assertEquals("Country not found with ID: 1", exception.getMessage());

        // Verify that countryRepository.save() was not called
        Mockito.verify(countryRepository, Mockito.never()).save(Mockito.any());
    }
    
    
    
    
    
    
    @Test
    void testDeleteCountrySuccess() {
        // Mocking the behavior of countryRepository.findById()
        when(countryRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new CountryEntity()));

        // Call the actual method
        countryService.deleteCountry(1);

        // Verify that countryRepository.findById() was called once with the correct argument
        verify(countryRepository, Mockito.times(1)).findById(Mockito.eq(1));

        // Verify that countryRepository.deleteById() was called once with the correct argument
        verify(countryRepository, Mockito.times(1)).deleteById(Mockito.eq(1));
    }

    @Test
    void testDeleteCountryNotFound() {
        // Mocking the behavior of countryRepository.findById() when the country is not found
        when(countryRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        // Call the actual method and expect a CountryDeleteException
        CountryDeleteException exception = assertThrows(CountryDeleteException.class, () -> {
            countryService.deleteCountry(1);
        });

        // Verify the exception message
        assertEquals("Country not found with ID: 1", exception.getMessage());

        // Verify that countryRepository.deleteById() was not called
        verify(countryRepository, Mockito.never()).deleteById(Mockito.any());
    }

    
    
    
    
    
    @Test
    void testGetCountAndCountriesByCountryNameInvalidName() {
        // Call the actual method with an empty country name and expect an InvalidCountryNameException
        InvalidCountryNameException exception = assertThrows(InvalidCountryNameException.class, () -> {
            countryService.getCountAndCountriesByCountryName("");
        });

        // Verify the exception message
        assertEquals("Country name cannot be empty or null", exception.getMessage());

        // Verify that countryRepository.findByCountryName() was not called
        Mockito.verify(countryRepository, Mockito.never()).findByCountryName(Mockito.anyString());
    }
    
    
    
    
      @Test
    void testGetCountAndCountriesByRegionInvalidRegion() {	
        // Call the actual method with an empty region and expect an InvalidRegionNameException
        InvalidRegionNameException exception = assertThrows(InvalidRegionNameException.class, () -> {
            countryService.getCountAndCountriesByRegion("");
        });

        // Verify the exception message
        assertEquals("Region cannot be empty or null", exception.getMessage());

        // Verify that countryRepository.findByCountryRegion() was not called
        Mockito.verify(countryRepository, Mockito.never()).findByCountryRegion(Mockito.anyString());
    }
    
    
    

    @Test
    void testGetCountsForCountriesSuccess() {
        // Mocking the behavior of countryRepository.countByCountryName()
        when(countryRepository.countByCountryName(Mockito.anyString())).thenReturn(10L);  // Adjust based on the expected count

        // Sample list of country names for testing
        List<String> countryNames = Arrays.asList("United States", "Canada", "Mexico");

        // Call the actual method
        Map<String, Long> result = countryService.getCountsForCountries(countryNames);

        // Assertions
        assertNotNull(result);
        assertEquals(3, result.size());  // Adjust based on the number of sample country names

        // You can add more specific assertions based on your actual data and logic
    }

    
    
    @Test
    void testGetCountsForRegionSuccess() {
        // Mocking the behavior of countryRepository.countByCountryRegion()
        when(countryRepository.countByCountryRegion(Mockito.anyString())).thenReturn(5L);  // Adjust based on the expected count

        // Sample list of region names for testing
        List<String> regionNames = Arrays.asList("North America", "Europe", "Asia");

        // Call the actual method
        Map<String, Long> result = countryService.getCountsForRegion(regionNames);

        // Assertions
        assertNotNull(result);
        assertEquals(3, result.size());  // Adjust based on the number of sample region names

        // You can add more specific assertions based on your actual data and logic
    }

	
    
    
    
    
    
   
   
}
