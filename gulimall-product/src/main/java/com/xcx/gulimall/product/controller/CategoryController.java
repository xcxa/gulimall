package com.xcx.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.xcx.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xcx.gulimall.product.entity.CategoryEntity;
import com.xcx.gulimall.product.service.CategoryService;
import com.xcx.common.utils.PageUtils;


/**
 * ��Ʒ��������
 *
 * @author xcx
 * @email 1255137205@qq.com
 * @date 2022-09-30 15:59:10
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list/tree")
   // @RequiresPermissions("product:category:list")
    public R list(){
        List<CategoryEntity> entityList =  categoryService.listWithTree();
        return R.ok().put("data", entityList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    // @RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
        CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }
    /**
     * 保存
     */
    @RequestMapping("/save")
 //   @RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
 //   @RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateDetail(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
  //  @RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){
        categoryService.removeMenusByIds(Arrays.asList(catIds));

        return R.ok();
    }

    @RequestMapping("/update/sort")
    // @RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity[] category){

        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }

}
