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
import com.pxy.gulimall.coupon.domain.MemberPrice;
import com.pxy.gulimall.coupon.service.IMemberPriceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品会员价格Controller
 * 
 * @author pxy
 * @date 2025-10-22
 */
@RestController
@RequestMapping("/coupon/price")
public class MemberPriceController extends BaseController
{
    @Autowired
    private IMemberPriceService memberPriceService;

    /**
     * 查询商品会员价格列表
     */
    //@PreAuthorize("@ss.hasPermi('coupon:price:list')")
    @GetMapping("/list")
    public TableDataInfo list(MemberPrice memberPrice)
    {
        startPage();
        List<MemberPrice> list = memberPriceService.selectMemberPriceList(memberPrice);
        return getDataTable(list);
    }

    /**
     * 导出商品会员价格列表
     */
    //@PreAuthorize("@ss.hasPermi('coupon:price:export')")
    @Log(title = "商品会员价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberPrice memberPrice)
    {
        List<MemberPrice> list = memberPriceService.selectMemberPriceList(memberPrice);
        ExcelUtil<MemberPrice> util = new ExcelUtil<MemberPrice>(MemberPrice.class);
        util.exportExcel(response, list, "商品会员价格数据");
    }

    /**
     * 获取商品会员价格详细信息
     */
    //@PreAuthorize("@ss.hasPermi('coupon:price:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(memberPriceService.selectMemberPriceById(id));
    }

    /**
     * 新增商品会员价格
     */
    //@PreAuthorize("@ss.hasPermi('coupon:price:add')")
    @Log(title = "商品会员价格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberPrice memberPrice)
    {
        return toAjax(memberPriceService.insertMemberPrice(memberPrice));
    }

    /**
     * 修改商品会员价格
     */
    //@PreAuthorize("@ss.hasPermi('coupon:price:edit')")
    @Log(title = "商品会员价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberPrice memberPrice)
    {
        return toAjax(memberPriceService.updateMemberPrice(memberPrice));
    }

    /**
     * 删除商品会员价格
     */
    //@PreAuthorize("@ss.hasPermi('coupon:price:remove')")
    @Log(title = "商品会员价格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(memberPriceService.deleteMemberPriceByIds(ids));
    }
}
