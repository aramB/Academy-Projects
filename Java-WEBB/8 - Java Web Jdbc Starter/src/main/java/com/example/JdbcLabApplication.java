package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

@SpringBootApplication
public class JdbcLabApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(JdbcLabApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JdbcLabApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {

		log.info("Creating tables");
		jdbcTemplate.execute("DROP TABLE blogs IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE blogs(id SERIAL, title VARCHAR(255))");

		jdbcTemplate.execute("DROP TABLE posts IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE posts(id SERIAL, blog_id INT, title VARCHAR(255), body VARCHAR(255), entryDate DATE, FOREIGN KEY (blog_id) REFERENCES public.blogs(id))");

		jdbcTemplate.execute("DROP TABLE authors IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE authors(id SERIAL, blog_id INT, name VARCHAR(255), username VARCHAR(255), password VARCHAR(255), FOREIGN KEY (blog_id) REFERENCES public.blogs(id))");

		jdbcTemplate.execute("DROP TABLE comments IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE comments(id SERIAL, post_id INT, name VARCHAR(255), text VARCHAR(255), entryDate DATE, FOREIGN KEY (post_id) REFERENCES public.posts(id))");


		// Creates a repository with an author, 2 posts and a comment
		int blogKey = insertBlog("Världens snällaste repository");
		insertAuthor(blogKey, "Bamse", "bamse", "dunderhonung");
		insertPost(blogKey, "Stark honung", "Idag var farmors honung godare än vanligt...", new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		int postKey = insertPost(blogKey, "Var snäll", "Man ska vara snäll, bla, bla...", new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		insertComment(postKey, "Vargen", "Bamse tramse!", new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

		blogKey = insertBlog("Rymdrakerter och atlantångare");
		insertAuthor(blogKey, "Skalman", "skalman", "matochsovklocka");
		postKey = insertPost(blogKey, "Frukost och sedan", "Idag vaknade jag och sedan ringde matochsovklockan och då somnade jag.", new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		insertComment(postKey, "Einstein", "Jag vill vara som du!", new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
	}

	// Inserts a repository in table blogs
	private int insertBlog(String title) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator()  {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps =
								connection.prepareStatement("INSERT INTO blogs(title) VALUES (?) ", new String[] {"id"});
						ps.setString(1, title);
						return ps;
					}
				},
				keyHolder);
		return keyHolder.getKey().intValue();
	}

	//Inserts a post in table posts
	private int insertPost(int blog_id, String title, String body, java.sql.Date date) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator()  {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps =
								connection.prepareStatement("INSERT INTO posts(blog_id,title, body, entryDate) VALUES (?,?,?,?) ", new String[] {"id"});
						ps.setLong(1, blog_id);
						ps.setString(2, title);
						ps.setString(3, body);
						ps.setDate(4, date);
						return ps;
					}
				},
				keyHolder);
		return keyHolder.getKey().intValue();
	}

	// Inserts an author in table authors
	private int insertAuthor(int blog_id, String name, String username, String password) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator()  {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps =
								connection.prepareStatement("INSERT INTO authors(blog_id, name, username, password) VALUES (?,?,?,?) ", new String[] {"id"});
						ps.setLong(1, blog_id);
						ps.setString(2, name);
						ps.setString(3, username);
						ps.setString(4, password);
						return ps;
					}
				},
				keyHolder);
		return keyHolder.getKey().intValue();
	}

	// Inserts a comment in table comments
	private int insertComment(int post_id, String name, String text, java.sql.Date date) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator()  {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps =
								connection.prepareStatement("INSERT INTO comments(post_id, name, text, entryDate) VALUES (?,?,?,?) ", new String[] {"id"});
						ps.setLong(1, post_id);
						ps.setString(2, name);
						ps.setString(3, text);
						ps.setDate(4, date);
						return ps;
					}
				},
				keyHolder);
		return keyHolder.getKey().intValue();
	}
}
