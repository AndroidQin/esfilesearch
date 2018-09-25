package cn.pan.controller;

import cn.pan.service.EsRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    EsRestService restService;

    @RequestMapping("/")
    public String index() {

        return "index";
    }


    @RequestMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {

        String[] searchields = {"title", "filecontent"};

        ArrayList<Map<String, Object>> fileList = restService.searchDocs("userdoc",
                keyword,
                searchields, 1, 10);


       // System.out.println(fileList);
        model.addAttribute("flist", fileList);

        return "result";
    }
}
