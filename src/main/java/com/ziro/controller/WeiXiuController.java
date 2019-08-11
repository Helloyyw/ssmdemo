package com.ziro.controller;

import com.ziro.entity.TelPhoneEntity;
import com.ziro.entity.UserEntity;
import com.ziro.entity.WeiXiuEntity;
import com.ziro.service.UserService;
import com.ziro.utils.JsonData;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/weixiu")
public class WeiXiuController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/one")
    public ModelAndView findByName() {
        ModelAndView modelAndView = new ModelAndView();
        List<WeiXiuEntity> all = userService.findAll();
        //String list = JsonMapper.obj2String(all);
        modelAndView.addObject("all", all);
        modelAndView.setViewName("one");
        return modelAndView;
    }

    //    加载所有联系人
    @RequestMapping(value = "/tellist")
    public ModelAndView telList() {
        ModelAndView modelAndView = new ModelAndView();
        List<TelPhoneEntity> all = userService.findAllPerson();
        modelAndView.addObject("all", all);
        modelAndView.setViewName("one");
        return modelAndView;
    }

    //  按条件搜索联系人
    @RequestMapping(value = "/findTel")
    public ModelAndView findTel(@RequestParam("name") String name, @RequestParam("phone") String phone) {
        System.out.println(name + "=======" + phone);

        String name1 = "%" + name + "%";
        ModelAndView modelAndView = new ModelAndView();
        if (!name.equals("") && !phone.equals("")) {
            List<TelPhoneEntity> byName = userService.findByName(name1, phone);
            modelAndView.addObject("all", byName);
            modelAndView.setViewName("one");
            return modelAndView;
        } else {
            if (!name.equals("")) {
                List<TelPhoneEntity> byName1 = userService.findByName1(name1);
                modelAndView.addObject("all", byName1);
            }
            if (!phone.equals("")) {
                List<TelPhoneEntity> byName2 = userService.findByName2(phone);
                modelAndView.addObject("all", byName2);
            }

        }
        return new ModelAndView("one");
    }

    //查询
    @ResponseBody
    @RequestMapping(value = "/type")
    public ModelAndView findByName(@RequestParam("type") String type) {
        System.out.println("=======" + type);
        List<WeiXiuEntity> byName = userService.findByType(type);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("all", byName);
        modelAndView.setViewName("one1");
        return modelAndView;
    }

    //添加
    @RequestMapping(value = "add1", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonData sss(@RequestBody WeiXiuEntity entity) {
        entity.getCuoshi().trim();
        entity.getHouguo().trim();
        entity.getYuanyin().trim();
        System.out.println(entity);
        return JsonData.success(userService.addData(entity));
    }


    //添加
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonData doLogin(@RequestBody String form, HttpSession request) {
        JSONObject jo = JSONObject.parseObject(new String(form));
        String name = (String) jo.get("name");
        String pwd = (String) jo.get("pwd");
        System.out.println(name + "==" + pwd);
        UserEntity check = userService.check(name, pwd);
        request.setAttribute("user", check);
        if (check != null || check.equals("")) {
            return JsonData.success(check);
        }
        return JsonData.fail("失败");
    }

    //删除联系人
    @RequestMapping(value="delete",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id){
        int check = userService.delete(Integer.parseInt(id));
        if(check == 1){
            return JsonData.fail("删除成功");
        }
        return JsonData.fail("删除失败");
    }
    //修改联系人
    @RequestMapping(value="Update",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ResponseBody
    public JsonData Update(String id ,String name ,String sex,String phone,String text){
        int check = userService.Update(id,name,sex,phone,text);
        if(check == 1){
            return JsonData.fail("修改成功");
        }
        return JsonData.fail("修改失败");
    }
    //添加联系人
    @RequestMapping(value="Update",method = RequestMethod.POST,produces="application/json;charset=UTF-8",consumes="application/json;charset=UTF-8")
    @ResponseBody
    public JsonData Update(String id ,String name ,String sex,String phone,String text){
        int check = userService.Update(id,name,sex,phone,text);
        if(check == 1){
            return JsonData.fail("修改成功");
        }
        return JsonData.fail("修改失败");
    }
}
