package com.pxy.gulimall.coupon.controller;

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
import com.pxy.gulimall.coupon.domain.SkuFullReduction;
import com.pxy.gulimall.coupon.service.ISkuFullReductionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品满减信息Controller
 * 
 * @author pxy
 * @date 2025-10-22
 */
@RestController
@RequestMapping("/coupon/reduction")
public class SkuFullReductionController extends BaseController
{
    @Autowired
    private ISkuFullReductionService skuFullReductionService;

    /**
     * 查询商品满减信息列表
     */
    //@PreAuthorize("@ss.hasPermi('coupon:reduction:list')")
    @GetMapping("/list")
    public TableDataInfo list(SkuFullReduction skuFullReduction)
    {
        startPage();
        List<SkuFullReduction> list = skuFullReductionService.selectSkuFullReductionList(skuFullReduction);
        return getDataTable(list);
    }

    /**
     * 导出商品满减信息列表
     */
    //@PreAuthorize("@ss.hasPermi('coupon:reduction:export')")
    @Log(title = "商品满减信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SkuFullReduction skuFullReduction)
    {
        List<SkuFullReduction> list = skuFullReductionService.selectSkuFullReductionList(skuFullReduction);
        ExcelUtil<SkuFullReduction> util = new ExcelUtil<SkuFullReduction>(SkuFullReduction.class);
        util.exportExcel(response, list, "商品满减信息数据");
    }

    /**
     * 获取商品满减信息详细信息
     */
    //@PreAuthorize("@ss.hasPermi('coupon:reduction:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(skuFullReductionService.selectSkuFullReductionById(id));
    }

    /**
     * 新增商品满减信息
     */
    //@PreAuthorize("@ss.hasPermi('coupon:reduction:add')")
    @Log(title = "商品满减信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkuFullReduction skuFullReduction)
    {
        return toAjax(skuFullReductionService.insertSkuFullReduction(skuFullReduction));
    }

    /**
     * 修改商品满减信息
     */
    //@PreAuthorize("@ss.hasPermi('coupon:reduction:edit')")
    @Log(title = "商品满减信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkuFullReduction skuFullReduction)
    {
        return toAjax(skuFullReductionService.updateSkuFullReduction(skuFullReduction));
    }

    /**
     * 删除商品满减信息
     */
    //@PreAuthorize("@ss.hasPermi('coupon:reduction:remove')")
    @Log(title = "商品满减信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(skuFullReductionService.deleteSkuFullReductionByIds(ids));
    }
}
