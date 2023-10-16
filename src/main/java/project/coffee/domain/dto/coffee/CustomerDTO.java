package project.coffee.domain.dto.coffee;

import lombok.Data;
import lombok.NoArgsConstructor;
import project.coffee.domain.entity.Customer;

@Data
@NoArgsConstructor
public class CustomerDTO {
    private String m_id;
    private String m_pw;
    private String m_name;
    private boolean gender;

    private String nickname;

    public CustomerDTO(Customer customer){
        m_id = customer.getM_id();
        m_pw = customer.getM_pw();
        m_name = customer.getM_name();
        gender = customer.isGender();
        nickname = customer.getNickname();
    }

    public Customer dtoToEntity(){
        return Customer.builder()
                .m_id(m_id)
                .m_pw(m_pw)
                .m_name(m_name)
                .gender(gender)
                .nickname(nickname)
                .build();
    }
}
