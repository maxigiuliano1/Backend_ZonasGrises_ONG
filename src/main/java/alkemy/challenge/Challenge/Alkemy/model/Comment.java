package alkemy.challenge.Challenge.Alkemy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comments")
    private Long id;

    private String body;

    @ManyToOne
    @JoinColumn(name = "comments_user")
    private User userId;

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the userId
     */
    public User getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }

    /**
     * @return the newsId
     */
    public News getNewsId() {
        return newsId;
    }

    /**
     * @param newsId the newsId to set
     */
    public void setNewsId(News newsId) {
        this.newsId = newsId;
    }

    @ManyToOne
    @JoinColumn(name = "comments_news")
    private News newsId;

    public Comment(String body, User userId, News newsId) {
        this.body = body;
        this.userId = userId;
        this.newsId = newsId;
    }
}
