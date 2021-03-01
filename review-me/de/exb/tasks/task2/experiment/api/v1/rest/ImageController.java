package de.exb.tasks.task2.experiment.api.v1.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import de.exb.tasks.task2.experiment.service.ImageService;


@RestController
@RequestMapping(value = "/de/v1/capabilities", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ImageController {





	@ApiOperation(value = "get the image", notes = "", response = Void.class)
	@RequestMapping(value = "/image", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.GET)
	public void readImage(@RequestParam(value = "fileId") final String fileId, HttpServletResponse aRespones) throws IOException {
		try {

		  IOUtils.copy(imageService.getImage(fileId), aRespones.getOutputStream());
		}catch (NullPointerException ex){
			System.err.println("error file id null");
		}
	}

	@Autowired
	private ImageService imageService;


	@ApiOperation(value = "add new image", notes = "", response = String.class, responseContainer = "List")
	@RequestMapping(value = "/image", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
	public void uploadNewImage(HttpServletRequest httpServletRequest,@RequestParam (value="filename") String filename) throws IOException {
		final File file = new File(filename);
		file.createNewFile();
		final FileOutputStream input = new FileOutputStream(file);
		IOUtils.copy(httpServletRequest.getInputStream(),input);
	}


	@ApiOperation(value = "Get all image meta datas", notes = "", response = String.class, responseContainer = "List")
	@RequestMapping(value = "/metdata", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAllImageMetaDatasUploaded(){
		ArrayList list = new ArrayList();
		for (String key:imageService.mCache.keySet()){
			list.add(metaData2String(imageService.mCache.get(key)));
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
	}


	private String metaData2String(byte[] input) throws IllegalArgumentException{
		   // DO SOME CHECKS and then throw illegal argument Exception if not matching
		   // DUMMY TESTS
		 // ...

          return input.toString();
	}




}
