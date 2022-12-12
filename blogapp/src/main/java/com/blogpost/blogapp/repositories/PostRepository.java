package com.blogpost.blogapp.repositories;

import com.blogpost.blogapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findByUrl(String url);//just by doing this it will work like findByUrl which will return the related
                        //post data;

    @Query("SELECT p from Post p WHERE " + // post is table name p is alias for * then for post we also use table as p
            " p.title LIKE CONCAT('%', :query, '%') OR " +
            " p.shortDescription LIKE CONCAT('%', :query, '%')")
     List<Post> searchPosts(@Param("query") String query);//here in place of :query it will be replaced with String query
                           // By using @Param("query")

}
