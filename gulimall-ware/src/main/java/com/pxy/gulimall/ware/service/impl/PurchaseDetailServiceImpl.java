package com.pxy.gulimall.ware.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pxy.gulimall.ware.mapper.PurchaseDetailMapper;
import com.pxy.gulimall.ware.domain.PurchaseDetail;
import com.pxy.gulimall.ware.service.IPurchaseDetailService;

/**
 * 采购明细Service业务层处理
 * 
 * @author pxy
 * @date 2025-10-22
 */
@Service
public class PurchaseDetailServiceImpl implements IPurchaseDetailService 
{
    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    /**
     * 查询采购明细
     * 
     * @param id 采购明细主键
     * @return 采购明细
     */
    @Override
    public PurchaseDetail selectPurchaseDetailById(Long id)
    {
        return purchaseDetailMapper.selectPurchaseDetailById(id);
    }

    /**
     * 查询采购明细列表
     * 
     * @param purchaseDetail 采购明细
     * @return 采购明细
     */
    @Override
    public List<PurchaseDetail> selectPurchaseDetailList(PurchaseDetail purchaseDetail)
    {
        return purchaseDetailMapper.selectPurchaseDetailList(purchaseDetail);
    }

    /**
     * 新增采购明细
     * 
     * @param purchaseDetail 采购明细
     * @return 结果
     */
    @Override
    public int insertPurchaseDetail(PurchaseDetail purchaseDetail)
    {
        return purchaseDetailMapper.insertPurchaseDetail(purchaseDetail);
    }

    /**
     * 修改采购明细
     * 
     * @param purchaseDetail 采购明细
     * @return 结果
     */
    @Override
    public int updatePurchaseDetail(PurchaseDetail purchaseDetail)
    {
        return purchaseDetailMapper.updatePurchaseDetail(purchaseDetail);
    }

    /**
     * 批量删除采购明细
     * 
     * @param ids 需要删除的采购明细主键
     * @return 结果
     */
    @Override
    public int deletePurchaseDetailByIds(Long[] ids)
    {
        return purchaseDetailMapper.deletePurchaseDetailByIds(ids);
    }

    /**
     * 删除采购明细信息
     * 
     * @param id 采购明细主键
     * @return 结果
     */
    @Override
    public int deletePurchaseDetailById(Long id)
    {
        return purchaseDetailMapper.deletePurchaseDetailById(id);
    }
}
