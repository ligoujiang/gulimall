package com.pxy.gulimall.ware.controller;

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
import com.pxy.gulimall.ware.domain.PurchaseDetail;
import com.pxy.gulimall.ware.service.IPurchaseDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购明细Controller
 * 
 * @author pxy
 * @date 2025-10-22
 */
@RestController
@RequestMapping("/ware/purchase-detail")
public class PurchaseDetailController extends BaseController
{
    @Autowired
    private IPurchaseDetailService purchaseDetailService;

    /**
     * 查询采购明细列表
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(PurchaseDetail purchaseDetail)
    {
        startPage();
        List<PurchaseDetail> list = purchaseDetailService.selectPurchaseDetailList(purchaseDetail);
        return getDataTable(list);
    }

    /**
     * 导出采购明细列表
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:export')")
    @Log(title = "采购明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PurchaseDetail purchaseDetail)
    {
        List<PurchaseDetail> list = purchaseDetailService.selectPurchaseDetailList(purchaseDetail);
        ExcelUtil<PurchaseDetail> util = new ExcelUtil<PurchaseDetail>(PurchaseDetail.class);
        util.exportExcel(response, list, "采购明细数据");
    }

    /**
     * 获取采购明细详细信息
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(purchaseDetailService.selectPurchaseDetailById(id));
    }

    /**
     * 新增采购明细
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:add')")
    @Log(title = "采购明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PurchaseDetail purchaseDetail)
    {
        return toAjax(purchaseDetailService.insertPurchaseDetail(purchaseDetail));
    }

    /**
     * 修改采购明细
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:edit')")
    @Log(title = "采购明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PurchaseDetail purchaseDetail)
    {
        return toAjax(purchaseDetailService.updatePurchaseDetail(purchaseDetail));
    }

    /**
     * 删除采购明细
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:remove')")
    @Log(title = "采购明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(purchaseDetailService.deletePurchaseDetailByIds(ids));
    }
}
