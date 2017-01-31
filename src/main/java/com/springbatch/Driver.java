/*
 * Author : Elati Sheshanth Reddy
 * Date : 16-Jan-2017
 * MailId : reddysheshanth@gmail.com
 * 
 */
package com.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	private static ApplicationContext context;

	public static void main(String args[]) {
		context = new ClassPathXmlApplicationContext("spring-batch-context.xml");
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

		boolean flag = true; // change the flag to toggle insert into DB and
								// fetch from DB
		System.out.println(!false);
		if (flag) {
			Job insertExamResultJob = (Job) context.getBean("insertExamResultJob");
			try {
				JobExecution insertExamResultJobExecution = jobLauncher.run(insertExamResultJob, new JobParameters());
				System.out.println(
						"insertExamResultJobExecution Exit Status : " + insertExamResultJobExecution.getStatus());
			} catch (JobExecutionException e) {
				System.out.println("Jobs insertExamResultJobExecution failed");
				e.printStackTrace();
			}

		} else {
			Job fetchExamResultJob = (Job) context.getBean("fetchExamResultJob");
			try {
				JobExecution fetchExamResultJobExecution = jobLauncher.run(fetchExamResultJob, new JobParameters());
				System.out.println(
						"fetchExamResultJobExecution Exit Status : " + fetchExamResultJobExecution.getStatus());

			} catch (JobExecutionException e) {
				System.out.println("Jobs fetchExamResultJobExecution failed");
				e.printStackTrace();
			}

		}
	}
}
