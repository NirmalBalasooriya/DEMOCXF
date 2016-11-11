package com.mycompany.camel.cxf.code.first.spring.incident;

import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;

public class MyFirstRouterBuilder  extends RouteBuilder {
    @Override
   public void configure() throws Exception {

       try{
    	   //DataFormat jaxb = new JaxbDataFormat("com.mycompany.camel.cxf.code.first.spring.incident");
           from( "file:c:/vids").to("file:c:/vids2");
           //from("direct:reportIncident").bean(bean)
           from("direct:reportIncident")
           //.marshal(jaxb)
           /*.bean(InputReportIncident.class)*/
           .to("file:data/out");
       }catch(Exception e){

       }

    }

}
