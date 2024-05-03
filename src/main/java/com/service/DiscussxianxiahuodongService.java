package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxianxiahuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxianxiahuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxianxiahuodongView;


/**
 * 线下活动评论表
 *
 * @author 
 * @email 
 * @date 2022-04-03 21:46:28
 */
public interface DiscussxianxiahuodongService extends IService<DiscussxianxiahuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxianxiahuodongVO> selectListVO(Wrapper<DiscussxianxiahuodongEntity> wrapper);
   	
   	DiscussxianxiahuodongVO selectVO(@Param("ew") Wrapper<DiscussxianxiahuodongEntity> wrapper);
   	
   	List<DiscussxianxiahuodongView> selectListView(Wrapper<DiscussxianxiahuodongEntity> wrapper);
   	
   	DiscussxianxiahuodongView selectView(@Param("ew") Wrapper<DiscussxianxiahuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxianxiahuodongEntity> wrapper);
   	

}

