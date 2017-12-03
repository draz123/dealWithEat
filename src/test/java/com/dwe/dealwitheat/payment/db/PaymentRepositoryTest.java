package com.dwe.dealwitheat.payment.db;

import com.dwe.dealwitheat.payment.model.PaymentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:/application-test.properties")
public class PaymentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PaymentRepository repository;

    @Test
    public void testFindOneByUserIdAndRestaurantId() throws Exception {

        //given
        this.entityManager.persist(new PaymentEntity(100, 1000, "abc"));

        //when
        List<PaymentEntity> payment = this.repository.findOneByUserIdAndRestaurantId(null, 100, 1000);

        //then
        assertThat(payment.get(0).getCode(), is("abc"));
        assertThat(payment.get(0).getUserId(), is(100));
        assertThat(payment.get(0).getRestaurantId(), is(1000));
    }

}