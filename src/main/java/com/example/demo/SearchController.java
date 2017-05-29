package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

	@GetMapping
	List<Object> requestParam(@Validated @ModelAttribute SearchCriteria criteria) {
		return Arrays.asList(criteria);
	}

	@PostMapping
	List<Object> requestBody(@Validated @RequestBody SearchCriteria criteria) {
		return Arrays.asList(criteria);
	}
}
