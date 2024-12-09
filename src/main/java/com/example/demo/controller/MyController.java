package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/API/mycontroller")
@RestController
public class MyController {
	
	@GetMapping("/greaterNumber/{num1}/{num2}")
	public Map greaterNumber(@PathVariable int num1,@PathVariable int num2) {
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		String result = "Greater number is ";
		
		if(num1>num2) {
			map.put("Greater Number", num1);
			map.put("Smaller Number", num2);
			return map;
		}else if(num2>num1) {
			map.put("Greater Number", num2);
			map.put("Smaller Number", num1);
			return map;
		}else {
			map.put("Both are equal", num1);
			return map;
		}
		
		
		
	}
	
	@GetMapping("/evenOdd")
    public Map separateNumbers(@RequestParam List<Integer> numbers) {
        // Separate the numbers into even and odd lists
		Map<String,List<Integer>> map = new HashMap<>();
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());

        List<Integer> oddNumbers = numbers.stream()
                                          .filter(n -> n % 2 != 0)
                                          .collect(Collectors.toList());

        // Return the result as a response
        map.put("EVEN NUMBERS", evenNumbers);
        map.put("ODD NUMBERS", oddNumbers);
        return map;
    }

}
