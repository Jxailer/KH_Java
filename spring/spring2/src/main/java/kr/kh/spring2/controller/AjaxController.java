package kr.kh.spring2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring2.model.dto.LoginDTO;

@RestController //@Controller + @ResponseBoddy
@RequestMapping("/ajax")
public class AjaxController {
	
	@PostMapping("/json/json")
	public Map<String, Object> jsonJson(@RequestBody LoginDTO member){
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(member);
		map.put("member", member);
		map.put("name", "홍길동");
		return map;
	}
	
	@GetMapping("/object/json")
	public Map<String, Object> obejctJson(
			@RequestParam("id")String id, @RequestParam("name")String name){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("age", 31);
		return map;
	}
	
	@GetMapping("/test")
	public Map<String, Object> test(
			@RequestParam("name")String name, @RequestParam("age")String age){
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		map.put("result", "성공");
		return map;
	}
	
}
