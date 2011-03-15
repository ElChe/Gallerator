package com.trit.gallerator.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.trit.gallerator.web.utils.RequestHelper;

/**
 * Servlet that prints out a new uploadUrl each time it's called
 * @author Amund
 *
 */
public class GenUploadUrl extends HttpServlet
{
	final BlobstoreService blobstoreService = BlobstoreServiceFactory
			.getBlobstoreService();

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		String uploadUrl = blobstoreService.createUploadUrl("/upload");
		PrintWriter out = res.getWriter();
		res.setContentType("text/plain");
		out.write(uploadUrl);
	}
}
