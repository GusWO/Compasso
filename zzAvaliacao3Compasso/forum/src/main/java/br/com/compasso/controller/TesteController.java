package br.com.compasso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TesteController {

	@RequestMapping("/")
	@ResponseBody
	public String teste() {
		return "testando";
	}
}
