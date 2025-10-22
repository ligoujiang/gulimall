package com.pxy.gulimall.ware.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pxy.gulimall.ware.mapper.OrderTaskDetailMapper;
import com.pxy.gulimall.ware.domain.OrderTaskDetail;
import com.pxy.gulimall.ware.service.IOrderTaskDetailService;

/**
 * 库存工作单Service业务层处理
 * 
 * @author pxy
 * @date 2025-10-22
 */
@Service
public class OrderTaskDetailServiceImpl implements IOrderTaskDetailService 
{
    @Autowired
    private OrderTaskDetailMapper orderTaskDetailMapper;

    /**
     * 查询库存工作单
     * 
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    @Override
    public OrderTaskDetail selectOrderTaskDetailById(Long id)
    {
        return orderTaskDetailMapper.selectOrderTaskDetailById(id);
    }

    /**
     * 查询库存工作单列表
     * 
     * @param orderTaskDetail 库存工作单
     * @return 库存工作单
     */
    @Override
    public List<OrderTaskDetail> selectOrderTaskDetailList(OrderTaskDetail orderTaskDetail)
    {
        return orderTaskDetailMapper.selectOrderTaskDetailList(orderTaskDetail);
    }

    /**
     * 新增库存工作单
     * 
     * @param orderTaskDetail 库存工作单
     * @return 结果
     */
    @Override
    public int insertOrderTaskDetail(OrderTaskDetail orderTaskDetail)
    {
        return orderTaskDetailMapper.insertOrderTaskDetail(orderTaskDetail);
    }

    /**
     * 修改库存工作单
     * 
     * @param orderTaskDetail 库存工作单
     * @return 结果
     */
    @Override
    public int updateOrderTaskDetail(OrderTaskDetail orderTaskDetail)
    {
        return orderTaskDetailMapper.updateOrderTaskDetail(orderTaskDetail);
    }

    /**
     * 批量删除库存工作单
     * 
     * @param ids 需要删除的库存工作单主键
     * @return 结果
     */
    @Override
    public int deleteOrderTaskDetailByIds(Long[] ids)
    {
        return orderTaskDetailMapper.deleteOrderTaskDetailByIds(ids);
    }

    /**
     * 删除库存工作单信息
     * 
     * @param id 库存工作单主键
     * @return 结果
     */
    @Override
    public int deleteOrderTaskDetailById(Long id)
    {
        return orderTaskDetailMapper.deleteOrderTaskDetailById(id);
    }
}
