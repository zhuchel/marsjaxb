package de.bundesbank;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import de.bundesbank.mars.Address;
import de.bundesbank.mars.Customer;

public class Demo {

	public static void main(String[] args) throws Exception {
		Customer customer = new Customer();
		Address info = new Address();
		info.setStreet("1 A Street");
		customer.setContactInfo(info);
//
		QName qname = new QName("http://www.namespace.com/schema/My", "My");
		Marshaller marshaller = JAXBContext.newInstance(Customer.class)
				.createMarshaller();
		JAXBElement<Customer> element = new JAXBElement<Customer>(qname,
				Customer.class, customer);

		 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 marshaller.marshal(element,
		 System.out);

//		StringWriter stringWriter = new StringWriter();
//		XMLStreamWriter writer = new NoNamespacesWriterWrapper(
//				(XMLStreamWriter) XMLOutputFactory.newInstance()
//						.createXMLStreamWriter(stringWriter));
//		marshaller.marshal(element, writer);
//		System.out.println(stringWriter.toString());

	}

}
