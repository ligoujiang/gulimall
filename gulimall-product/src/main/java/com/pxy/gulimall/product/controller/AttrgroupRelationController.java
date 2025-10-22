package com.pxy.gulimall.product.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.pxy.gulimall.product.domain.AttrgroupRelation;
import com.pxy.gulimall.product.service.IAttrgroupRelationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 属性&属性分组关联Controller
 * 
 * @author pxy
 * @date 2025-10-21
 */
@RestController
@RequestMapping("/product/attrgrouprelation")
public class AttrgroupRelationController extends BaseController
{
    @Autowired
    private IAttrgroupRelationService attrgroupRelationService;

    /**
     * 查询属性&属性分组关联列表
     */
    //@PreAuthorize("@ss.hasPermi('product:attrgrouprelation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AttrgroupRelation attrgroupRelation)
    {
        startPage();
        List<AttrgroupRelation> list = attrgroupRelationService.selectAttrgroupRelationList(attrgroupRelation);
        return getDataTable(list);
    }

    /**
     * 导出属性&属性分组关联列表
     */
    //@PreAuthorize("@ss.hasPermi('product:attrgrouprelation:export')")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AttrgroupRelation attrgroupRelation)
    {
        List<AttrgroupRelation> list = attrgroupRelationService.selectAttrgroupRelationList(attrgroupRelation);
        ExcelUtil<AttrgroupRelation> util = new ExcelUtil<AttrgroupRelation>(AttrgroupRelation.class);
        util.exportExcel(response, list, "属性&属性分组关联数据");
    }

    /**
     * 获取属性&属性分组关联详细信息
     */
    //@PreAuthorize("@ss.hasPermi('product:attrgrouprelation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(attrgroupRelationService.selectAttrgroupRelationById(id));
    }

    /**
     * 新增属性&属性分组关联
     */
    //@PreAuthorize("@ss.hasPermi('product:attrgrouprelation:add')")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AttrgroupRelation attrgroupRelation)
    {
        return toAjax(attrgroupRelationService.insertAttrgroupRelation(attrgroupRelation));
    }

    /**
     * 修改属性&属性分组关联
     */
    //@PreAuthorize("@ss.hasPermi('product:attrgrouprelation:edit')")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AttrgroupRelation attrgroupRelation)
    {
        return toAjax(attrgroupRelationService.updateAttrgroupRelation(attrgroupRelation));
    }

    /**
     * 删除属性&属性分组关联
     */
    //@PreAuthorize("@ss.hasPermi('product:attrgrouprelation:remove')")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(attrgroupRelationService.deleteAttrgroupRelationByIds(ids));
    }
}
