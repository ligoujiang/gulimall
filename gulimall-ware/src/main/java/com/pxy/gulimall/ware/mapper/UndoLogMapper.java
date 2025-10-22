package com.pxy.gulimall.ware.mapper;

import java.util.List;
import com.pxy.gulimall.ware.domain.UndoLog;

/**
 * 撤销日志Mapper接口
 * 
 * @author pxy
 * @date 2025-10-22
 */
public interface UndoLogMapper 
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
     * 删除撤销日志
     * 
     * @param id 撤销日志主键
     * @return 结果
     */
    public int deleteUndoLogById(Long id);

    /**
     * 批量删除撤销日志
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUndoLogByIds(Long[] ids);
}
