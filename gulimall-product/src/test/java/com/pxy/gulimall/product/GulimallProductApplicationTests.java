package com.pxy.gulimall.product;

import com.pxy.gulimall.product.domain.Brand;
import com.pxy.gulimall.product.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GulimallProductApplicationTests {
    @Autowired
    private IBrandService brandService;
    @Test
    public void contextLoads() {
//        Brand brand = new Brand();
//        brand.setName("华为");
//        brandService.insertBrand(brand);

        Brand brand=brandService.selectBrandByBrandId(1L);
        System.out.println(brand);
    }

}
