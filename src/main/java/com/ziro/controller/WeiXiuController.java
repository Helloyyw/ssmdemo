package com.ziro.controller;

import com.ziro.entity.WeiXiuEntity;
import com.ziro.service.UserService;
import com.ziro.utils.JsonData;
import com.ziro.utils.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/weixiu")
public class WeiXiuController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/one")
    public ModelAndView findByName(){
        ModelAndView modelAndView = new ModelAndView();
        List<WeiXiuEntity> all = userService.findAll();
        //String list = JsonMapper.obj2String(all);
        modelAndView.addObject("all",all);
        modelAndView.setViewName("one");
        System.out.println(all+"000000000");
        return modelAndView;
    }
    @RequestMapping(value = "/one1")
    public ModelAndView findByNameAndtype(@RequestParam("name") String name,@RequestParam("type")String type){
        System.out.println(name+"======="+type);
        String name1 = "%"+name+"%";
        List<WeiXiuEntity> byName = userService.findByName(name1, type);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("all",byName);
        modelAndView.setViewName("one1");
        return modelAndView;
    }
    //查询
    @ResponseBody
    @RequestMapping(value = "/type")
    public  ModelAndView  findByName(@RequestParam("type")String type){
        System.out.println("======="+type);
        List<WeiXiuEntity> byName = userService.findByType(type);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("all",byName);
        modelAndView.setViewName("one1");
        return modelAndView;
    }
    //添加
    @RequestMapping(value="add1",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ResponseBody
    public JsonData sss(@RequestBody WeiXiuEntity entity){
                entity.getCuoshi().trim();
                 entity.getHouguo().trim();
                 entity.getYuanyin().trim();
                  System.out.println(entity);
        return JsonData.success(userService.addData(entity));
    }


    @RequestMapping(value = "/add")
    public String add(){
        return "add";
    }

}
