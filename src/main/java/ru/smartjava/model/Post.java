package ru.smartjava.model;

public class Post {
  private long id;
  private String content;

  private Boolean deleted;

  public Post() {
  }

  public Post(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public Post(long id, String content, boolean deleted) {
    this.id = id;
    this.content = content;
    this.deleted = deleted;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  public Boolean isActive() {
    return !deleted;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
