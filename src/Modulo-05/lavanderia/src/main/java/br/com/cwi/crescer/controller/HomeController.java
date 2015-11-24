package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({ "/", "/home", "/index" })
	public String index(Model model) {
		return "home/index";
	}
}