package com.brief.marjane2;

import com.brief.marjane2.entity.AdminCentre;
import com.brief.marjane2.repository.AdminCenterRepository;
import com.brief.marjane2.service.AdminCenterService;

import com.brief.marjane2.service.PromotionService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;




@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AdminCenterServiceTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AdminCenterRepository adminCenterRepository;

    @InjectMocks
    private AdminCenterService adminCenterService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAdminCentre() {
        AdminCentre adminCentre = new AdminCentre();

        adminCentre.setEmail("a@a.com");
        adminCentre.setPassword("vcsdcsdc");

        Assert.assertEquals(adminCentre,adminCenterService.create(adminCentre));

    }
    /*
    @Autowired
    private AdminCenterRepository adminCenterRepository;





    @Test
    public void  testcreate(){
        AdminCentre adminCentre = new AdminCentre();
        adminCentre.setEmail("a@a.com");
        adminCentre.setPassword("vcsdcsdc");

        Assert.assertEquals(adminCentre,adminCenterRepository.save(adminCentre));

    }

    @Test
    public void testlist(){
        List<AdminCentre> admins = adminCenterRepository.findAll();
        //Assert.assertThat(admins.size().).;
    }
    */


}