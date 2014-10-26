package de.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import de.jaxb.lib.Book;
import de.jaxb.lib.Library;



public class Xslt {

	public static void main(String[] args) throws Exception {
		
		callDemo();

		TransformerFactory tf = TransformerFactory.newInstance();
		StreamSource xslt = new StreamSource(
				"src/main/resources/xslt/test.xsl");

		Transformer transformer = tf.newTransformer(xslt);

		Book book1 = new Book();
		book1.setAuthor("Jane Doe");
		book1.setTitle("Some Book");

		Book book2 = new Book();
		book2.setAuthor("John Smith");
		book2.setTitle("Another Novel");

		Library catalog = new Library();
		catalog.getBook().add(book1);
		catalog.getBook().add(book2);

		QName qname = new QName("http://www.namespace.com/schema/My", "My");
		JAXBContext jc = JAXBContext.newInstance(new Class[] {Library.class});
		

		Marshaller marshaller = jc.createMarshaller();
		JAXBElement<Library> element = new JAXBElement<Library>(qname,
		Library.class, catalog);

		JAXBSource source = new JAXBSource(jc, catalog);
		StreamResult result = new StreamResult(System.out);

		// Transform
		transformer.transform(source, result);

//		 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		 marshaller.marshal(element,
//		 System.out);

	}

	private static void callDemo() throws JAXBException {
		
//		Customer customer = new Customer();
//		Address info = new Address();
//		info.setStreet("1 A Street");
//		customer.setContactInfo(info);
//
//		QName qname = new QName("http://www.namespace.com/schema/My", "Customer");
//		Marshaller marshaller = JAXBContext.newInstance(Customer.class)
//				.createMarshaller();
//		JAXBElement<Customer> element = new JAXBElement<Customer>(qname,
//				Customer.class, customer);
//
//		 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		 marshaller.marshal(element,
//		 System.out);
//		 System.out.println("----------------------");
		
	}

}
