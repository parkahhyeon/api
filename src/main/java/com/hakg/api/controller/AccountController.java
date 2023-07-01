package com.hakg.api.controller;

import com.hakg.api.domain.Member;
import com.hakg.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;    // 필드 주입

    /*
    * 생성자 주입
     private final AccountService accountService;
        public UserController(AccountService accountService) {
            this.accountService = accountService;
        }
    * */

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("member", new Member());
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("member", new Member());     // 회원가입을 위한  빈 Member 객체를 모델에 추가
        return "signup";    // 회원가입 페이지로 이동하는 뷰 이름
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute("user") @Validated Member member,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";    // 회원가입 폼 유효성 검사 실패 시 다시 회원가입 페이지로 이동하는 뷰 이름
        }

        // 회원가입 로직 실행
        accountService.signup(member);
        return "redirect:/login";   // 회원가입 성공 시 로그인 페이지로 리다이렉트
    }
}
