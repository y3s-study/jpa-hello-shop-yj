package org.y3s.jpashop.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.y3s.jpashop.domain.member.Address;
import org.y3s.jpashop.domain.member.Member;
import org.y3s.jpashop.service.MemberService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/new")
    public String createForm() {
        return "member/createMemberForm";
    }

    @PostMapping("/new")
    public String create(String name, String city, String street, String zipcode) {
        Address address = Address.from(city, street, zipcode);
        Member member = new Member(name, address);

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping
    public String memberList(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "member/memberList";
    }

}
