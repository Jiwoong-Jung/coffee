package project.coffee.repository.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.coffee.domain.entity.Customer;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;

@Repository
public class LoginRepository implements Login {
    @Autowired
    private EntityManager em;

    @Override
    public HashMap<String, String> findPwById() {
        List<Customer> customerList = em.createQuery("select u from Customer u").getResultList();
        HashMap<String, String> login = new HashMap<String, String>();
        for (Customer customer : customerList) {
            String id = customer.getM_id();
            String pw = customer.getM_pw();
            login.put(id, pw);
        }
        return login;
    }

    @Override
    public String findNicknameById(String mid) {
        String nickname = (String) em.createQuery("select u.nickname from Customer u where u.m_id = :mid")
                .setParameter("mid",mid).getSingleResult();
        System.out.println(nickname);
        return nickname;
    }
}
