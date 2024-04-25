package com.example.myapp.upload.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.upload.dao.IUploadFileRepository;
import com.example.myapp.upload.model.UploadFile;
import com.example.myapp.upload.model.UploadFileDto;

@Service
public class UploadService implements IUploadFileService{

	@Autowired
	IUploadFileRepository uploadFileRepository;
	
	@Override
	public void uploadFile(UploadFile file) {
		// TODO Auto-generated method stub
		int fileId = uploadFileRepository.getMaxFileId();
		file.setFileId(fileId+1);
		uploadFileRepository.uploadFile(file);
	}

	@Override
	public List<UploadFile> getAllFileList() {
		// TODO Auto-generated method stub
		return uploadFileRepository.getAllFileList();
	}

	@Override
	public UploadFile getFile(int fileId) {
		// TODO Auto-generated method stub
		return uploadFileRepository.getFile(fileId);
	}

	@Override
	public List<UploadFile> getFileList(String category) {
		// TODO Auto-generated method stub
		return uploadFileRepository.getFileList(category);
	}

	@Override
	public List<UploadFile> getImageList(String category) {
		// TODO Auto-generated method stub
		return uploadFileRepository.getImageList(category);
	}

	@Override
	public String getCategoryName(int fileId) {
		// TODO Auto-generated method stub
		return uploadFileRepository.getCategoryName(fileId);
	}

	@Override
	public void updateCategory(int[] fileIds, String categoryName) {
		// TODO Auto-generated method stub
		for(int fileId : fileIds) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("fileId", fileId);
			map.put("categoryName", categoryName);
			uploadFileRepository.updateCategory(map);
		}
	}

	@Override
	public void deleteFile(int fileId) {
		// TODO Auto-generated method stub
		uploadFileRepository.deleteFile(fileId);
	}

	@Override
	public void uploadFile2(UploadFileDto file) {
		// TODO Auto-generated method stub
		int fileId = uploadFileRepository.getMaxFileId2();
		file.setFileId(fileId+1);
		uploadFileRepository.uploadFile2(file);
	}
	
	@Override
	public List<UploadFileDto> getAllFileList2() {
		// TODO Auto-generated method stub
		return uploadFileRepository.getAllFileList2();
	}
	
	@Override
	public UploadFileDto getFile2(int fileId) {
		// TODO Auto-generated method stub
		return uploadFileRepository.getFile2(fileId);
	}
	
	@Override
	public void deleteFile2(int fileId) {
		// TODO Auto-generated method stub
		uploadFileRepository.deleteFile(fileId);
	}
}
