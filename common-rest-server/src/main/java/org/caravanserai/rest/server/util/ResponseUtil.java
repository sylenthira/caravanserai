package org.caravanserai.rest.server.util;

import org.slf4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author sylenthira
 */
public class ResponseUtil {
  /**
   * Constructs a RESTful service response object with status code 200.
   *
   * @param object Domain Object
   * @return constructed RESTful service Response Object
   */
  public static Response getOkSuccess(Object object) {
    return Response.status(Response.Status.OK).entity(object).build();
  }

  /**
   * Constructs a RESTful service response object with status code 201.
   *
   * @param serviceResponse ServiceResponse object
   * @return constructed RESTful service Response Object
   */
  public static Response getCreated(Object serviceResponse) {
    return Response.status(Response.Status.CREATED).entity(serviceResponse)
        .build();
  }

  /**
   * Constructs a RESTful service response object with status code 201.
   *
   * @param serviceResponse ServiceResponse object
   * @param path            content-location to set in response header
   * @return constructed RESTful service Response Object
   */
  public static Response getCreatedPath(Object serviceResponse, String path) {
    try {
      return Response.status(Response.Status.CREATED).entity(serviceResponse).contentLocation(new
          URI(path)).build();
    } catch (URISyntaxException e) {
      return getCreated(serviceResponse);
    }
  }

  /**
   * Constructs a RESTful service response object with status code 400.
   *
   * @param serviceResponse ServiceResponse object
   * @return constructed RESTful service Response Object
   */
  public static Response getBadRequest(Object serviceResponse) {
    return Response.status(Response.Status.BAD_REQUEST).entity(serviceResponse).build();
  }

  /**
   * Constructs a RESTful ServiceResponse object with status code 403.
   *
   * @param serviceResponse ServiceResponse object
   * @return constructed RESTful service Response Object
   */
  public static Response getForbidden(Object serviceResponse) {
    return Response.status(Response.Status.FORBIDDEN).entity(serviceResponse).build();
  }

  /**
   * Constructs a RESTful service response object with status code 404.
   *
   * @param serviceResponse ServiceResponse object
   * @return constructed RESTful service Response Object
   */
  public static Response getNotFound(Object serviceResponse) {
    return Response.status(Response.Status.NOT_FOUND).entity(serviceResponse).build();
  }

  /**
   * Constructs a RESTful ServiceResponse object with status code 409.
   *
   * @param serviceResponse ServiceResponse object
   * @return constructed RESTful service Response Object
   */
  public static Response getConflict(Object serviceResponse) {
    return Response.status(Response.Status.CONFLICT).entity(serviceResponse).build();
  }



  /**
   * Logs the incoming request for debugging purpose.
   *
   * @param logger  SLF4J Logger object
   * @param uriInfo Context URI
   * @param request Context Request
   */
  public static void logIncomingRequestInfo(Logger logger, UriInfo uriInfo,
                                            ContainerRequestContext request) {
    if (logger.isDebugEnabled()) {
      logger.debug("Incoming request: {} - {}", request.getMethod(), uriInfo.getRequestUri());
    }
  }


}
