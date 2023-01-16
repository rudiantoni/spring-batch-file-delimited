package com.myapps.springbatchfiledelimited.writer;

import com.myapps.springbatchfiledelimited.domain.Customer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfig {

    @Bean
    public ItemWriter<Customer> fileDelimitedWriter() {
        return items -> {
            for(Customer customer : items) {
                System.out.println(customer.toString());
            }
        };

    }

}
