/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2016, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.wfs.bindings;

import javax.xml.namespace.QName;
import net.opengis.wfs.PropertyType;
import net.opengis.wfs.WfsFactory;
import org.geotools.gml2.GML;
import org.geotools.gml2.GMLConfiguration;
import org.geotools.wfs.WFS;
import org.geotools.xsd.AbstractComplexEMFBinding;
import org.geotools.xsd.ElementInstance;
import org.geotools.xsd.Encoder;
import org.geotools.xsd.EncoderDelegate;
import org.geotools.xsd.Node;
import org.locationtech.jts.geom.Geometry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.helpers.AttributesImpl;

/**
 * Binding object for the type http://www.opengis.net/wfs:PropertyType.
 *
 * <p>
 *
 * <pre>
 *         <code>
 *  &lt;xsd:complexType name="PropertyType"&gt;
 *      &lt;xsd:sequence&gt;
 *          &lt;xsd:element name="Name" type="xsd:QName"&gt;
 *              &lt;xsd:annotation&gt;
 *                  &lt;xsd:documentation&gt;
 *                    The Name element contains the name of a feature property
 *                    to be updated.
 *                 &lt;/xsd:documentation&gt;
 *              &lt;/xsd:annotation&gt;
 *          &lt;/xsd:element&gt;
 *          &lt;xsd:element minOccurs="0" name="Value"&gt;
 *              &lt;xsd:annotation&gt;
 *                  &lt;xsd:documentation&gt;
 *                    The Value element contains the replacement value for the
 *                    named property.
 *                 &lt;/xsd:documentation&gt;
 *              &lt;/xsd:annotation&gt;
 *          &lt;/xsd:element&gt;
 *      &lt;/xsd:sequence&gt;
 *  &lt;/xsd:complexType&gt;
 *
 *          </code>
 *         </pre>
 *
 * @generated
 */
public class PropertyTypeBinding extends AbstractComplexEMFBinding {

    private static final String VALUE = "Value";

    public PropertyTypeBinding(WfsFactory factory) {
        super(factory);
    }

    /** @generated */
    @Override
    public QName getTarget() {
        return WFS.PropertyType;
    }

    @Override
    public Element encode(Object object, Document document, Element value) throws Exception {
        return value;
    }

    /**
     *
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated modifiable
     */
    @Override
    public Object parse(ElementInstance instance, Node node, Object value) throws Exception {
        // TODO: implement and remove call to super
        return super.parse(instance, node, value);
    }

    @Override
    public Object getProperty(final Object object, QName name) throws Exception {
        if (VALUE.equals(name.getLocalPart())) {
            return (EncoderDelegate) output -> {
                Object value = ((PropertyType) object).getValue();

                output.startElement(WFS.NAMESPACE, VALUE, "wfs:" + VALUE, new AttributesImpl());
                if (value instanceof Geometry) {
                    Encoder encoder = new Encoder(new GMLConfiguration());
                    encoder.setInline(true);
                    encoder.encode(value, GML._Geometry, output);
                } else {
                    String s = value.toString();
                    output.characters(s.toCharArray(), 0, s.length());
                }
                output.endElement(WFS.NAMESPACE, VALUE, "wfs:" + VALUE);
            };
        }

        return super.getProperty(object, name);
    }
}
