package portfolio.sjmontini.portfolio_back.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String lastname;
    private String names;
    private String email;
    private String phone;
    private String ocupation;
    private String imageurl;
    private String aboutme;
    private String linkedinurl;
    private String instagramurl;
    private String facebookurl;
    private String twitterurl;
    private String githuburl;
}