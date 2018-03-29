package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.MemberDto;
import com.formation.infotel.entity.Member;
import com.formation.infotel.services.interfaces.LibraryService;
import com.formation.infotel.services.interfaces.MemberService;
import com.formation.infotel.services.interfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;
	@Autowired
	LibraryService libraryService;
	@Autowired
	RegistrationService registrationService;

	@PostMapping(value = "/member/add")
	public void addMember(@RequestBody MemberDto memberDto) {
		Resultat resultat = new Resultat();

		try {
			Member member = new Member(memberDto.getMemberLastName(), memberDto.getEmail(), memberDto.getPassword(),
					memberDto.getAddress(), memberDto.getCity(), memberDto.getPostalCode(), memberDto.getAccess(),
					memberDto.getPhone(), memberDto.getFirstName());

			memberService.insertMember(member);
			resultat.setMessage(ControllerConstants.INSERT_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.INSERT_ERRORS);
			e.printStackTrace();
		}
	}

	@PostMapping(value = "member/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateMember(@RequestBody MemberDto memberDto, @PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();


		try {

			Member member = memberService.getMember(id);
			member.setMemberLastName(memberDto.getMemberLastName());
			member.setEmail(memberDto.getEmail());
			member.setPassword(memberDto.getPassword());
			member.setAddress(memberDto.getAddress());
			member.setCity(memberDto.getCity());
			member.setPostalCode(memberDto.getPostalCode());
			member.setAccess(memberDto.getAccess());
			member.setPhone(memberDto.getPhone());
			member.setFirstName(memberDto.getFirstName());

			memberService.updateMember(member);
			resultat.setMessage(ControllerConstants.UPDATE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.UPDATE_ERRORS);
			e.printStackTrace();

		}
		return resultat;

	}

	@DeleteMapping("member/delete/{id}")
	public Resultat deleteMember(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();

		try {

			Member member = memberService.getMember(id);

			memberService.deleteMember(member);
			resultat.setMessage(ControllerConstants.DELETE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.DELETE_ERRORS);
			e.printStackTrace();		
			}
		return resultat;
	}

	@RequestMapping("member/get/{id}")
	public Resultat getMember(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();

		MemberDto viewMember = null;
		try {
			Member member = memberService.getMember(id);
			viewMember = new MemberDto(member.getMemberId(), member.getMemberLastName(), member.getFirstName(), member.getEmail(),
					member.getPassword(), member.getAddress(), member.getCity(), member.getPostalCode(),
					member.getPhone(), member.getAccess());
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewMember);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@RequestMapping("member/get")
	public Resultat getMembers() {
		Resultat resultat = new Resultat();


		List<MemberDto> viewMembers = new ArrayList<>();
		List<Member> members;
		try {
			members = memberService.getAllMembers();
			members.forEach(m -> viewMembers.add(new MemberDto(m.getMemberId(), m.getMemberLastName(), m.getFirstName(), m.getEmail(),
					m.getPassword(), m.getAddress(), m.getCity(), m.getPostalCode(), m.getPhone(), m.getAccess())));
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewMembers);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}

		return resultat;
	}
}