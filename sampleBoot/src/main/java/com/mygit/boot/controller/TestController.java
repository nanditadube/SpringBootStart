package com.mygit.boot.controller;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mygit.boot.dao.impl.FetchDaoImpl;
import com.mygit.boot.entity.ServerConfig;

@Controller
public class TestController {
	@Value("${welcome.message}")
	private String message;
	
	@Autowired
    DataSource dataSource;
	
	@Autowired
	private FetchDaoImpl fetchDao;
	
	@RequestMapping("/test")
	@ResponseBody
	public String print() {
		
		ServerConfig l=fetchDao.fetchById(1L);
		return l.getConfValue();
	}
	
	@RequestMapping(value = "message", method = RequestMethod.GET)
    public ModelAndView messages() {
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("messages", fetchDao.findAllConfig());
        return mav;
    }

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
}
