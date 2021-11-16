package com.poseidon.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.webapp.proxy.UserProxy;

@Controller
@RequestMapping("app")
public class LoginController {

    @Autowired
    private UserProxy userProxy;

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

	/*
	 * @GetMapping("secure/article-details") public ModelAndView
	 * getAllUserArticles() { ModelAndView mav = new ModelAndView();
	 * mav.addObject("users", userProxy.getUsers()); mav.setViewName("user/list");
	 * return mav; }
	 */

    @GetMapping("error")
    public ModelAndView error() {
        ModelAndView mav = new ModelAndView();
        String errorMessage= "You are not authorized for the requested data.";
        mav.addObject("errorMsg", errorMessage);
        mav.setViewName("403");
        return mav;
    }
}
