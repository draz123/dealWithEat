package com.dealwitheat.restaurant.db;

import com.yummy.restaurant.db.RestaurantRepository;
import com.yummy.restaurant.model.RestaurantEntity;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@Ignore
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:/application-test.properties")
public class RestaurantRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RestaurantRepository repository;


    @Test
    public void testFindAll() throws Exception {
        //given
//        this.entityManager.persist(new RestaurantEntity("First resturant","Krakow 1",11.22,11.33,"Description 1","www.fr.com"));
//        this.entityManager.persist(new RestaurantEntity("Second resturant","Krakow 2",12.22,12.33,"Description 2","www.fr2.com"));
//
//        //when
//        List<RestaurantEntity> restaurants = this.repository.findAll();
//
//        //then
//        assertThat(restaurants.size(), greaterThan(0));
    }

}