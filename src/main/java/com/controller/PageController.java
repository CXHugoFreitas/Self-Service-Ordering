package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Clrvn
 */
@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("USER");
        session.invalidate();
        session.getServletContext().removeAttribute(session.getId());
        return "login";
    }

    @GetMapping("/index")
    public String index(HttpSession session, Model model) {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     * 餐桌管理
     */
    @GetMapping("/deskManage")
    public String deskManage() {
        return "DeskManage";
    }

    @GetMapping("/deskAdd")
    public String deskAdd() {
        return "DeskAdd";
    }

    @GetMapping("/deskEdit")
    public String deskEdit() {
        return "DeskEdit";
    }

    /**
     * 种类管理
     */
    @GetMapping("/categoryManage")
    public String categoryManage() {
        return "CategoryManage";
    }

    @GetMapping("/categoryAdd")
    public String categoryAdd() {
        return "CategoryAdd";
    }

    @GetMapping("/categoryEdit")
    public String categoryEdit() {
        return "CategoryEdit";
    }

    /**
     * 菜品管理
     */
    @GetMapping("/dishManage")
    public String dishManage() {
        return "DishManage";
    }

    @GetMapping("/dishAdd")
    public String dishAdd() {
        return "DishAdd";
    }

    @GetMapping("/dishEdit")
    public String dishEdit() {
        return "DishEdit";
    }

    /**
     * 积分管理
     */
    @GetMapping("/scoreRuleManage")
    public String scoreRuleManage() {
        return "ScoreRuleManage";
    }

    @GetMapping("/scoreRuleAdd")
    public String scoreRuleAdd() {
        return "ScoreRuleAdd";
    }

    @GetMapping("/scoreRuleEdit")
    public String scoreRuleEdit() {
        return "ScoreRuleEdit";
    }

    /**
     * 活动管理
     */
    @GetMapping("/activityManage")
    public String activityManage() {
        return "ActivityManage";
    }

    @GetMapping("/activityAdd")
    public String activityAdd() {
        return "ActivityAdd";
    }

    @GetMapping("/activityEdit")
    public String activityEdit() {
        return "ActivityEdit";
    }

    /**
     * 用户管理
     */
    @GetMapping("/userManage")
    public String userManage() {
        return "userManage";
    }

    @GetMapping("/userAdd")
    public String userAdd() {
        return "userAdd";
    }

    @GetMapping("/userEdit")
    public String userEdit() {
        return "userEdit";
    }

    /**
     * 订单管理
     */
    @GetMapping("/orderManage")
    public String orderManage() {
        return "orderManage";
    }

    @GetMapping("/orderAdd")
    public String orderAdd() {
        return "orderAdd";
    }

    @GetMapping("/orderEdit")
    public String orderEdit() {
        return "orderEdit";
    }

}
