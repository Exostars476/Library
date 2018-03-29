package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.MemberDto;
import com.formation.infotel.entity.Member;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.services.interfaces.LoginService;
import com.formation.infotel.services.interfaces.MemberService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController extends HttpServlet {

	@Autowired
	MemberService memberService;
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	private Resultat connexionMembre(@RequestBody InformationVM identifiants, HttpServletRequest request) {
		
		Resultat resultat = new Resultat();
		try {
			Member member = loginService.Login(identifiants.getEmail(), identifiants.getPassword());

			if (member!=null) {
				HttpSession session = request.getSession();
				MemberDto viewMember = new MemberDto(member.getMemberId(), member.getMemberLastName(), member.getFirstName(), member.getEmail(),
						member.getPassword(), member.getAddress(), member.getCity(), member.getPostalCode(), member.getPhone(), member.getAccess());
				session.setAttribute("USER", viewMember);
				resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);
				resultat.setSuccess(true);
				resultat.setPayload(viewMember);
			}
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());

		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERRORS);
			e.printStackTrace();

		}
		return resultat;
	}

	@RequestMapping(value = "/member/logout", method = RequestMethod.POST)
	private Resultat logoutMember(HttpServletRequest request){

		Resultat resultat = new Resultat();
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			resultat.setMessage(ControllerConstants.LOGOUT_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGOUT_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	/*@RequestMapping("/loginCheckk")
	public String login(HttpServletRequest request) {

		String pageToReturn = "";
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		boolean success = memberService.userExist(login, password);

		if (success) {
			HttpSession session = request.getSession();
			int access = memberService.getMemberByEmail(login).getAccess();
			switch (access) {
			case 1:
				session.setAttribute("access", "admin");
				break;
			case 2:
				session.setAttribute("access", "user");
				break;
			}
			session.setAttribute("name", login);
			pageToReturn = "index";
		} else {
			pageToReturn = "loginPages/login";
		}

		return pageToReturn;
	}*/
}
