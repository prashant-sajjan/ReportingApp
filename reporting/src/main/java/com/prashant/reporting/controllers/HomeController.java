package com.prashant.reporting.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.prashant.reporting.services.ReportingService;
import com.prashant.reporting.vo.Test;

@Controller
public class HomeController {

  @Autowired
  private ReportingService rptService;

  @GetMapping("/home")
  public String home(final Model model) {
	  List<Test> testsCompleted = rptService.getAllTests();
	  Map<String, List<Test>> testMap = new HashMap<>();
	  testMap.put("tests", testsCompleted);
	  model.addAttribute("testObject", testMap);
	  return "SummaryReport";
  }
  
  @GetMapping("/searchReport")
  public String test(@RequestParam(name = "id", required = false, defaultValue = "1") String id, final Model model) {
	  List<Test> filteredTests = rptService.getTestsByID(id);
	  model.addAttribute("tests", filteredTests);
      return "TestResult";
  }
}
