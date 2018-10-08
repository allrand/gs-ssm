package com.auvgo.gsssm.controller;

import com.auvgo.gsssm.entity.InavResult;
import com.auvgo.gsssm.entity.User;
import com.auvgo.gsssm.service.UserSvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserSvc userSvc;

    @RequestMapping("/list")
    public String list(Model model){
        return "list";
    }

    @RequestMapping("/listdata")
    @ResponseBody
    public InavResult<User> getListData(User user){
        InavResult<User> result = new InavResult<>();
        logger.info("listdata user:{} ", user.toString());

        if (user == null || user.getId() == null){
            result.setMsg("listdata null");
            result.setCount(0);
            result.setData(null);
        }else {
            List<User> users = userSvc.getUsers();
            result.setData(users);
            result.setCount(users.size());
            result.setMsg("listdata success");
        }
        result.setCode(0);

        return result;
    }
}
