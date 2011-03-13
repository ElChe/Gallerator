package com.trit.gallerator.services;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.trit.gallerator.web.utils.RequestHelper;

public class RestRouter extends Application
{
	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 */
	@Override
	public Restlet createInboundRoot()
	{
		// Create a router Restlet that routes each call to a
		// new instance of ImageService.
		Router router = new Router(getContext());

		// Defines only one route
		router.attach(String.format("/images/{%s}", RequestHelper.EditReference), ImageService.class);

		return router;
	}

}
