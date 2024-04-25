package com.example.myapp.upload.dao;

import java.util.List;
import java.util.Map;

import com.example.myapp.upload.model.UploadFile;
import com.example.myapp.upload.model.UploadFileDto;

public interface IUploadFileRepository {
	int getMaxFileId();
	
	void uploadFile(UploadFile file);
	
	List<UploadFile> getFileList(String categoryName);
	List<UploadFile> getAllFileList();
	List<UploadFile> getImageList(String categoryName);
	
	UploadFile getFile(int fileId);
	
	String getCategoryName(int fileId);
	void updateCategory(Map<String, Object> map);
	
	void deleteFile(int fileId);
	
	void uploadFile2(UploadFileDto file);

	int getMaxFileId2();

	List<UploadFileDto> getAllFileList2();
	UploadFileDto getFile2(int fileId);
}
