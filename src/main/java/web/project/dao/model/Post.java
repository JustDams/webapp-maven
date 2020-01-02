package web.project.dao.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Post {
    private int id;
    private String author;
    private String title;
    private String description;
    private String content;
    private Date date;
    
    public Post() {
    	
    }
    
    public Post(int id,String author,String title,String description,String content,Date date) {
    	this.id = id;
    	this.author = author;
    	this.title = title;
    	this.description = description;
    	this.content = content;
    	this.date = date;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String[] postString() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("E dd.MM.yyyy");
    	String strId = this.id + "";
		String[] post = {strId,this.author,this.title,this.description,this.content,dateFormat.format(this.date)};
    	return post;
    }
}