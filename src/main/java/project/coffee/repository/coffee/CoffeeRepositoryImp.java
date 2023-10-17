package project.coffee.repository.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.coffee.domain.dto.coffee.CoffeeListDTO;
import project.coffee.domain.dto.coffee.OrderCoffeeDTO;
import project.coffee.domain.dto.coffee.OrderDetailDTO;
import project.coffee.domain.dto.coffee.CustomerDTO;
import project.coffee.domain.entity.CoffeeList;
import project.coffee.domain.entity.OrderCoffee;
import project.coffee.domain.entity.OrderDetail;
import project.coffee.domain.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CoffeeRepositoryImp implements CoffeeRepository {

    @Autowired
    EntityManager em;

    @Override
    public void updateOrderDetail(OrderDetailDTO reviewdto, CustomerDTO userdto) {
        OrderDetail orderDetail =reviewdto.dtoToEntity(userdto);
        em.persist(orderDetail);
    }

    public CoffeeListDTO getCoffee(long b_no){
        return new CoffeeListDTO(em.find(CoffeeList.class,b_no));
    }

    public CustomerDTO getCustomer(String m_id){
        return new CustomerDTO(em.find(Customer.class,m_id));
    }

    @Override
    public List<OrderDetail> getCoffeeList(long b_no) {
        List<OrderDetail> result = em.createQuery("select r from OrderDetail r where r.coffeeList.b_no=:b_no").setParameter("b_no",b_no).getResultList();
        return result;
    }

    @Override
    public int getMyCoffeeList(OrderCoffeeDTO orderCoffeeDTO){
        OrderCoffee orderCoffee = orderCoffeeDTO.dtoToEntity();
        String m_id = orderCoffee.getCustomer().getM_id();
        Long b_no = orderCoffee.getB_no();
        String title = orderCoffee.getTitle();
        int result = em.createNativeQuery("" +
                        "insert into rentalbook(m_id,b_no,title,r_startdate,r_enddate)" +
                        " values(?,?,?,now(), DATEADD('MINUTE', 1, CURRENT_TIMESTAMP))")


//                " values(?,?,?,now(), DATE_ADD(NOW(), INTERVAL 1 MINUTE))")

//        DATE_ADD(NOW(), INTERVAL 1 MINUTE)
//                " values(?,?,?,now(), DATEADD('MONTH', 1, CURRENT_TIMESTAMP))")
//                        " values(?,?,?,now(), DATE_ADD(now(), INTERVAL 30 day))")
                .setParameter(1,m_id)
                .setParameter(2,b_no)
                .setParameter(3,title).executeUpdate();

        return result;
    }
}
