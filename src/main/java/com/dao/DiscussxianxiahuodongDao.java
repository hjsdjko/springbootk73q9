package com.dao;

import com.entity.DiscussxianxiahuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxianxiahuodongVO;
import com.entity.view.DiscussxianxiahuodongView;


/**
 * 线下活动评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-03 21:46:28
 */
public interface DiscussxianxiahuodongDao extends BaseMapper<DiscussxianxiahuodongEntity> {
	
	List<DiscussxianxiahuodongVO> selectListVO(@Param("ew") Wrapper<DiscussxianxiahuodongEntity> wrapper);
	
	DiscussxianxiahuodongVO selectVO(@Param("ew") Wrapper<DiscussxianxiahuodongEntity> wrapper);
	
	List<DiscussxianxiahuodongView> selectListView(@Param("ew") Wrapper<DiscussxianxiahuodongEntity> wrapper);

	List<DiscussxianxiahuodongView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxianxiahuodongEntity> wrapper);
	
	DiscussxianxiahuodongView selectView(@Param("ew") Wrapper<DiscussxianxiahuodongEntity> wrapper);
	

}
