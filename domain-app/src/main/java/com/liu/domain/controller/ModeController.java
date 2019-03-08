package com.liu.domain.controller;

import com.liu.domain.base.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxinghong
 * @Description:
 * @date 2019/3/5/00510:44
 */
@RestController
@RequestMapping("/app_demo")
public class ModeController extends BaseController {

    @GetMapping(value = "/demo1/{aat}")
    private Object demo1(@PathVariable("aat") String as){

        return success("调用成功！");
    }
}
