package com.simonventas.automation.utils;

import org.testng.annotations.Test;

import io.qameta.allure.Step;

public class HogarTest {

	@Step("Test A")
	public void testA() {
		System.out.println("Hogar test A");
	}
	@Step("Test B")
	@Test
	public void testB() {
		System.out.println("Hogar test B");
	}
	@Step("Test C")
	@Test
	public void testC() {
	   System.out.println("Hogar test C");	
	}
	@Step("Test D")
	@Test
	public void testD() {
		System.out.println("Hogar test D");
	}
	
}
