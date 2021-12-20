package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;



@Log4j
@RequestMapping("/sample/*") 
@Controller
public class SampleController {

  
  @GetMapping("/all")
  public void doAll() {
    
    log.info("do all can access everybody");
    log.info("시큐리티 세계에 오신것을 환영합니다!");
  }
  
  @GetMapping("/member")
  public void doMember() {
    
    log.info("logined member");
  }
  
  @GetMapping("/admin")
  public void doAdmin() {
    
    log.info("admin only");
  }  
  
 
  
}
