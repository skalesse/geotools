/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2011, Open Source Geospatial Foundation (OSGeo)
 *    (C) 2003-2005, Open Geospatial Consortium Inc.
 *
 *    All Rights Reserved. http://www.opengis.org/legal/
 */
package org.geotools.api.referencing.operation;

/**
 * Base interface for conical map projections.
 *
 * <p>&nbsp;
 *
 * <p align="center"><img src="../doc-files/ConicProjection.png">
 *
 * @author Martin Desruisseaux (IRD)
 * @since GeoAPI 1.0
 * @see org.geotools.api.referencing.crs.ProjectedCRS
 * @see <A HREF="http://mathworld.wolfram.com/ConicProjection.html">Conic projection on MathWorld</A>
 */
public interface ConicProjection extends Projection {}
