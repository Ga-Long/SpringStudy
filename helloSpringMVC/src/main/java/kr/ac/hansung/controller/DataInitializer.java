package kr.ac.hansung.controller;

import kr.ac.hansung.dao.OfferDao;
import kr.ac.hansung.model.Offer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements InitializingBean {

    @Autowired
    private OfferDao offerDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        Offer offer1 = new Offer("Alice", "alice@hansung.ac.kr", "스프링 꿀잼");
        Offer offer2 = new Offer("Bob", "Bob@hansung.ac.kr", "JPA/Hibernate 참 편리하다");
        Offer offer3 = new Offer("Charile", "Charile@hansung.ac.kr", "Rest API 구현");

        offerDao.insert(offer1);
        offerDao.insert(offer2);
        offerDao.insert(offer3);


    }
}
