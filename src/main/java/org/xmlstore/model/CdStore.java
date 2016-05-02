package org.xmlstore.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="catalog")
public class CdStore {
	
	
	private Set<Cd> catalog = new HashSet<Cd>();
	
	public CdStore() {
		
	}
	@XmlElement(name="cd")
	public Set<Cd> getCatalog() {
		return catalog;
	}

	public void setCatalog(Set<Cd> catalog) {
		this.catalog = catalog;
	}
	
	public void addCd(Cd cd) {
		if(catalog.contains(cd)) {
			catalog.remove(cd);
		}
		catalog.add(cd);
	}
}
