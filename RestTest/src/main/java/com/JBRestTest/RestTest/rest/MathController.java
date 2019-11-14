package com.JBRestTest.RestTest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("math")
public class MathController {

	@GetMapping("max/{a}/{b}/{c}")
	public int getMaxNumber(@PathVariable(name = "a") String a, @PathVariable(name = "a") String b,
			@PathVariable(name = "c") String c) {
		int n1 = Integer.parseInt(a);
		int n2 = Integer.parseInt(b);
		int n3 = Integer.parseInt(c);

		return Math.max(n1, Math.max(n2, n3));
	}

	@GetMapping("sum")
	public int getSum(@RequestParam(name = "a") String a, @RequestParam(name = "b") String b) {
		int n1 = Integer.parseInt(a);
		int n2 = Integer.parseInt(b);

		return n1 + n2;
	}

}
