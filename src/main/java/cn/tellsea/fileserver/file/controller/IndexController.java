package cn.tellsea.fileserver.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试页面
 *
 * @author Tellsea
 * @date 2020/4/11
 */
@Controller
public class IndexController {

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }
}
