@XmlSchema(
        namespace = BeerEndpoint.NAMESPACE_URI,
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix="auth", namespaceURI = Authentication.AUTH_NS)
        }
)

package com.memorynotfound.client;

import com.memorynotfound.server.BeerEndpoint;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;