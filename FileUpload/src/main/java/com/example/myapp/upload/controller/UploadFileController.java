package com.example.myapp.upload.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myapp.upload.model.UploadFile;
import com.example.myapp.upload.service.IUploadFileService;

@Controller
public class UploadFileController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IUploadFileService uploadService;
	
	@GetMapping("/file/new")
	public String uploadFile() {
		logger.info("파일 입력 양식을 요청합니다.");
		return "file/form";
	}
	
	@PostMapping(value="/file/new")
	public String uploadFile(@RequestParam(value="category", required=false, defaultValue="/")
	String category, @RequestParam MultipartFile file) {
		logger.info(file.getOriginalFilename());
		try {
			if(file!=null && !file.isEmpty()) {
				UploadFile newFile = new UploadFile();
				newFile.setCategoryName(category);
				newFile.setFileName(file.getOriginalFilename());
				newFile.setFileSize(file.getSize());
				newFile.setFileContentType(file.getContentType());
				newFile.setFileData(file.getBytes());
				uploadService.uploadFile(newFile);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			//redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/file/list";
	}
	
	@GetMapping("/file/list")
	public String getFileList(Model model) {
		List<UploadFile> fileList = uploadService.getAllFileList();
		model.addAttribute("fileList", fileList);
		return "file/list";
	}
	
	@GetMapping("/file/list/gallery")
	public String getImageList(@RequestParam(value="category", required=false, defaultValue="image")
			String category, Model model) {
		model.addAttribute("fileList",uploadService.getImageList(category));
		return "file/gallery";
	}
	
	
	@GetMapping("/file/{fileId}")
	public ResponseEntity<byte[]> getBinaryFile(@PathVariable int fileId){
		UploadFile file = uploadService.getFile(fileId);
		if(file!=null) {
			HttpHeaders headers = new HttpHeaders();
			String[] mtype = file.getFileContentType().split("/");
			headers.setContentType(new MediaType(mtype[0],mtype[1]));
			headers.setContentLength(file.getFileSize());
			try {
				String encodedFileName = URLEncoder.encode(file.getFileName(), "UTF-8");
				headers.setContentDispositionFormData("attachment", encodedFileName);
			}catch(UnsupportedEncodingException e) {
				logger.error("지원하지 않는 인코딩입니다.");
			}
			return new ResponseEntity<byte[]>(file.getFileData(), headers, HttpStatus.OK);
		}else {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/file/list/{category}")
	public String getFileListByCategory(@PathVariable String category, Model model) {
		model.addAttribute("fileList", uploadService.getFileList(category));
		return "file/list";
	}
	
	@GetMapping("/file/delete/{fileId}")
	public String deleteFile(@PathVariable int fileId) {
		uploadService.deleteFile(fileId);
		return "redirect:/file/list";
	}
	
	@GetMapping("/file/category/update")
	public String updateCategory(@RequestParam int[] fileIds, @RequestParam String categoryName) {
		uploadService.updateCategory(fileIds, categoryName);
		return "redirect:/file/list";
	}
}
