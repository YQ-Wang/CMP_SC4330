/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import javafx.scene.control.TextArea;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Yiqing Wang
 */
public class XMLLoader {
    
    public static void load(String uri,TextArea textArea) throws Exception {
        
        try {
            textArea.setText("");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
                
                String currentValue=null;
                String currentTag=null;
                int depth=0;
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    for(int i=0;i<depth*2;i++)
                    {
                        textArea.appendText(" ");
                    }
                    depth++;
                    textArea.appendText(qName);
                    if(attributes!=null&&attributes.getLength()>0){
                        textArea.appendText(" (Attributes: ");
                        for(int i=0;i<attributes.getLength();i++){
                            textArea.appendText( attributes.getQName(i) + ":" + attributes.getValue(i) + ' ');
                        }
                        textArea.appendText(")");
                    }
                    currentTag=qName;
                }
                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    depth--;
                    if(depth==1)
                        textArea.appendText("--------------\n");
                }
                
                @Override
                public void characters(char ch[], int start, int length) throws SAXException { 
                    if(currentTag!=null){
                        currentValue=new String(ch,start,length);
                        if(!currentValue.isEmpty()&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n")){
                            textArea.appendText(":" + currentValue);
                        }
                        textArea.appendText("\n");
                        currentTag=null;
                    }
                }
            };
            
            saxParser.parse(uri, handler);
        } catch (Exception e) {
            throw e;
        }
    }
}
