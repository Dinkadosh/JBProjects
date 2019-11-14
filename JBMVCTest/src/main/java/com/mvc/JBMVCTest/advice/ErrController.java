package com.mvc.JBMVCTest.advice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrController {
	@RequestMapping("convert")
    public int convertToInt(@RequestParam("num") String num) {
        return Integer.parseInt(num);
    }
}
