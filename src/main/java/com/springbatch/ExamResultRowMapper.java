/*
 * Author : Elati Sheshanth Reddy
 * Date : 16-Jan-2017
 * MailId : reddysheshanth@gmail.com
 * 
 */
package com.springbatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbatch.model.ExamResult;

public class ExamResultRowMapper implements RowMapper<ExamResult> {

	public ExamResult mapRow(ResultSet rs, int rowNum) throws SQLException {

		ExamResult result = new ExamResult();
		result.setId(rs.getInt("id"));
		result.setStudentName(rs.getString("studentName"));
		result.setDob(rs.getString("dob"));
		result.setPercentage(rs.getString("percentage"));

		return result;
	}

}
