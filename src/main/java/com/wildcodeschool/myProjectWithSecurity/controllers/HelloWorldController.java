package com.wildcodeschool.myProjectWithSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String HelloWorld() {
        System.out.println("1 ich war hier 1");
        return "HelloWorld";
    }


    @GetMapping("/avengers/assemble")
	public String assemble() {
System.out.println("2 ich war hier 2");
      return "assemble";
    }

    @GetMapping("/secret-bases")
		public String bases() {
      System.out.println("3 ich war hier 3");
		    return "secret-bases";
	}
  @GetMapping("/unsuficientrights") // unsuficientrights wurde in der config Datei spezifiziert.
  public String unsuficientrights() {
      System.out.println("4 ich war hier 4");
      return "unsuficientrights";
  }
}
