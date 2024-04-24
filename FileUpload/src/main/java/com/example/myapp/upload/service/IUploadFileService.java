package com.example.myapp.upload.service;

import java.util.List;

import com.example.myapp.upload.model.UploadFile;

public interface IUploadFileService {
	void uploadFile(UploadFile file);
	
	List<UploadFile> getAllFileList();
	List<UploadFile> getFileList(String category);
	List<UploadFile> getImageList(String category);
	
	UploadFile getFile(int fileId);
	
	String getCategoryName(int fileId);
	void updateCategory(int[] fileIds, String categoryName);
	
	void deleteFile(int fileId);
}
