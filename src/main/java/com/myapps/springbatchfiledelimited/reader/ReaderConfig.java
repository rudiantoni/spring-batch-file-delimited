package com.myapps.springbatchfiledelimited.reader;

import com.myapps.springbatchfiledelimited.domain.Customer;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader<Customer> fileDelimitedReader(
        @Value("#{jobParameters['customerFile']}") Resource customerFile
    ) {
        return new FlatFileItemReaderBuilder<Customer>()
            .name("fileDelimitedReader")
            .resource(customerFile)
            .delimited()
            .names(new String[]{"firstName", "lastName", "age", "email"})
            .targetType(Customer.class)
            .build();
    }


}
