package com.batch.example.tasklet;

import java.io.File;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class TaskletStep implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
			File file = new File("file.txt");
			if (file.exists()) {
				System.out.println("TaskletStep ===> File exist");
			} else {
				System.out.println("TaskletStep ===> File don't exist");
			}
		return null;
	}

}
