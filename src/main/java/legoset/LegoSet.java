package legoset;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.Year;

import javax.xml.bind.annotation.XmlAccessType;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "theme", "subtheme", "year", "pieces", "tags", "minifigs", "weight", "url"})
@Data
public class LegoSet {
	private String name;
	private String theme;
	private String subtheme;
	
	@XmlJavaTypeAdapter(YearAdapter.class)
	private Year year;
	private int pieces;
	
	@XmlElementWrapper(name = "tags")
    @XmlElement(name = "tag")
	private java.util.Set<String> tags;
	
	@XmlElementWrapper(name = "minifigs")
    @XmlElement(name = "minifig")
	private java.util.List<Minifig> minifigs;
	
	private Weight weight;
	
	private String url;
}
