/*
 * Author : Elati Sheshanth Reddy
 * Date : 16-Jan-2017
 * MailId : reddysheshanth@gmail.com
 * 
 */
package com.springbatch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import com.springbatch.model.ExamResult;

public class ExamResultFieldSetMapper implements FieldSetMapper<ExamResult> {

	public ExamResult mapFieldSet(FieldSet fieldSet) {

		ExamResult result = new ExamResult();
		result.setId(fieldSet.readInt("id"));
		result.setStudentName(fieldSet.readString("studentName"));
		result.setDob(fieldSet.readString("dob"));
		result.setPercentage(fieldSet.readString("percentage"));
		return result;

	}
}