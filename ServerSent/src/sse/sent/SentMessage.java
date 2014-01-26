package sse.sent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
@Path("/event")
public class SentMessage {
	
@Path("/message")
@GET
	 public void message(@Context HttpServletResponse response){
		response.setContentType("text/event-stream");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Connection", "keep-alive");
	PrintWriter out = null;
	try {
		out = response.getWriter();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	while(true) {
	   out.print("data:" + "Current Server Time is:" + new Date().toString() + "\n\n");
	   out.flush();
	  Thread.currentThread();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}	
}

}

			  