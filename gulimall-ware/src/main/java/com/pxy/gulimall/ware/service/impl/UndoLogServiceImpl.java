package com.pxy.gulimall.ware.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pxy.gulimall.ware.mapper.UndoLogMapper;
import com.pxy.gulimall.ware.domain.UndoLog;
import com.pxy.gulimall.ware.service.IUndoLogService;

/**
 * 撤销日志Service业务层处理
 * 
 * @author pxy
 * @date 2025-10-22
 */
@Service
public class UndoLogServiceImpl implements IUndoLogService 
{
    @Autowired
    private UndoLogMapper undoLogMapper;

    /**
     * 查询撤销日志
     * 
     * @param id 撤销日志主键
     * @return 撤销日志
     */
    @Override
    public UndoLog selectUndoLogById(Long id)
    {
        return undoLogMapper.selectUndoLogById(id);
    }

    /**
     * 查询撤销日志列表
     * 
     * @param undoLog 撤销日志
     * @return 撤销日志
     */
    @Override
    public List<UndoLog> selectUndoLogList(UndoLog undoLog)
    {
        return undoLogMapper.selectUndoLogList(undoLog);
    }

    /**
     * 新增撤销日志
     * 
     * @param undoLog 撤销日志
     * @return 结果
     */
    @Override
    public int insertUndoLog(UndoLog undoLog)
    {
        return undoLogMapper.insertUndoLog(undoLog);
    }

    /**
     * 修改撤销日志
     * 
     * @param undoLog 撤销日志
     * @return 结果
     */
    @Override
    public int updateUndoLog(UndoLog undoLog)
    {
        return undoLogMapper.updateUndoLog(undoLog);
    }

    /**
     * 批量删除撤销日志
     * 
     * @param ids 需要删除的撤销日志主键
     * @return 结果
     */
    @Override
    public int deleteUndoLogByIds(Long[] ids)
    {
        return undoLogMapper.deleteUndoLogByIds(ids);
    }

    /**
     * 删除撤销日志信息
     * 
     * @param id 撤销日志主键
     * @return 结果
     */
    @Override
    public int deleteUndoLogById(Long id)
    {
        return undoLogMapper.deleteUndoLogById(id);
    }
}
