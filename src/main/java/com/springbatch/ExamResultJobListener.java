/*
 * Author : Elati Sheshanth Reddy
 * Date : 16-Jan-2017
 * MailId : reddysheshanth@gmail.com
 * 
 */
package com.springbatch;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ExamResultJobListener implements JobExecutionListener {

	private Long startTime, stopTime;

	public void beforeJob(JobExecution jobExecution) {
		startTime = System.currentTimeMillis();
		System.out.println("ExamResult Job starts at :" + startTime);
	}

	public void afterJob(JobExecution jobExecution) {
		stopTime = System.currentTimeMillis();
		System.out.println("ExamResult Job stops at :" + stopTime);
		System.out.println("Total time take in millis :" + (stopTime - startTime));

		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("ExamResult job completed successfully");
			// Here you can perform some other business logic like cleanup
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {
			System.out.println("ExamResult job failed with following exceptions ");
			List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
			for (Throwable th : exceptionList) {
				System.err.println("exception :" + th.getLocalizedMessage());
			}
		}
	}

}
