package com.hakg.api.controller;

import com.hakg.api.domain.Board;
import com.hakg.api.domain.User;
import com.hakg.api.service.AccountService;
import com.hakg.api.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

//    @Autowired
    private final AccountService accountService;    // 필드 주입

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /*
    * 생성자 주입
     private final AccountService accountService;
        public UserController(AccountService accountService) {
            this.accountService = accountService;
        }
    * */
//
//    @GetMapping("/login")
//    public String loginForm(Model model) {
//        model.addAttribute("member", new Member());
//        return "account";
//    }
    @GetMapping("/login")
    public String loginForm() {
        return "account";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());     // 회원가입을 위한  빈 Member 객체를 모델에 추가
        return "signup";    // 회원가입 페이지로 이동하는 뷰 이름
    }

    @PostMapping("/signup")
    public String signupSubmit(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
//    public String signupSubmit(@ModelAttribute("user") User user) {
        // 회원가입 로직 실행
        User user = new User();
        user.setUserId(username);
        user.setEmail(email);
        user.setPwd(password);

        accountService.signUp(user);
        return "redirect:/login";   // 회원가입 성공 시 로그인 페이지로 리다이렉트
    }
}
