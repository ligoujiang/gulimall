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
import com.pxy.gulimall.ware.domain.UndoLog;
import com.pxy.gulimall.ware.service.IUndoLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 撤销日志Controller
 * 
 * @author pxy
 * @date 2025-10-22
 */
@RestController
@RequestMapping("/ware/undoolog")
public class UndoLogController extends BaseController
{
    @Autowired
    private IUndoLogService undoLogService;

    /**
     * 查询撤销日志列表
     */
    //@PreAuthorize("@ss.hasPermi('ware:undoolog:list')")
    @GetMapping("/list")
    public TableDataInfo list(UndoLog undoLog)
    {
        startPage();
        List<UndoLog> list = undoLogService.selectUndoLogList(undoLog);
        return getDataTable(list);
    }

    /**
     * 导出撤销日志列表
     */
    //@PreAuthorize("@ss.hasPermi('ware:undoolog:export')")
    @Log(title = "撤销日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UndoLog undoLog)
    {
        List<UndoLog> list = undoLogService.selectUndoLogList(undoLog);
        ExcelUtil<UndoLog> util = new ExcelUtil<UndoLog>(UndoLog.class);
        util.exportExcel(response, list, "撤销日志数据");
    }

    /**
     * 获取撤销日志详细信息
     */
    //@PreAuthorize("@ss.hasPermi('ware:undoolog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(undoLogService.selectUndoLogById(id));
    }

    /**
     * 新增撤销日志
     */
    //@PreAuthorize("@ss.hasPermi('ware:undoolog:add')")
    @Log(title = "撤销日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UndoLog undoLog)
    {
        return toAjax(undoLogService.insertUndoLog(undoLog));
    }

    /**
     * 修改撤销日志
     */
    //@PreAuthorize("@ss.hasPermi('ware:undoolog:edit')")
    @Log(title = "撤销日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UndoLog undoLog)
    {
        return toAjax(undoLogService.updateUndoLog(undoLog));
    }

    /**
     * 删除撤销日志
     */
    //@PreAuthorize("@ss.hasPermi('ware:undoolog:remove')")
    @Log(title = "撤销日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(undoLogService.deleteUndoLogByIds(ids));
    }
}
