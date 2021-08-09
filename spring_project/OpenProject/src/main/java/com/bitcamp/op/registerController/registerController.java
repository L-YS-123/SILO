package com.bitcamp.op.registerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op.member.domain.Member;

@Controller
@RequestMapping("/member/register")
@ComponentScan
@Configuration
public class registerController {

	@Autowired
	Member member;
	
}
