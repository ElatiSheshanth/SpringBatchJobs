/*
 * Author : Elati Sheshanth Reddy
 * Date : 16-Jan-2017
 * MailId : reddysheshanth@gmail.com
 * 
 */
package com.springbatch;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.model.ExamResult;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult> {

	public ExamResult process(ExamResult result) throws Exception {
		System.out.println("Processing result :" + result);

		return result;
	}

}
