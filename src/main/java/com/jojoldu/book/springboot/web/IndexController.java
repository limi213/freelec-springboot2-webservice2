package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){ // 서버 템플릿 엔진에서 사용할 수 있는 객체 저장 가능
        //기존 httpSession.getAttribute("user")로 가져오던 세션 정보 값이 개선됨
        //LoginUser 이용하면 세션 정보 가져올 수 있음

        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null){ //세션에 저장된 값이 있을 때 model에 userName으로 등록, 저장된 값없으면 로그인 버튼 보임
            model.addAttribute("loginUserName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }


    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
