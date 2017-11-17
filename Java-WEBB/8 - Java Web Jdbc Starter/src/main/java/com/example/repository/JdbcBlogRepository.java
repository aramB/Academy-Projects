package com.example.repository;

import com.example.domain.Author;
import com.example.domain.Blog;
import com.example.domain.Comment;
import com.example.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.PublicKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBlogRepository implements BlogRepository {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Blog> listBlogs() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, title FROM blogs")) {
            List<Blog> blogs = new ArrayList<>();
            while (rs.next()) {
                blogs.add(rsBlog(rs));
            }
            return blogs;
        }
        catch (SQLException e) {
            throw new BlogRepositoryException(e);
        }
    }


    @Override
    public Author getAuthor(long blogId){
        try(
            Connection conn = dataSource.getConnection();
            PreparedStatement pstm = conn.prepareStatement(
                    "SELECT id, name, username, password " +
                    "FROM authors " +
                    "WHERE blog_id = ?"
            )){
            pstm.setLong(1, blogId);
            ResultSet resultSet = pstm.executeQuery();
            if (!resultSet.next()){
                throw new BlogRepositoryException("No author with ID " + blogId);
            }
            else {
                return rsAuthor(resultSet);
            }
        }
        catch (SQLException e){
            throw new BlogRepositoryException(e);
        }
    }

    @Override
    public Post getPost(long postId){
        try(
            Connection conn = dataSource.getConnection();
            PreparedStatement pstm = conn.prepareStatement(
                    "SELECT ID, BLOG_ID ,TITLE ,BODY ,ENTRYDATE  " +
                        "FROM POSTS " +
                    "WHERE ID = ?")){
            pstm.setLong(1, postId);
            ResultSet resultSet = pstm.executeQuery();
            if (!resultSet.next()) {
                throw new BlogRepositoryException("No repository with ID " + postId);
            }
            else {
                return rsPost(resultSet);
            }

        }
        catch (SQLException e){
            throw new BlogRepositoryException(e);
        }
    }

    @Override
    public List<Comment> getAllComments(long postId){
        List<Comment> comments = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstm = conn.prepareStatement(
                        "select * " +
                        "from comments " +
                        "WHERE post_id = ?"
                )
        ){
            pstm.setLong(1, postId);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                comments.add(rsComment(resultSet));
            }
            return comments;
        }
        catch (SQLException e){
            throw new BlogRepositoryException(e);
        }

    }

    @Override
    public Blog getBlog(long blogId) {
        try (
                Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT id, title " +
                     "FROM blogs " +
                     "WHERE id = ?")) {
            ps.setLong(1, blogId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new BlogRepositoryException("No repository with ID " + blogId);
                else return rsBlog(rs);
            }
        } catch (SQLException e) {
            throw new BlogRepositoryException(e);
        }
    }

    @Override
    public List<Post> getEntriesIn(Blog blog) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT p.Id, p.Title, p.Body, p.EntryDate, p.Blog_Id " +
                     "FROM posts p " +
                     "WHERE P.Blog_Id = ? " +
                     "ORDER BY p.EntryDate " +
                     "DESC")) {
            ps.setLong(1, blog.id);
            try (ResultSet rs = ps.executeQuery()) {
                List<Post> posts = new ArrayList<>();
                while (rs.next()) posts.add(rsPost(rs));
                return posts;
            }
        } catch (SQLException e) {
            throw new BlogRepositoryException(e);
        }
    }

    private Post rsPost(ResultSet rs) throws SQLException {
        return new Post(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("body"),
                rs.getTimestamp("entryDate").toLocalDateTime(),
                rs.getLong("blog_Id")
        );
    }

    private Author rsAuthor(ResultSet resultSet) throws SQLException {
        return new Author(resultSet.getLong("id"),
                          resultSet.getString("name"),
                          resultSet.getString("username"),
                          resultSet.getString("password")
                          );
    }

    private Blog rsBlog(ResultSet rs) throws SQLException {
        return new Blog(rs.getLong("id"), rs.getString("title"));
    }

    private Comment rsComment(ResultSet resSet) throws SQLException {
        return new Comment(resSet.getLong("id"),
                           resSet.getLong("post_id"),
                           resSet.getString("text"),
                           resSet.getString("name"),
                           resSet.getTimestamp("entrydate").toLocalDateTime()
        );
    }
}