package com.pxy.gulimall.product.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pxy.gulimall.product.mapper.AttrgroupRelationMapper;
import com.pxy.gulimall.product.domain.AttrgroupRelation;
import com.pxy.gulimall.product.service.IAttrgroupRelationService;

/**
 * 属性&属性分组关联Service业务层处理
 * 
 * @author pxy
 * @date 2025-10-21
 */
@Service
public class AttrgroupRelationServiceImpl implements IAttrgroupRelationService 
{
    @Autowired
    private AttrgroupRelationMapper attrgroupRelationMapper;

    /**
     * 查询属性&属性分组关联
     * 
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    @Override
    public AttrgroupRelation selectAttrgroupRelationById(Long id)
    {
        return attrgroupRelationMapper.selectAttrgroupRelationById(id);
    }

    /**
     * 查询属性&属性分组关联列表
     * 
     * @param attrgroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联
     */
    @Override
    public List<AttrgroupRelation> selectAttrgroupRelationList(AttrgroupRelation attrgroupRelation)
    {
        return attrgroupRelationMapper.selectAttrgroupRelationList(attrgroupRelation);
    }

    /**
     * 新增属性&属性分组关联
     * 
     * @param attrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int insertAttrgroupRelation(AttrgroupRelation attrgroupRelation)
    {
        return attrgroupRelationMapper.insertAttrgroupRelation(attrgroupRelation);
    }

    /**
     * 修改属性&属性分组关联
     * 
     * @param attrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int updateAttrgroupRelation(AttrgroupRelation attrgroupRelation)
    {
        return attrgroupRelationMapper.updateAttrgroupRelation(attrgroupRelation);
    }

    /**
     * 批量删除属性&属性分组关联
     * 
     * @param ids 需要删除的属性&属性分组关联主键
     * @return 结果
     */
    @Override
    public int deleteAttrgroupRelationByIds(Long[] ids)
    {
        return attrgroupRelationMapper.deleteAttrgroupRelationByIds(ids);
    }

    /**
     * 删除属性&属性分组关联信息
     * 
     * @param id 属性&属性分组关联主键
     * @return 结果
     */
    @Override
    public int deleteAttrgroupRelationById(Long id)
    {
        return attrgroupRelationMapper.deleteAttrgroupRelationById(id);
    }
}
