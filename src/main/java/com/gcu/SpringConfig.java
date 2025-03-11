package com.gcu;

import com.gcu.business.OrdersBusinessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean(name = "customOrdersBusinessService", initMethod = "init", destroyMethod = "destroy")
    public OrdersBusinessService getOrdersBusinessService() {
        return new OrdersBusinessService();
    }
}
