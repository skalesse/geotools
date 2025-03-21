/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2011, Open Source Geospatial Foundation (OSGeo)
 *    (C) 2005 Open Geospatial Consortium Inc.
 *
 *    All Rights Reserved. http://www.opengis.org/legal/
 */

/**
 * An <CITE>expression</CITE> is a combination of one or more elements that evaluate to single {@link java.lang.Object}
 * value.
 *
 * <p>The following is adapted from Filter encoding specifications:
 *
 * <ul>
 *   <li><A HREF="http://www.opengis.org/docs/02-059.pdf">Filter Encoding 1.0</a>
 *   <li><A HREF="http://portal.opengeospatial.org/files/?artifact_id=8340">OpenGIS&reg; Filter Encoding Implementation
 *       Specification Version 1.1</a>
 *   <li><A HREF="http://portal.opengeospatial.org/files/?artifact_id=5929">OpenGIS&reg; Catalogue Service
 *       Implementation Specification 2.0.1</a>
 * </ul>
 *
 * <P ALIGN="justify">An <CITE>expression</CITE> can be formed using the elements:
 * {@link org.geotools.api.filter.expression.Add}, {@link org.geotools.api.filter.expression.Subtract},
 * {@link org.geotools.api.filter.expression.Multiply}, {@link org.geotools.api.filter.expression.Divide},
 * {@link org.geotools.api.filter.expression.PropertyName}, {@link org.geotools.api.filter.expression.Literal} and
 * {@link org.geotools.api.filter.expression.Function}. They all belong to the substitution group expression which means
 * that any of them can be used wherever an expression is called for. In addition, the combinations of these elements
 * are themselves expressions and can be used wherever an expression is called for.
 *
 * <H3>Arithmetic operators</H3>
 *
 * <P ALIGN="justify">The elements defined in this package are used to encode the fundamental arithmetic operations of
 * addition, subtraction, multiplication and division. Arithmetic operators are binary operators meaning that they
 * accept two arguments and evaluate to a single result.
 *
 * <H3>Literals</H3>
 *
 * <P ALIGN="justify">A literal value is any part of a statement or expression that is to be used exactly as it is
 * specified, rather than as a variable or other element. The {@link org.geotools.api.filter.expression.Literal} element
 * is used to encode literal scalar and geometric values.
 *
 * <H3>Functions</H3>
 *
 * <P ALIGN="justify">A function is a named procedure that performs a distinct computation. A function may accept zero
 * or more arguments as input and generates a single result. A function is composed of the name of the function, encoded
 * using the attribute name, and zero or more arguments contained within the
 * {@link org.geotools.api.filter.expression.Function} element. The arguments themselves are
 * {@linkplain org.geotools.api.filter.expression.Expression expressions}.
 *
 * <h3>Data Access
 *
 * <h3>
 *
 * <P ALIGN="justify">Data access is acomplished by means of {@link org.geotools.api.filter.expression.PropertyName}
 * expressions. These Expressions are independent of the data being queried and form the foundation of a, very simple,
 * general query language offering independence specific bindings to Feature, Metadata and Record data structures.
 *
 * <h3>Filter Encodings
 *
 * <h3>
 *
 * <P ALIGN="justify">At the time of this writing the Filter API has standard encodings for XML (Filter 1.0 and Filter
 * 1.1) and Text (a BNF form is provided in the Catalog 2.0.1 specification above). You should be warned that not all
 * content can be expressed in all encodings, please refer to the javadocs for specific limitations.
 */
package org.geotools.api.filter.expression;

// Annotations
