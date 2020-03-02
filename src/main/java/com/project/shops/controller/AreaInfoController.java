package com.project.shops.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.project.shops.model.CareInfo;
import com.project.shops.service.CareInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AreaInfoController {

    @Autowired
    CareInfoService careInfoService;

    @ResponseBody
    @GetMapping("/getCreaInfo")
    public List<CareInfo> getCreaInfo() throws IOException {
        List<CareInfo> creaInfos = careInfoService.getSelectAll();
        return creaInfos;
    }

    @ResponseBody
    @GetMapping("/getCreaInfoById")
    public List<CareInfo> getCreaInfo2() throws IOException {
        List<Integer> id = new LinkedList<>();
        id.add(110000);
        id.add(110100);
        List<CareInfo> creaInfos = careInfoService.getCareById(id);
        //redisTemplate.opsForHash().putAll("creaInfos", creaInfos);
        return creaInfos;
    }

}
