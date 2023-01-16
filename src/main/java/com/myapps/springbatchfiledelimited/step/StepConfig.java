package com.myapps.springbatchfiledelimited.step;

import com.myapps.springbatchfiledelimited.domain.Customer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public StepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step fileDelimitedStep(
        ItemReader<Customer> fileDelimitedReader,
        ItemWriter<Customer> fileDelimitedWriter
    ) {
        return stepBuilderFactory
            .get("fileDelimitedStep")
            .<Customer, Customer>chunk(1)
            .reader(fileDelimitedReader)
            .writer(fileDelimitedWriter)
            .build();
    }


}
