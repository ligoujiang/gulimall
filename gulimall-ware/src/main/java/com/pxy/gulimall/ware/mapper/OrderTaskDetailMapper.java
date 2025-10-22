package com.pxy.gulimall.ware.mapper;

import java.util.List;
import com.pxy.gulimall.ware.domain.OrderTaskDetail;

/**
 * 库存工作单Mapper接口
 * 
 * @author pxy
 * @date 2025-10-22
 */
public interface OrderTaskDetailMapper 
{
    /**
     * 查询库存工作单
     * 
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    public OrderTaskDetail selectOrderTaskDetailById(Long id);

    /**
     * 查询库存工作单列表
     * 
     * @param orderTaskDetail 库存工作单
     * @return 库存工作单集合
     */
    public List<OrderTaskDetail> selectOrderTaskDetailList(OrderTaskDetail orderTaskDetail);

    /**
     * 新增库存工作单
     * 
     * @param orderTaskDetail 库存工作单
     * @return 结果
     */
    public int insertOrderTaskDetail(OrderTaskDetail orderTaskDetail);

    /**
     * 修改库存工作单
     * 
     * @param orderTaskDetail 库存工作单
     * @return 结果
     */
    public int updateOrderTaskDetail(OrderTaskDetail orderTaskDetail);

    /**
     * 删除库存工作单
     * 
     * @param id 库存工作单主键
     * @return 结果
     */
    public int deleteOrderTaskDetailById(Long id);

    /**
     * 批量删除库存工作单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderTaskDetailByIds(Long[] ids);
}
