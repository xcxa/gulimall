package com.xcx.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.xcx.gulimall.product.controller.BrandController;
import com.xcx.gulimall.product.entity.BrandEntity;
import com.xcx.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {
    @Autowired
    BrandService brandService;
    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        System.out.println(brandService.getById(1L));
//        brandEntity.setDescript("hello");
//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("保存成功");
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("小米家里的");
//        brandService.updateById(brandEntity);
    }

}
