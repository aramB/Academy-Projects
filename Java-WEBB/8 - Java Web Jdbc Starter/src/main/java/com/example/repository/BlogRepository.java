package com.example.repository;

import com.example.domain.Author;
import com.example.domain.Blog;
import com.example.domain.Comment;
import com.example.domain.Post;

import java.util.List;

public interface BlogRepository {
    List<Blog> listBlogs();
    Blog getBlog(long blogId);
    List<Post> getEntriesIn(Blog blog);
    Post getPost(long postId);
    List<Comment> getAllComments(long postId);
    Author getAuthor(long blogId);

}
