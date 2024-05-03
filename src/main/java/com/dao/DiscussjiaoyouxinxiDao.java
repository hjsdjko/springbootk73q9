package com.dao;

import com.entity.DiscussjiaoyouxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiaoyouxinxiVO;
import com.entity.view.DiscussjiaoyouxinxiView;


/**
 * 交友信息评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-03 21:46:28
 */
public interface DiscussjiaoyouxinxiDao extends BaseMapper<DiscussjiaoyouxinxiEntity> {
	
	List<DiscussjiaoyouxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussjiaoyouxinxiEntity> wrapper);
	
	DiscussjiaoyouxinxiVO selectVO(@Param("ew") Wrapper<DiscussjiaoyouxinxiEntity> wrapper);
	
	List<DiscussjiaoyouxinxiView> selectListView(@Param("ew") Wrapper<DiscussjiaoyouxinxiEntity> wrapper);

	List<DiscussjiaoyouxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiaoyouxinxiEntity> wrapper);
	
	DiscussjiaoyouxinxiView selectView(@Param("ew") Wrapper<DiscussjiaoyouxinxiEntity> wrapper);
	

}
