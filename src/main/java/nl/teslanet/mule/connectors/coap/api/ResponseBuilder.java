/*-
 * #%L
 * Mule CoAP Connector
 * %%
 * Copyright (C) 2019 - 2020 (teslanet.nl) Rogier Cobben
 * 
 * Contributors:
 *     (teslanet.nl) Rogier Cobben - initial creation
 * %%
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is
 * available at https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * #L%
 */
package nl.teslanet.mule.connectors.coap.api;


import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.api.metadata.TypedValue;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.annotation.values.OfValues;


/**
 * The attributes of a CoAP response that is received or that will be returned.
 *
 */
public class ResponseBuilder
{

    // Mule seems to need this to be an inner enum.
    /**
     * Available response codes.
     *
     */
    public enum CoAPResponseCode
    {
        CONTENT,
        CREATED,
        CHANGED,
        DELETED,
        VALID,
        CONTINUE,
        BAD_REQUEST,
        UNAUTHORIZED,
        BAD_OPTION,
        FORBIDDEN,
        NOT_FOUND,
        METHOD_NOT_ALLOWED,
        NOT_ACCEPTABLE,
        REQUEST_ENTITY_INCOMPLETE,
        CONFLICT,
        PRECONDITION_FAILED,
        REQUEST_ENTITY_TOO_LARGE,
        UNSUPPORTED_CONTENT_FORMAT,
        UNPROCESSABLE_ENTITY,
        INTERNAL_SERVER_ERROR,
        NOT_IMPLEMENTED,
        BAD_GATEWAY,
        SERVICE_UNAVAILABLE,
        GATEWAY_TIMEOUT,
        PROXY_NOT_SUPPORTED,
        TOO_MANY_REQUESTS
    }

    /**
     * The CoAP response code to be set in the CoAP response.
     */
    @Parameter
    @Optional
    @Expression(ExpressionSupport.SUPPORTED)
    //@OfValues(ResponseCodeValueProvider.class)
    @Placement(tab= "Response", order= 1)
    @Summary("The CoAP response code of the response.")
    @Example("CONTENT")
    private CoAPResponseCode responseCode;

    /**
     * The payload of the CoAP response message. 
     */
    @Parameter
    @Content(primary= true)
    @Placement(tab= "Response", order= 2)
    @Summary("The payload of the CoAP response.")
    private TypedValue< Object > responsePayload;

    /**
     * @return the responseCode
     */
    public CoAPResponseCode getResponseCode()
    {
        return responseCode;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode( CoAPResponseCode responseCode )
    {
        this.responseCode= responseCode;
    }

    /**
     * @return the responsePayload
     */
    public TypedValue< Object > getResponsePayload()
    {
        return responsePayload;
    }

    /**
     * @param responsePayload the responsePayload to set
     */
    public void setResponsePayload( TypedValue< Object > responsePayload )
    {
        this.responsePayload= responsePayload;
    }
}
