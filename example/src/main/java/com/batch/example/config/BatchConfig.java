package com.batch.example.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.example.tasklet.TaskletStep;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	TaskletStep taskletStep;
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
    public StepBuilderFactory stepBuilderFactory;
	
	@Bean
    public Job job() {
        return jobBuilderFactory.get("The Job")
                .incrementer(new RunIdIncrementer())
                .start(stepOne()).next(stepTwo())
                .build();
    }
	
    @Bean
    public Step stepOne() {
        return stepBuilderFactory.get("Step One")
                .<String, String> chunk(1)
               // .reader(new MyItemReader())
               // .writer(new MyItemWriter())
                .build();
    }
    
    @Bean
    public Step stepTwo() {
        return stepBuilderFactory.get("Step Two")
        		.tasklet(taskletStep)
                .build();
    }
}
