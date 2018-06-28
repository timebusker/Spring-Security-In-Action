package com.timebusker.web;

import com.timebusker.entity.UserInfo;
import com.timebusker.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * @DESC:IndexController
 * @author:timebusker
 * @date:2018/6/23
 */
@Controller
public class IndexController {

    @Autowired
    private UserInfoService service;

    private final static Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @GetMapping({"", "/", "index", "/home"})
    public String index() {
        LOG.info("This is the First Page.");
        return "index";
    }

    @GetMapping({"/login"})
    public String login(String username, String password) {
        LOG.info("登录信息：" + username + "\t" + password);
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return "index";
        }
        Map<String, UserInfo> hu = UserInfoService.addUser(username, password);
        List<UserInfo> lu = new ArrayList<>();
        lu = (List) hu.values();
        return "user";
    }
}
