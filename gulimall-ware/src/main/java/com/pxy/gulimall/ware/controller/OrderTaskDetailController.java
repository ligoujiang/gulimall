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
import com.pxy.gulimall.ware.domain.OrderTaskDetail;
import com.pxy.gulimall.ware.service.IOrderTaskDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存工作单Controller
 * 
 * @author pxy
 * @date 2025-10-22
 */
@RestController
@RequestMapping("/ware/order-task-detail")
public class OrderTaskDetailController extends BaseController
{
    @Autowired
    private IOrderTaskDetailService orderTaskDetailService;

    /**
     * 查询库存工作单列表
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrderTaskDetail orderTaskDetail)
    {
        startPage();
        List<OrderTaskDetail> list = orderTaskDetailService.selectOrderTaskDetailList(orderTaskDetail);
        return getDataTable(list);
    }

    /**
     * 导出库存工作单列表
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:export')")
    @Log(title = "库存工作单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderTaskDetail orderTaskDetail)
    {
        List<OrderTaskDetail> list = orderTaskDetailService.selectOrderTaskDetailList(orderTaskDetail);
        ExcelUtil<OrderTaskDetail> util = new ExcelUtil<OrderTaskDetail>(OrderTaskDetail.class);
        util.exportExcel(response, list, "库存工作单数据");
    }

    /**
     * 获取库存工作单详细信息
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(orderTaskDetailService.selectOrderTaskDetailById(id));
    }

    /**
     * 新增库存工作单
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:add')")
    @Log(title = "库存工作单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderTaskDetail orderTaskDetail)
    {
        return toAjax(orderTaskDetailService.insertOrderTaskDetail(orderTaskDetail));
    }

    /**
     * 修改库存工作单
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:edit')")
    @Log(title = "库存工作单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderTaskDetail orderTaskDetail)
    {
        return toAjax(orderTaskDetailService.updateOrderTaskDetail(orderTaskDetail));
    }

    /**
     * 删除库存工作单
     */
    //@PreAuthorize("@ss.hasPermi('ware:detail:remove')")
    @Log(title = "库存工作单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderTaskDetailService.deleteOrderTaskDetailByIds(ids));
    }
}
