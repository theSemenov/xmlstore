package org.xmlstore.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xmlstore.model.Cd;
import org.xmlstore.model.CdStore;
import org.xmlstore.model.Page;
import org.xmlstore.model.PropHolder;


@Controller(value="/")
public class StoreController {

	private JAXBContext context;
	private Unmarshaller unmarshaller;
	private Marshaller marshaller;
	private String xmlStorePath = new String(System.getProperty("user.dir") + "/store.xml");

	{
		try {
			context = JAXBContext.newInstance(Cd.class, CdStore.class);
			unmarshaller = context.createUnmarshaller();
			marshaller = context.createMarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
			
		}
	}

	@RequestMapping(value = "/")
	public String index() {
		 return "redirect:view";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView upload(Model model) {
		ModelAndView mv = new ModelAndView("upload");
		mv.addObject(PropHolder.PAGE_ID_PROP, PropHolder.PAGE_UPLOAD_VAL);
		return mv;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String uploadFile(HttpServletRequest request,  HttpServletResponse response, @RequestParam("datafile") MultipartFile file) throws XMLStreamException, FactoryConfigurationError, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if (!file.isEmpty()) {
			XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(file.getInputStream());
			LowerCaseStreamReaderDelegate readerDelegate = new LowerCaseStreamReaderDelegate(reader);
			try {
				CdStore store = getCdStore();
				Cd cd = (Cd) unmarshaller.unmarshal(readerDelegate);
				store.addCd(cd);
				flushCdStore(store);
			} catch (JAXBException e) {
				return "Неверная структура XML файла";
			}
		}
		return "Ok";
	}

	@RequestMapping("download")
	public void download(HttpServletRequest request,  HttpServletResponse response) throws IOException {
		Path path = Paths.get(xmlStorePath);
		response.setContentType("text/xml");
        response.setContentLength((int)Files.size(path));
        response.setHeader("Content-Disposition", "attachment; filename=store.xml");
		Files.copy(path, response.getOutputStream());
	}
	
	@RequestMapping(value="view")
	public ModelAndView view(Model model) {
		ModelAndView mv = new ModelAndView("dataview");
		mv.addObject(PropHolder.PAGE_ID_PROP, PropHolder.PAGE_VIEW_VAL);
		return mv;
	
	}

	@RequestMapping(value="/view/xml")
	public @ResponseBody Page<Cd> viewXML(
			@RequestParam(value = "page", required = false, defaultValue = "1")int page,
			@RequestParam(value = "max", required = false, defaultValue = "10")int max,
			Model model) {
		CdStore store = getCdStore();
		Set<Cd> cdStore = store.getCatalog();
		int startIdx = (page - 1) * max;
		int endIdx = Math.min(startIdx + max, cdStore.size());
		List<Cd> pageContent = new ArrayList<>(cdStore);
		return new Page<Cd>(page, max, cdStore.size(), pageContent.subList(startIdx, endIdx));
	}

	private void testSute(CdStore store) {
		for (int i = 0 ;i<= 100 ;i++) {
			Cd cd = new Cd(); 
			cd.setTitle("Titl" + i);
			cd.setArtist("artist" + i);
			cd.setPrice(new Double(i));
			store.addCd(cd);
		}
		
	}
	
	private CdStore getCdStore() {
		CdStore store = null;
		try {
			InputStream is = new FileInputStream(xmlStorePath);
			synchronized (this) {
				store =  (CdStore) unmarshaller.unmarshal(is);
			}
		} catch (JAXBException | IOException e) {
			store = new CdStore();
		}
		return store;
	}
	
	private void flushCdStore(CdStore store) {
		if (store != null) {
			synchronized (this) {
				try {
					OutputStream os = new FileOutputStream(xmlStorePath);
					marshaller.marshal(store, os);
				} catch (JAXBException | FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
