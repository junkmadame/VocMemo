package com.example.vocomemo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VocMemoApplication {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 SpringApplication.run(VocMemoApplication.class, args);  // 啟動 Spring Boot 應用
		 
		 String url = "http://localhost:8080";
		 String os = System.getProperty("os.name").toLowerCase();
		 // 嘗試開啟瀏覽器
		 try {
		     Thread.sleep(2000);
		     if (os.contains("win")) {
		         new ProcessBuilder("rundll32", "url.dll,FileProtocolHandler", url).start();
		     } else if (os.contains("mac")) {
		         new ProcessBuilder("open", url).start();
		     } else if (os.contains("nix") || os.contains("nux")) {
		         new ProcessBuilder("xdg-open", url).start();
		     } else {
		         System.out.println("Cannot detect your operating system：" + os);
		     }
		 } catch (Exception e) {
		     System.out.println("Failed to open browser：" + e.getMessage());
		 }
	}
}
