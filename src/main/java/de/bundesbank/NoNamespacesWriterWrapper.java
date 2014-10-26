package de.bundesbank;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

class NoNamespacesWriterWrapper implements XMLStreamWriter {

	private XMLStreamWriter wrappedStreamWriter;

	public NoNamespacesWriterWrapper(XMLStreamWriter wrappedStreamWriter) {
		this.wrappedStreamWriter = wrappedStreamWriter;
	}

	public void close() throws XMLStreamException {
		wrappedStreamWriter.close();
	}

	public void flush() throws XMLStreamException {
		wrappedStreamWriter.flush();
	}

	public NamespaceContext getNamespaceContext() {
		return wrappedStreamWriter.getNamespaceContext();
	}

	public String getPrefix(String uri) throws XMLStreamException {
		return wrappedStreamWriter.getPrefix(uri);
	}

	public Object getProperty(String name) throws IllegalArgumentException {
		return wrappedStreamWriter.getProperty(name);
	}

	public void setDefaultNamespace(String uri) throws XMLStreamException {
		wrappedStreamWriter.setDefaultNamespace(uri);
	}

	public void setNamespaceContext(NamespaceContext context)
			throws XMLStreamException {
		wrappedStreamWriter.setNamespaceContext(context);
	}

	public void setPrefix(String prefix, String uri) throws XMLStreamException {
		wrappedStreamWriter.setPrefix(prefix, uri);
	}

	public void writeAttribute(String localName, String value)
			throws XMLStreamException {
		wrappedStreamWriter.writeAttribute(localName, value);
	}

	public void writeAttribute(String namespaceURI, String localName,
			String value) throws XMLStreamException {
		System.out.println("##### name:" + localName + ", value:" + value);
		writeAttribute(localName, value);
	}

	public void writeAttribute(String prefix, String namespaceURI,
			String localName, String value) throws XMLStreamException {
		System.out.println("writeAttribute1 ##### name:" + localName
				+ ", value:" + value);
		writeAttribute(localName, value);
	}

	public void writeCData(String data) throws XMLStreamException {
		System.out.println("writeCData##### data:" + data);
		wrappedStreamWriter.writeCData(data);
	}

	public void writeCharacters(String text) throws XMLStreamException {
		System.out.println("writeCharacters##### text:" + text);
		wrappedStreamWriter.writeCharacters(text);
	}

	public void writeCharacters(char[] text, int start, int len)
			throws XMLStreamException {
		System.out.println("writeCharacters##### start:" + start + ", len:"
				+ len);
		wrappedStreamWriter.writeCharacters(text, start, len);
	}

	public void writeComment(String data) throws XMLStreamException {
		wrappedStreamWriter.writeComment(data);
	}

	public void writeDTD(String dtd) throws XMLStreamException {
		wrappedStreamWriter.writeDTD(dtd);
	}

	public void writeDefaultNamespace(String namespaceURI)
			throws XMLStreamException {
		wrappedStreamWriter.writeDefaultNamespace(namespaceURI);
	}

	public void writeEmptyElement(String localName) throws XMLStreamException {
		wrappedStreamWriter.writeEmptyElement(localName);
	}

	public void writeEmptyElement(String namespaceURI, String localName)
			throws XMLStreamException {
		writeEmptyElement(localName);
	}

	public void writeEmptyElement(String prefix, String localName,
			String namespaceURI) throws XMLStreamException {
		writeEmptyElement(localName);
	}

	public void writeEndDocument() throws XMLStreamException {
		wrappedStreamWriter.writeEndDocument();
	}

	public void writeEndElement() throws XMLStreamException {
		wrappedStreamWriter.writeEndElement();
	}

	public void writeEntityRef(String name) throws XMLStreamException {
		System.out.println("writeEntityRef##### :" + name);
		wrappedStreamWriter.writeEntityRef(name);
	}

	public void writeNamespace(String prefix, String namespaceURI)
			throws XMLStreamException {

		return;
		// wrappedStreamWriter.writeNamespace(prefix, namespaceURI);
		// if(namespaces.contains(namespaceURI)){
		// return;
		// }
		// namespaces.add(namespaceURI);
		// writer.writeNamespace(prefix, namespaceURI);

	}

	public void writeProcessingInstruction(String target)
			throws XMLStreamException {
		System.out.println("writeProcessingInstruction##### :" + target);
		wrappedStreamWriter.writeProcessingInstruction(target);
	}

	public void writeProcessingInstruction(String target, String data)
			throws XMLStreamException {
		System.out.println("writeProcessingInstruction##### target:" + target
				+ ", data:" + data);
		wrappedStreamWriter.writeProcessingInstruction(target, data);
	}

	public void writeStartDocument() throws XMLStreamException {
		wrappedStreamWriter.writeStartDocument();
	}

	public void writeStartDocument(String version) throws XMLStreamException {
		wrappedStreamWriter.writeStartDocument();
	}

	public void writeStartDocument(String encoding, String version)
			throws XMLStreamException {
		wrappedStreamWriter.writeStartDocument(encoding, version);
	}

	public void writeStartElement(String localName) throws XMLStreamException {
		System.out.println("writeStartElement##### localName:" + localName);
		wrappedStreamWriter.writeStartElement(localName);
	}

	public void writeStartElement(String namespaceURI, String localName)
			throws XMLStreamException {
		System.out.println("writeStartElement##### localName:" + localName
				+ ", namespaceURI:" + namespaceURI);
		writeStartElement(localName);
	}

	public void writeStartElement(String prefix, String localName,
			String namespaceURI) throws XMLStreamException {
		System.out.println("writeStartElement##### localName:" + localName
				+ ", namespaceURI:" + namespaceURI + ", prefix:" + prefix);
//		if(localName.equals("contactInfo")) {
//			localName = localName + "     xsi:type=address";
//		}
		writeStartElement(localName);
	}

}