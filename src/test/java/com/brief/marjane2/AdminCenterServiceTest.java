package com.brief.marjane2;

import com.brief.marjane2.entity.AdminCentre;
import com.brief.marjane2.repository.AdminCenterRepository;
import com.brief.marjane2.service.AdminCenterService;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;

import java.util.List;




@SpringBootTest
public class AdminCenterServiceTest {



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


}