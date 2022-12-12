package com.blogpost.blogapp.controller;

import com.blogpost.blogapp.dto.CommentDto;
import com.blogpost.blogapp.dto.PostDto;
import com.blogpost.blogapp.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("/{postUrl}/comments")
    public String createComment(@PathVariable("postUrl") String postUrl,
                                @Valid  @ModelAttribute("comment") CommentDto commentDto,
                                Model model, BindingResult results){
        if(results.hasErrors()){
           // model.addAttribute("post", postDto);
            model.addAttribute("comment", commentDto);
        }
        commentService.createComment(postUrl,commentDto);
        return "redirect:/post/"+postUrl;
    }
}
