package project.coffee.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "b_user")
public class Customer {

    @Id
    @Column(length = 20)
    private String m_id;

    @Column(nullable = false, length = 16)
    private String m_pw;

    @Column(nullable = false,length = 10)
    private String m_name;

    @Column(nullable = false)
    private boolean gender;

    @Column(nullable = false,length = 10,unique = true)
    private String nickname;
}