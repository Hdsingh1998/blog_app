package com.blogpost.blogapp.mapper;

import com.blogpost.blogapp.dto.PostDto;
import com.blogpost.blogapp.entities.Post;

public class PostMapper {
    // map Post entity to PostDto
    public static PostDto mapToPostDto(Post post){
        return PostDto.builder() //
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .build();// this will automatically generate the dto object and put data into it and return
        //the dto object
    }

    // map Postdto to Post entity
    public static Post mapToPost(PostDto postDto){
        return Post.builder()//
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .url(postDto.getUrl())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreatedOn())
                .updatedOn(postDto.getUpdatedOn())
                .build();// this will generate post object and copy the data and return the post object
    }
}

