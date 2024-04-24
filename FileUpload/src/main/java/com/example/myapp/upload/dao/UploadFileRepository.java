package com.example.myapp.upload.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.myapp.upload.model.UploadFile;

@Repository
public class UploadFileRepository implements IUploadFileRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int getMaxFileId() {
		// TODO Auto-generated method stub
		String sql = "SELECT NVL(MAX(file_id),0) FROM upload_file";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void uploadFile(UploadFile file) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO upload_file "
				+ " (file_id, category_name, file_name, file_size, "
				+ " file_content_type, file_upload_date, file_data) "
				+ " values(?,?,?,?,?, SYSTIMESTAMP, ?)";
		jdbcTemplate.update(sql,
				file.getFileId(),
				file.getCategoryName(),
				file.getFileName(),
				file.getFileSize(),
				file.getFileContentType(),
				file.getFileData());
		
	}

	@Override
	public List<UploadFile> getFileList(String categoryName) {
		String sql = "select file_id, category_name, file_name, file_size, "
				+ " file_content_type, file_upload_date "
				+ " from upload_file "
				+ " where category_name=? "
				+ " order by file_upload_date desc ";
		return jdbcTemplate.query(sql, new RowMapper<UploadFile>() {

			@Override
			public UploadFile mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				UploadFile file = new UploadFile();
				file.setFileId(rs.getInt("file_id"));
				file.setCategoryName(rs.getString("category_name"));
				file.setFileName(rs.getString("file_name"));
				file.setFileSize(rs.getLong("file_size"));
				file.setFileContentType(rs.getString("file_content_type"));
				file.setFileUploadDate(rs.getTimestamp("file_upload_date"));
				return file;
			}

		}, categoryName);
	}

	private class UploadFileMapper implements RowMapper<UploadFile>{

		@Override
		public UploadFile mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			UploadFile file = new UploadFile();
			file.setFileId(rs.getInt("file_id"));
			file.setCategoryName(rs.getString("category_name"));
			file.setFileName(rs.getString("file_name"));
			file.setFileSize(rs.getLong("file_size"));
			file.setFileContentType(rs.getString("file_content_type"));
			file.setFileUploadDate(rs.getTimestamp("file_upload_date"));
			try {
				file.setFileData(rs.getBytes("file_data"));
			}catch(Exception e) {
				//nothing
			}
			return file;
		}
		
	}
	@Override
	public List<UploadFile> getAllFileList() {
		// TODO Auto-generated method stub
		String sql = "SELECT file_id, category_name, file_name, file_size, "
				+ " file_content_type, file_upload_date "
				+ " from upload_file ORDER BY file_upload_date DESC";
		return jdbcTemplate.query(sql, new RowMapper<UploadFile>() {

			@Override
			public UploadFile mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				UploadFile file = new UploadFile();
				file.setFileId(rs.getInt("file_id"));
				file.setCategoryName(rs.getString("category_name"));
				file.setFileName(rs.getString("file_name"));
				file.setFileSize(rs.getLong("file_size"));
				file.setFileContentType(rs.getString("file_content_type"));
				file.setFileUploadDate(rs.getTimestamp("file_upload_date"));
				return file;
			}
		});
	}

	@Override
	public UploadFile getFile(int fileId) {
		// TODO Auto-generated method stub
		String sql = "SELECT file_id, category_name, file_name, file_size, "
				+ " file_content_type, file_upload_date, file_data "
				+ " from upload_file where file_id=?";
		return jdbcTemplate.queryForObject(sql, new UploadFileMapper(), fileId);
	}

	@Override
	public String getCategoryName(int fileId) {
		// TODO Auto-generated method stub
		String sql = "select category_name from upload_file where file_id=?";
		return jdbcTemplate.queryForObject(sql, String.class, fileId);
	}

	@Override
	public void updateCategory(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String sql = "update upload_file set category_name=? where file_id=?";
		jdbcTemplate.update(sql,map.get("categoryName"), map.get("fileId"));
		
	}

	@Override
	public void deleteFile(int fileId) {
		// TODO Auto-generated method stub
		String sql = "delete from upload_file where file_id=?";
		jdbcTemplate.update(sql, fileId);
	}

	@Override
	public List<UploadFile> getImageList(String categoryName) {
		// TODO Auto-generated method stub
		String sql = "select file_id, category_name, file_name, file_size, "
				+ " file_content_type, file_upload_date, file_data "
				+ " from upload_file "
				+ " where category_name=? "
				+ " order by file_upload_date desc";
		return jdbcTemplate.query(sql, new RowMapper<UploadFile>() {

			@Override
			public UploadFile mapRow(ResultSet rs, int rowNum) throws SQLException {
				UploadFile file = new UploadFile();
				file.setFileId(rs.getInt("file_id"));
				file.setCategoryName(rs.getString("category_name"));
				file.setFileName(rs.getString("file_name"));
				file.setFileSize(rs.getLong("file_size"));
				file.setFileContentType(rs.getString("file_content_type"));
				file.setFileData(rs.getBytes("file_data"));
				file.setFileUploadDate(rs.getTimestamp("file_upload_date"));
				return file;
			}		
		}, categoryName);
	}
}
