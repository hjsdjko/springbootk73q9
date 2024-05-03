package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussxianxiahuodongEntity;
import com.entity.view.DiscussxianxiahuodongView;

import com.service.DiscussxianxiahuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 线下活动评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-03 21:46:28
 */
@RestController
@RequestMapping("/discussxianxiahuodong")
public class DiscussxianxiahuodongController {
    @Autowired
    private DiscussxianxiahuodongService discussxianxiahuodongService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxianxiahuodongEntity discussxianxiahuodong,
		HttpServletRequest request){
        EntityWrapper<DiscussxianxiahuodongEntity> ew = new EntityWrapper<DiscussxianxiahuodongEntity>();
		PageUtils page = discussxianxiahuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxianxiahuodong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxianxiahuodongEntity discussxianxiahuodong, 
		HttpServletRequest request){
        EntityWrapper<DiscussxianxiahuodongEntity> ew = new EntityWrapper<DiscussxianxiahuodongEntity>();
		PageUtils page = discussxianxiahuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxianxiahuodong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxianxiahuodongEntity discussxianxiahuodong){
       	EntityWrapper<DiscussxianxiahuodongEntity> ew = new EntityWrapper<DiscussxianxiahuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxianxiahuodong, "discussxianxiahuodong")); 
        return R.ok().put("data", discussxianxiahuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxianxiahuodongEntity discussxianxiahuodong){
        EntityWrapper< DiscussxianxiahuodongEntity> ew = new EntityWrapper< DiscussxianxiahuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxianxiahuodong, "discussxianxiahuodong")); 
		DiscussxianxiahuodongView discussxianxiahuodongView =  discussxianxiahuodongService.selectView(ew);
		return R.ok("查询线下活动评论表成功").put("data", discussxianxiahuodongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxianxiahuodongEntity discussxianxiahuodong = discussxianxiahuodongService.selectById(id);
        return R.ok().put("data", discussxianxiahuodong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxianxiahuodongEntity discussxianxiahuodong = discussxianxiahuodongService.selectById(id);
        return R.ok().put("data", discussxianxiahuodong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxianxiahuodongEntity discussxianxiahuodong, HttpServletRequest request){
    	discussxianxiahuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxianxiahuodong);
        discussxianxiahuodongService.insert(discussxianxiahuodong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxianxiahuodongEntity discussxianxiahuodong, HttpServletRequest request){
    	discussxianxiahuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxianxiahuodong);
        discussxianxiahuodongService.insert(discussxianxiahuodong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussxianxiahuodongEntity discussxianxiahuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxianxiahuodong);
        discussxianxiahuodongService.updateById(discussxianxiahuodong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxianxiahuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussxianxiahuodongEntity> wrapper = new EntityWrapper<DiscussxianxiahuodongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussxianxiahuodongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
