package project.coffee.domain.dto.mypage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project.coffee.domain.entity.Customer;

@NoArgsConstructor
@Getter
public class CustomerLoginRequest {
    private String m_id;

    private String m_pw;

    // entity->dto(로그인)
    public CustomerLoginRequest(Customer customer){
        this.m_id = customer.getM_id();
        this.m_pw = customer.getM_pw();
    }
    public Customer toEntity(String m_id, String m_pw) {
        return Customer.builder()
                .m_id(m_id)
                .m_pw(m_pw)
                .build();
    }
}
