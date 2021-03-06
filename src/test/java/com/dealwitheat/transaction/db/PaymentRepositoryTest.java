package com.dealwitheat.transaction.db;

import com.yummy.transaction.db.TransactionDao;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Ignore
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:/application-test.properties")
public class PaymentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransactionDao repository;

    @Test
    public void testFindOneByUserIdAndRestaurantId() throws Exception {

        //given
//        this.entityManager.persist(new TransactionEntity(100, 1000, "abc"));
//
//        //when
//        List<TransactionEntity> payment = this.repository.findOneByUserIdAndRestaurantId(null, 100, 1000);
//
//        //then
//        assertThat(payment.get(0).getCode(), is("abc"));
//        assertThat(payment.get(0).getUserId(), is(100));
//        assertThat(payment.get(0).getRestaurantId(), is(1000));
    }

}