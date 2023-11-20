package com.brief.marjane2;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.brief.marjane2.entity.AdminCentre;
import com.brief.marjane2.repository.AdminCenterRepository;
import com.brief.marjane2.service.AdminCenterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminCenterServiceTest {


    private AdminCenterService adminCenterService;
    private AdminCenterRepository adminCenterRepository;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        adminCenterRepository = mock(AdminCenterRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        adminCenterService = new AdminCenterService();
    }

    @Test
    void createAdminCenter() {

        AdminCentre adminCentre = new AdminCentre();
        adminCentre.setPassword("plainPassword");


        when(passwordEncoder.encode("plainPassword")).thenReturn("encodedPassword");


        adminCenterService.create(adminCentre);


        verify(passwordEncoder).encode("plainPassword");
        verify(adminCenterRepository).save(adminCentre);


        InOrder inOrder = inOrder(passwordEncoder, adminCenterRepository);
        inOrder.verify(passwordEncoder).encode("plainPassword");
        inOrder.verify(adminCenterRepository).save(adminCentre);

        assertEquals("encodedPassword", adminCentre.getPassword());
    }

    @Test
    void fetchAllAdminCenters() {

        List<AdminCentre> expectedAdminCenters = Arrays.asList(new AdminCentre(), new AdminCentre());
        when(adminCenterRepository.findAll()).thenReturn(expectedAdminCenters);


        List<AdminCentre> actualAdminCenters = adminCenterService.fetchall();


        assertEquals(expectedAdminCenters, actualAdminCenters);
    }

    @Test
    void findAdminCenterById() {

        int adminCenterId = 1;
        AdminCentre expectedAdminCentre = new AdminCentre();
        when(adminCenterRepository.findById(adminCenterId)).thenReturn(Optional.of(expectedAdminCentre));


        Optional<AdminCentre> actualAdminCentre = adminCenterService.findByid(adminCenterId);


        assertTrue(actualAdminCentre.isPresent());
        assertEquals(expectedAdminCentre, actualAdminCentre.get());
    }

    @Test
    void updateAdminCenter() {

        AdminCentre adminCentre = new AdminCentre();
        when(adminCenterRepository.save(adminCentre)).thenReturn(adminCentre);


        adminCenterService.Update(adminCentre);


        verify(adminCenterRepository).save(adminCentre);
    }

    @Test
    void deleteAdminCenter() {

        AdminCentre adminCentre = new AdminCentre();


        adminCenterService.delete(adminCentre);

        
        verify(adminCenterRepository).delete(adminCentre);
    }

}
