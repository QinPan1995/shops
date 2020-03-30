package com.project.shops.controller;

import com.project.shops.model.ProductInfo;
import com.project.shops.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
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
    @GetMapping("/employee/File/download")
    public String  testDownload(HttpServletResponse response , Model model) throws UnsupportedEncodingException {
        //待下载文件名
        String fileName = "12.pdf";
        //设置为png格式的文件
        /*response.setHeader("content-type", "image/png");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);*/
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","attachment;filename=" + new String(fileName.getBytes(), "iso8859-1"));
        return "employee/EmployeeDownloadFile";
    }
    @RequestMapping(value="/downloadFile")
    public void downloadFile(HttpServletResponse response) throws UnsupportedEncodingException {
        String downloadFilePath = "D:/image/";	//被下载的文件在服务器中的路径,
        String fileName = "test7.pdf";			//被下载文件的名称

        //File file = new File("http://121.199.28.69:30001/collector/summarypdf/IT部周例会-1584929445379.pdf");
        File file = new File(downloadFilePath+fileName);
        /*response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(bis != null) {
                    try {
                        bis.close();
                    }catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                if(fis != null) {
                    try {
                        fis.close();
                    }catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }*/
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "utf-8"));
        try {
            InputStream inStream = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] buff = new byte[1024];
            int i = 0;
            //read方法返回读取到字节数，=0说明到达文件结尾，=-1说明发生错误
            while ((i = inStream.read(buff)) != -1) {
                //write()方法3个参数，可自定义读取字节数0-i;
                os.write(buff, 0, i);
            }
            os.flush();
            os.close();
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
