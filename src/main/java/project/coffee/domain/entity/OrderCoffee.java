package project.coffee.domain.entity;

import lombok.Builder;

import javax.persistence.Entity;
import java.time.LocalDateTime;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "rentalbook")
public class OrderCoffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "m_id")
    private Customer customer;

    private Long b_no;

    private String title;

    private LocalDateTime r_startdate;

    private LocalDateTime r_enddate;
}
