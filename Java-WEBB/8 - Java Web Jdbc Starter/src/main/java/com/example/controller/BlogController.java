package com.example.controller;

import com.example.domain.Author;
import com.example.domain.Blog;
import com.example.domain.Comment;
import com.example.domain.Post;
import com.example.repository.BlogRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;


    @GetMapping("/blog/")
    public ModelAndView listBlogs() {
        return new ModelAndView("blog/list")
                .addObject("blogs", blogRepository.listBlogs());
    }

    @GetMapping("/blog/{blogId}/")
    public ModelAndView listPosts(@PathVariable long blogId) {
        Blog blog = blogRepository.getBlog(blogId);
        List<Post> posts = blogRepository.getEntriesIn(blog);
        Author author = blogRepository.getAuthor(blogId);
        return new ModelAndView("blog/posts")
                .addObject("blog", blog)
                .addObject("posts", posts)
                .addObject("authors", author);
    }

    @GetMapping("/blog/{blogId}/posts/{postId}")
    public ModelAndView listPost(@PathVariable long blogId, @PathVariable long postId) {
        Blog blog = blogRepository.getBlog(blogId);
        Post post = blogRepository.getPost(postId);
        List<Comment> comment = blogRepository.getAllComments(postId);

        // get the post and comments from the database,
        // set post and comments in the model and show this information in the view
        return new ModelAndView("blog/post")
                .addObject("comment", comment)
                .addObject("post", post)
                .addObject("blog", blog);
    }

}