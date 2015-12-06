package com.heroesandfriends.stuffmanager;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

import javax.transaction.Transactional;

/**
 * @author John Spangenberg
 */

@SpringApplicationConfiguration(classes = TestConfig.class)
@Transactional
public abstract class AbstractIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    public void setupData() throws Exception {
    }

}
