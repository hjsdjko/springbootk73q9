package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussxianxiahuodongDao;
import com.entity.DiscussxianxiahuodongEntity;
import com.service.DiscussxianxiahuodongService;
import com.entity.vo.DiscussxianxiahuodongVO;
import com.entity.view.DiscussxianxiahuodongView;

@Service("discussxianxiahuodongService")
public class DiscussxianxiahuodongServiceImpl extends ServiceImpl<DiscussxianxiahuodongDao, DiscussxianxiahuodongEntity> implements DiscussxianxiahuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxianxiahuodongEntity> page = this.selectPage(
                new Query<DiscussxianxiahuodongEntity>(params).getPage(),
                new EntityWrapper<DiscussxianxiahuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxianxiahuodongEntity> wrapper) {
		  Page<DiscussxianxiahuodongView> page =new Query<DiscussxianxiahuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxianxiahuodongVO> selectListVO(Wrapper<DiscussxianxiahuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxianxiahuodongVO selectVO(Wrapper<DiscussxianxiahuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxianxiahuodongView> selectListView(Wrapper<DiscussxianxiahuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxianxiahuodongView selectView(Wrapper<DiscussxianxiahuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
