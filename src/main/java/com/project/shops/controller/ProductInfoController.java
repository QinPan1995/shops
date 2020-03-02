package com.project.shops.controller;

import com.project.shops.model.ProductInfo;
import com.project.shops.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;


@Controller
public class ProductInfoController {

    @Autowired
    ProductInfoService productInfoService;

    @PostMapping("/shops/add_shop")
    public String addShop(ProductInfo productInfo,RedirectAttributes ra){
        ra.addAttribute("name","value");
        productInfoService.save(productInfo);
      return "redirect:/selectAll";
    }

    @GetMapping("/test")
    public String testIndex(String key){
        System.out.println("进入Controller");
        return "index.html";
    }

    @GetMapping("/selectAll")
    public String selectAll(Model model, @RequestParam(value = "name",defaultValue = "null") String name){
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("list",productInfoService.list());
        System.out.println(name);
        model.addAttribute("list",productInfoService.list());
        return "projects.html";
    }

}
