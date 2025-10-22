package com.pxy.gulimall.ware.service;

import java.util.List;
import com.pxy.gulimall.ware.domain.UndoLog;

/**
 * 撤销日志Service接口
 * 
 * @author pxy
 * @date 2025-10-22
 */
public interface IUndoLogService 
{
    /**
     * 查询撤销日志
     * 
     * @param id 撤销日志主键
     * @return 撤销日志
     */
    public UndoLog selectUndoLogById(Long id);

    /**
     * 查询撤销日志列表
     * 
     * @param undoLog 撤销日志
     * @return 撤销日志集合
     */
    public List<UndoLog> selectUndoLogList(UndoLog undoLog);

    /**
     * 新增撤销日志
     * 
     * @param undoLog 撤销日志
     * @return 结果
     */
    public int insertUndoLog(UndoLog undoLog);

    /**
     * 修改撤销日志
     * 
     * @param undoLog 撤销日志
     * @return 结果
     */
    public int updateUndoLog(UndoLog undoLog);

    /**
     * 批量删除撤销日志
     * 
     * @param ids 需要删除的撤销日志主键集合
     * @return 结果
     */
    public int deleteUndoLogByIds(Long[] ids);

    /**
     * 删除撤销日志信息
     * 
     * @param id 撤销日志主键
     * @return 结果
     */
    public int deleteUndoLogById(Long id);
}
