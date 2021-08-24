package com.example.demo;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String demo() {
		Properties properties = System.getProperties();

		Set<Entry<Object, Object>> s = properties.entrySet();
		
		Iterator<Map.Entry<Object, Object>> itr = s.iterator();
		
		String str = "";
		
		while(itr.hasNext())
		{
			Entry<Object, Object> entry = itr.next();
			
			String key =   (String) entry.getKey();
			String value =  (String) entry.getValue();
			
			str += key +"->"+ value +"\n";
		}
		return "java and spring installed" + str;
	}

	@GetMapping("/exception")
	public RedirectView demo1() {
		int i = 5, j = 0;

		try {
			i = i / j;
		} catch (ArithmeticException e) {
			RedirectView rv = new RedirectView();
			rv.setUrl("http://localhost:8080");
			return rv;
		}
		return null;

	}

}
