package com.example.domain;

import java.time.LocalDateTime;

public class Comment
{
	public final long id;
	public final long post_id;
	public final String text;
	public final String name;
	public final LocalDateTime date;

	public Comment(final long id, final long post_id, final String text, final String name, final LocalDateTime date) {
		this.id = id;
		this.post_id = post_id;
		this.text = text;
		this.name = name;
		this.date = date;
	}
}
