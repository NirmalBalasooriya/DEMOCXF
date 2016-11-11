package com.mycompany.camel.cxf.code.first.spring.incident;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class ObjectToXml implements Processor { 
private static final Logger log = Logger.getLogger("mockSql");
@Override
public void process(Exchange arg0) throws Exception {

    System.out.println("MyProcessor started");

    InputReportIncident incedent = arg0.getIn().getBody(InputReportIncident.class);

    try {

           // create JAXB context and initializing Marshaller
           JAXBContext jaxbContext = JAXBContext.newInstance(InputReportIncident.class);
           Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

           // for getting nice formatted output
           jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

           //specify the location and name of xml file to be created
           Calendar cal = Calendar.getInstance();
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		   String dateStr = dateFormat.format(cal.getTime());
           String fileName=dateStr+"_"+incedent.getIncidentId()+".xml";
           File XMLfile = new File("C:\\Sample\\"+fileName);
           XMLfile.getParentFile().mkdirs();
           XMLfile.createNewFile();

           // Writing to XML file
           jaxbMarshaller.marshal(incedent, XMLfile); 
           // Writing to console
           jaxbMarshaller.marshal(incedent, System.out); 

          } catch (JAXBException e) {
           // some exception occured
           e.printStackTrace();
          }

         }

}