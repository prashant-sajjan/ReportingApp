package com.prashant.reporting.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prashant.reporting.vo.Test;

@Service
public class ReportingService {

	public List<Test> getAllTests() {
		return getTestsFromFile();
	}
	
	public List<Test> getTestsByID(String id) {
		//Use REST Template to get data from API
		List<Test> testsCompleted = getTestsFromFile();
		List<Test> filteredTests = testsCompleted.stream().filter(t->id.equals(String.valueOf(t.getId()))).collect(Collectors.toList());
		return filteredTests;
	}
	
	private List<Test> getTestsCompleted() {
		List<Test> testsCompleted = new ArrayList<>();
		Test test = new Test(1, "Test 1");
		test.setStepsPassed(5);
		test.setStepsFailed(1);
		testsCompleted.add(test);
		
		test = new Test(2, "Test 2");
		test.setStepsPassed(4);
		test.setStepsFailed(0);
		testsCompleted.add(test);
		
		return testsCompleted;
	}
	
	private List<Test> getTestsFromFile() {
		List<Test> tests = null;
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Test>> typeReference = new TypeReference<List<Test>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/report.json");
		try {
			tests = mapper.readValue(inputStream,typeReference);
		} catch (IOException e){
			System.out.println("Unable to save users: " + e.getMessage());
		}
		
		AtomicInteger index = new AtomicInteger();
		tests.forEach(t->t.setSlNo(index.incrementAndGet()));
		return tests;
	}
}
