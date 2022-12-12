package com.blogpost.blogapp.services;

import com.blogpost.blogapp.dto.CommentDto;

public interface CommentService {
    void createComment(String postUrl, CommentDto commentDto);
}
