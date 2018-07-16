package org.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping(value = "control_1")
public class HelloController {

	@RequestMapping(value = "control_1")
	public String hello() {
		return "welcome";
	}

	@RequestMapping(value = "control2")
	public String userForm() {
		return "UserForm";
	}

	@RequestMapping(value = "control2", method = RequestMethod.POST)
	public String userResult(HttpServletRequest req, Model model,
			HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		String target = "";
		if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
			out.print("<font color='red' size='5'>Id is null or blank</font> ");
			return null;
		} else if (req.getParameter("name") == null
				|| req.getParameter("name").isEmpty()) {
			out.print("<font color='red' size='5'>Name is null or blank</font> ");
			return null;
		} else if (req.getParameter("name").length() < 5) {
			out.print("<font color='red' size='5'>Name length is less than 5 chars </font> ");
			return null;
		} else if (req.getParameter("salary") == null
				|| req.getParameter("salary").isEmpty()) {
			out.print("<font color='red' size='5'>salary  is null or blank</font> ");
			return null;
		} else if (Float.parseFloat(req.getParameter("salary")) <= 0) {
			out.print("<font color='red' size='5'>salary <=0</font> ");
			return null;
		} else {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			float salary = Float.parseFloat(req.getParameter("salary"));

			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setSalary(salary);

			model.addAttribute("user", user);
			return "UserResult";
		}
	}

}
