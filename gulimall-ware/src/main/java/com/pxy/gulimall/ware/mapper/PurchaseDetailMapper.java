package com.pxy.gulimall.ware.mapper;

import java.util.List;
import com.pxy.gulimall.ware.domain.PurchaseDetail;

/**
 * 采购明细Mapper接口
 * 
 * @author pxy
 * @date 2025-10-22
 */
public interface PurchaseDetailMapper 
{
    /**
     * 查询采购明细
     * 
     * @param id 采购明细主键
     * @return 采购明细
     */
    public PurchaseDetail selectPurchaseDetailById(Long id);

    /**
     * 查询采购明细列表
     * 
     * @param purchaseDetail 采购明细
     * @return 采购明细集合
     */
    public List<PurchaseDetail> selectPurchaseDetailList(PurchaseDetail purchaseDetail);

    /**
     * 新增采购明细
     * 
     * @param purchaseDetail 采购明细
     * @return 结果
     */
    public int insertPurchaseDetail(PurchaseDetail purchaseDetail);

    /**
     * 修改采购明细
     * 
     * @param purchaseDetail 采购明细
     * @return 结果
     */
    public int updatePurchaseDetail(PurchaseDetail purchaseDetail);

    /**
     * 删除采购明细
     * 
     * @param id 采购明细主键
     * @return 结果
     */
    public int deletePurchaseDetailById(Long id);

    /**
     * 批量删除采购明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchaseDetailByIds(Long[] ids);
}
