package com.dao;

import com.entity.XianxiahuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XianxiahuodongVO;
import com.entity.view.XianxiahuodongView;


/**
 * 线下活动
 * 
 * @author 
 * @email 
 * @date 2022-04-03 21:46:28
 */
public interface XianxiahuodongDao extends BaseMapper<XianxiahuodongEntity> {
	
	List<XianxiahuodongVO> selectListVO(@Param("ew") Wrapper<XianxiahuodongEntity> wrapper);
	
	XianxiahuodongVO selectVO(@Param("ew") Wrapper<XianxiahuodongEntity> wrapper);
	
	List<XianxiahuodongView> selectListView(@Param("ew") Wrapper<XianxiahuodongEntity> wrapper);

	List<XianxiahuodongView> selectListView(Pagination page,@Param("ew") Wrapper<XianxiahuodongEntity> wrapper);
	
	XianxiahuodongView selectView(@Param("ew") Wrapper<XianxiahuodongEntity> wrapper);
	

}
