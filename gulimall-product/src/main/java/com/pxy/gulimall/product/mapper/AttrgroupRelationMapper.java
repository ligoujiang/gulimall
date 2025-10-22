package com.pxy.gulimall.product.mapper;

import java.util.List;
import com.pxy.gulimall.product.domain.AttrgroupRelation;

/**
 * 属性&属性分组关联Mapper接口
 * 
 * @author pxy
 * @date 2025-10-21
 */
public interface AttrgroupRelationMapper 
{
    /**
     * 查询属性&属性分组关联
     * 
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    public AttrgroupRelation selectAttrgroupRelationById(Long id);

    /**
     * 查询属性&属性分组关联列表
     * 
     * @param attrgroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联集合
     */
    public List<AttrgroupRelation> selectAttrgroupRelationList(AttrgroupRelation attrgroupRelation);

    /**
     * 新增属性&属性分组关联
     * 
     * @param attrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    public int insertAttrgroupRelation(AttrgroupRelation attrgroupRelation);

    /**
     * 修改属性&属性分组关联
     * 
     * @param attrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    public int updateAttrgroupRelation(AttrgroupRelation attrgroupRelation);

    /**
     * 删除属性&属性分组关联
     * 
     * @param id 属性&属性分组关联主键
     * @return 结果
     */
    public int deleteAttrgroupRelationById(Long id);

    /**
     * 批量删除属性&属性分组关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAttrgroupRelationByIds(Long[] ids);
}
