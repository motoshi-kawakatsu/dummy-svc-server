package server.service.dummy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DummyService {

	@RequestMapping("/")
	@ResponseBody
	public String topPage() {
		return "Dummy Service Server Active";
	}

}
