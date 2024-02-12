package kr.kh.account.controller;

import java.util.Scanner;

public class AccountController {
	private Scanner scan;
	
	public AccountController(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
	}
}
