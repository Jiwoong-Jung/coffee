package project.coffee.repository.regist;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.coffee.domain.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository {

    private final EntityManager em;

    public CustomerRepository(EntityManager em){
        this.em = em;
    }

    //데이터 입력
    public Customer save(Customer customer){
        em.persist(customer);
        return customer;
    }

    //전체 데이터를 가져옴
    public List<Customer> findAll() {
        return em.createQuery("select u from Customer as u", Customer.class)
                .getResultList();
    }

}
