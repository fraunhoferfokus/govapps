//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.19 at 11:35:19 AM CEST 
//


package de.fraunhofer.fokus.oefit.schemagen;

/*
 * #%L
 * govapps_data - Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT, 2,013
 * $Id:$
 * %%
 * Copyright (C) 2013 - 2015 Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT
 * %%
 * Copyright (c) 2,013, Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1) Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer.
 * 
 * 2) Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution.
 * 
 * 3) All advertising materials mentioning features or use of this software must 
 *    display the following acknowledgement: 
 *    This product includes software developed by Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT.
 * 
 * 4) Neither the name of the organization nor the names of its contributors may 
 *    be used to endorse or promote products derived from this software without 
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY COPYRIGHT HOLDER ''AS IS'' AND ANY EXPRESS OR 
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL 
 * Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Ein App-Eintrag
 * 
 * <p>Java class for ApplicationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplicationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RelatedTo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Logo" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Developer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Issuer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TargetOS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TargetDevice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="License" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Regions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Languages" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Categories" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegisteredDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LastModifiedDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Size" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Fee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Entitlements" type="{http://oeffentliche-it.de/GovApps-Export}EntitlementListType"/>
 *         &lt;element name="Links" type="{http://oeffentliche-it.de/GovApps-Export}LinkListType"/>
 *         &lt;element name="Media" type="{http://oeffentliche-it.de/GovApps-Export}MediaListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationType", propOrder = {
    "id",
    "relatedTo",
    "name",
    "logo",
    "description",
    "developer",
    "issuer",
    "targetOS",
    "targetDevice",
    "license",
    "regions",
    "languages",
    "categories",
    "registeredDate",
    "lastModifiedDate",
    "size",
    "fee",
    "entitlements",
    "links",
    "media"
})
public class ApplicationType {

    @XmlElement(name = "ID")
    protected long id;
    @XmlElement(name = "RelatedTo")
    protected long relatedTo;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Logo", required = true)
    protected byte[] logo;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Developer", required = true)
    protected String developer;
    @XmlElement(name = "Issuer", required = true)
    protected String issuer;
    @XmlElement(name = "TargetOS", required = true)
    protected String targetOS;
    @XmlElement(name = "TargetDevice", required = true)
    protected String targetDevice;
    @XmlElement(name = "License", required = true)
    protected String license;
    @XmlElement(name = "Regions", required = true)
    protected String regions;
    @XmlElement(name = "Languages", required = true)
    protected String languages;
    @XmlElement(name = "Categories", required = true)
    protected String categories;
    @XmlElement(name = "RegisteredDate")
    protected long registeredDate;
    @XmlElement(name = "LastModifiedDate")
    protected long lastModifiedDate;
    @XmlElement(name = "Size")
    protected int size;
    @XmlElement(name = "Fee")
    protected int fee;
    @XmlElement(name = "Entitlements", required = true)
    protected EntitlementListType entitlements;
    @XmlElement(name = "Links", required = true)
    protected LinkListType links;
    @XmlElement(name = "Media", required = true)
    protected MediaListType media;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setID(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the relatedTo property.
     * 
     */
    public long getRelatedTo() {
        return relatedTo;
    }

    /**
     * Sets the value of the relatedTo property.
     * 
     */
    public void setRelatedTo(long value) {
        this.relatedTo = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the logo property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getLogo() {
        return logo;
    }

    /**
     * Sets the value of the logo property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setLogo(byte[] value) {
        this.logo = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the developer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeveloper() {
        return developer;
    }

    /**
     * Sets the value of the developer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeveloper(String value) {
        this.developer = value;
    }

    /**
     * Gets the value of the issuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets the value of the issuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuer(String value) {
        this.issuer = value;
    }

    /**
     * Gets the value of the targetOS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetOS() {
        return targetOS;
    }

    /**
     * Sets the value of the targetOS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetOS(String value) {
        this.targetOS = value;
    }

    /**
     * Gets the value of the targetDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetDevice() {
        return targetDevice;
    }

    /**
     * Sets the value of the targetDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetDevice(String value) {
        this.targetDevice = value;
    }

    /**
     * Gets the value of the license property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicense() {
        return license;
    }

    /**
     * Sets the value of the license property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicense(String value) {
        this.license = value;
    }

    /**
     * Gets the value of the regions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegions() {
        return regions;
    }

    /**
     * Sets the value of the regions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegions(String value) {
        this.regions = value;
    }

    /**
     * Gets the value of the languages property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * Sets the value of the languages property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguages(String value) {
        this.languages = value;
    }

    /**
     * Gets the value of the categories property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategories() {
        return categories;
    }

    /**
     * Sets the value of the categories property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategories(String value) {
        this.categories = value;
    }

    /**
     * Gets the value of the registeredDate property.
     * 
     */
    public long getRegisteredDate() {
        return registeredDate;
    }

    /**
     * Sets the value of the registeredDate property.
     * 
     */
    public void setRegisteredDate(long value) {
        this.registeredDate = value;
    }

    /**
     * Gets the value of the lastModifiedDate property.
     * 
     */
    public long getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Sets the value of the lastModifiedDate property.
     * 
     */
    public void setLastModifiedDate(long value) {
        this.lastModifiedDate = value;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(int value) {
        this.size = value;
    }

    /**
     * Gets the value of the fee property.
     * 
     */
    public int getFee() {
        return fee;
    }

    /**
     * Sets the value of the fee property.
     * 
     */
    public void setFee(int value) {
        this.fee = value;
    }

    /**
     * Gets the value of the entitlements property.
     * 
     * @return
     *     possible object is
     *     {@link EntitlementListType }
     *     
     */
    public EntitlementListType getEntitlements() {
        return entitlements;
    }

    /**
     * Sets the value of the entitlements property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntitlementListType }
     *     
     */
    public void setEntitlements(EntitlementListType value) {
        this.entitlements = value;
    }

    /**
     * Gets the value of the links property.
     * 
     * @return
     *     possible object is
     *     {@link LinkListType }
     *     
     */
    public LinkListType getLinks() {
        return links;
    }

    /**
     * Sets the value of the links property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkListType }
     *     
     */
    public void setLinks(LinkListType value) {
        this.links = value;
    }

    /**
     * Gets the value of the media property.
     * 
     * @return
     *     possible object is
     *     {@link MediaListType }
     *     
     */
    public MediaListType getMedia() {
        return media;
    }

    /**
     * Sets the value of the media property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaListType }
     *     
     */
    public void setMedia(MediaListType value) {
        this.media = value;
    }

}