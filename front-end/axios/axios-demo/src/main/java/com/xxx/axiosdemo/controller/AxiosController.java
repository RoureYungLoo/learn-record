package com.xxx.axiosdemo.controller;

import com.xxx.axiosdemo.pojo.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/axios")
public class AxiosController {
  public static final Logger logger = LoggerFactory.getLogger(AxiosController.class);

  @GetMapping("/get/reqbody")
  public Article getRequestBody(@RequestBody Article article) {
    logger.info("/axios/get/reqbody getRequestBody{}", article);
    return article;
  }
}
