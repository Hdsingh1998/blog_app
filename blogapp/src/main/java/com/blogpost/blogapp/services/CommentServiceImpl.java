package com.blogpost.blogapp.services;

import com.blogpost.blogapp.dto.CommentDto;
import com.blogpost.blogapp.entities.Comment;
import com.blogpost.blogapp.entities.Post;
import com.blogpost.blogapp.mapper.CommentMapper;
import com.blogpost.blogapp.repositories.CommentRepository;
import com.blogpost.blogapp.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {
        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
