package com.trit.gallerator.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.trit.gallerator.data.GalleryInstance;
import com.trit.gallerator.data.ImageData;
import com.trit.gallerator.data.PMF;

public class Upload extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	private ImagesService imagesService = ImagesServiceFactory.getImagesService();


    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

    	// TODO try get this from datastore, if not exists, create it
    	GalleryInstance galleryInstance = new GalleryInstance();
    	
		Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
        BlobKey blobKey = blobs.get("myFile");
        
        String imageServingUrl = imagesService.getServingUrl(blobKey);
        ImageData image = new ImageData();
        image.setServingUrl(imageServingUrl);
        galleryInstance.getImages().add(image);
        PMF.get().getPersistenceManager().makePersistent(galleryInstance);
        
        
        /*if (blobKey == null) {
            res.sendRedirect("/index.jsp");
        } else {
            res.sendRedirect("/index.jsp");
        }*/
    }
}

