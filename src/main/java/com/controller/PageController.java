package com.controller;

import com.model.Category;
import com.service.CategoryService;
import com.utils.FileUtil;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author Clrvn
 */
@Controller
public class PageController {

    @Autowired
    private CategoryService categoryService;

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

    @GetMapping("/scoreRuleList")
    public String scoreRuleList() {
        return "scoreRuleList";
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

    @GetMapping("/activityList")
    public String activityList() {
        return "activityList";
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
     * 修改个人信息
     */
    @GetMapping("/editMine")
    public String editMine() {
        return "editMine";
    }

    /**
     * 注册
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 订单管理
     */
    @GetMapping("/orderManage")
    public String orderManage() {
        return "orderManage";
    }

    @GetMapping("/orderList")
    public String orderList() {
        return "orderList";
    }

    @GetMapping("/orderAdd")
    public String orderAdd() {
        return "orderAdd";
    }

    @GetMapping("/orderEdit")
    public String orderEdit() {
        return "orderEdit";
    }


    /**
     * 添加菜的种类
     */
    @PostMapping("/saveCate")
    public String save(@RequestParam("img") MultipartFile file, @RequestParam("cateName") String cateName) {
        try {
            Category category = new Category();
            category.setCateName(cateName);

            String fileName = file.getOriginalFilename();

            if (fileName.endsWith(".gif")) {
                fileName = UUID.randomUUID() + ".gif";
            } else if (fileName.endsWith(".jpg")) {
                fileName = UUID.randomUUID() + ".jpg";
            } else if (fileName.endsWith(".png")) {
                fileName = UUID.randomUUID() + ".png";
            } else if (fileName.endsWith(".jpeg")) {
                fileName = UUID.randomUUID() + ".jpeg";
            } else {
                return "activityList";
            }

            //文件上传
            FileUtil.uploadFile(fileName.getBytes(), FileUtil.UPLOAD_PATH + fileName);
            category.setImg(fileName);
            categoryService.save(category);
            return "activityList";
        } catch (Exception ex) {
            return "activityList";
        }
    }
}
