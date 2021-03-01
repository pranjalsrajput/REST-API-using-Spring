package de.exb.tasks.task2.experiment.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ImageService {
	// user cache for filename and metadata
    public Map<String,byte[]> mCache;

	public InputStream getImage(String filename) throws FileNotFoundException {

		final FileInputStream fileInputStream = new FileInputStream(new File(filename));
		return fileInputStream;

	}


	public byte[] getMetaData(String Filename){

		if (mCache.containsKey(Filename)){
			return mCache.get(Filename);
		}else {
			byte[] calk=new byte[1024*1024];
			  getfilledarray(calk);
			// fill array
			return calk;
		}
	}


	private void getfilledarray(byte[] data){
		// calc the staff byte array is about 1 mb big and takes some time
		// its only Application dummy for the test
	}



}
