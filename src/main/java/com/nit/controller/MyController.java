package com.nit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nit.entity.ApplicantEntity;
import com.nit.model.ApplicantModel;
import com.nit.service.ApplicantService;
import java.io.*;
import java.net.http.HttpResponse;
@Controller
public class MyController {

	@Autowired
	ApplicantService service;
	@Autowired
	ServletContext sc;
	
	@Autowired
	Environment envi;
	
	@GetMapping("/")
	public String home() {
		return "welcome";
	}
	
	@GetMapping("/form")
	public String formPage(@ModelAttribute("model") ApplicantModel model) {
		return "register";
	}
	
	
	@PostMapping("/result")
	public String saveApplicant(@ModelAttribute("model") ApplicantModel model, Map<Object, String> map)throws Exception {
		String folderLocation=envi.getProperty("upload.store");
		File file=new File(folderLocation);
		if(!file.exists()) {
			file.mkdir();
		}
		MultipartFile resume=model.getAppResume();
		MultipartFile photo=model.getAppPhoto();
		
		InputStream streamResume=resume.getInputStream();
		InputStream streamPhoto=photo.getInputStream();
		
		String resumeName=resume.getOriginalFilename();
		String photoName=photo.getOriginalFilename();
		
		OutputStream outResume=new FileOutputStream(file.getAbsolutePath()+"\\"+resumeName);
		OutputStream outPhoto=new FileOutputStream(file.getAbsolutePath()+"\\"+photoName);
		
		IOUtils.copy(streamPhoto, outPhoto);
		IOUtils.copy(streamResume, outResume);
		
		streamResume.close();
		streamPhoto.close();
		
		outResume.close();
		outPhoto.close();
		
		ApplicantEntity entity=new ApplicantEntity();
		entity.setName(model.getAppName());
		entity.setResumePath(file.getAbsolutePath()+"\\"+resumeName);
		entity.setPhotoPath(file.getAbsolutePath()+"\\"+photoName);
		System.out.println(entity);
		String msg=service.registerApplicant(entity);
		map.put("msg", msg);
		return "result";
	}
	@GetMapping("/report")
	public String allApplicant(Map<String, Object> map) {
		List<ApplicantEntity> applicant=service.fetchAllApplicant();
		map.put("applicant", applicant);
		return "all_report";
	}
	
	@GetMapping("/download")
	public String downloadPage(@RequestParam String type, @RequestParam Integer id,HttpServletResponse res)throws Exception{
		String filePath=null;
		                System.out.println("Idhar aaaaaaaa gaya!!!!11"+type+"  "+type.contains("resume"));
		                
		if(type.contains("resume")) {
			 filePath=service.getResumeById(id);
				System.out.println("Idhar aaaaaaaa gaya!!!!2222");

		}else {

			filePath=service.getPhotoById(id);
			System.out.println("Idhar aaaaaaaa gaya!!!!33333---"+id);

		}
		System.out.println("Idhar aaaaaaaa gaya!!!!33333---"+filePath);

		File file=new File(filePath);
		System.out.println("Idhar aaaaaaaa gaya!!!!444444444");

		res.setContentLengthLong(file.length());// i think this is not compulsory.
		String mime=sc.getMimeType(filePath);// getting mime type of our file to set 
		if(mime==null) {     

		res.setContentType("application/octet-stream");
		} // in case no mime type is determine
		else {
			System.out.println("Idhar aaaaaaaa gaya!!!!5555555555555");

			res.setContentType(mime);          //determined mime type
		}
		InputStream istream= new FileInputStream(file);
		OutputStream ostream= res.getOutputStream();
		System.out.println("Idhar aaaaaaaa gaya!!!!66666666666666");

		res.setHeader("Content-Disposition","attachment;fileName="+file.getName()); //informing browser that coming file is downloadable/
		IOUtils.copy(istream, ostream);
		System.out.println("Idhar aaaaaaaa gaya!!!!777777777777");

		istream.close();
		ostream.close();
		return null;
	}
}
