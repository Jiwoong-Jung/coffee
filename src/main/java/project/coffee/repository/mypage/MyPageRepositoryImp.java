package project.coffee.repository.mypage;

import org.springframework.stereotype.Repository;
import project.coffee.domain.entity.OrderCoffee;
import project.coffee.domain.entity.OrderDetail;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MyPageRepositoryImp implements MyPageRepository{

    private final EntityManager em;

    public MyPageRepositoryImp(EntityManager em){this.em = em; }

    @Override
    public List<OrderCoffee> getOrder(String UID_se) {
        List<OrderCoffee> result = em.createQuery("select r from OrderCoffee r where r.customer.m_id = :UID_se").setParameter("UID_se",UID_se).getResultList();
        return result;
    }

    @Override
    public List<OrderDetail> getOrderDetail(String UID_se) {
        List<OrderDetail> result = em.createQuery("select r from OrderDetail r where r.customer.m_id = :UID_se").setParameter("UID_se",UID_se).getResultList();
        return result;
    }

    @Override
    public String deleteOrderDetail(int review_num) {
        int result = em.createNativeQuery("delete from b_review r where r.id =:bid").setParameter("bid",review_num).executeUpdate();
        return "result";
    }
    @Override
    public String updateOrderDetail(String answer, int review_num){
        int result = em.createNativeQuery("update b_review r set  r.answer=:answer where r.id=:bid").setParameter("answer",answer).setParameter("bid",review_num).executeUpdate();
        return "result";
    }
}
