package com.gpupu.bjcpapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class OtherExampleController {
 
  @RequestMapping("/somePath")
  public String requestResponseExample(HttpServletRequest request,
          HttpServletResponse responses, Model model) {
 
      // Todo something here
 
      return "someView";
  }
 

}