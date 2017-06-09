/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.mailet;

import javax.mail.MessagingException;
import java.util.Iterator;

/**
 * GenericMailet makes writing mailets easier. It provides simple
 * versions of the lifecycle methods init and destroy and of the methods
 * in the MailetConfig interface. GenericMailet also implements the log
 * method, declared in the MailetContext interface.
 * <p>
 * To write a generic mailet, you need only override the abstract service
 * method.
 *
 * @version 1.0.0, 24/04/1999
 */
public abstract class GenericMailet implements Mailet, MailetConfig {
    private MailetConfig config = null;

    /**
     * Called by the mailer container to indicate to a mailet that the
     * mailet is being taken out of service.
     */
    public void destroy() {
        //Do nothing
    }

    /**
     * Returns a String containing the value of the named initialization
     * parameter, or null if the parameter does not exist.
     * <p>
     * This method is supplied for convenience. It gets the value of the
     * named parameter from the mailet's MailetConfig object.
     *
     * @param name - a String specifying the name of the initialization parameter
     * @return a String containing the value of the initalization parameter
     */
    public String getInitParameter(String name) {
        return config.getInitParameter(name);
    }

    /**
     * Returns a String containing the value of the named initialization
     * parameter, or defValue if the parameter does not exist.
     * <p>
     * This method is supplied for convenience. It gets the value of the
     * named parameter from the mailet's MailetConfig object.
     *
     * @param name - a String specifying the name of the initialization parameter
     * @param defValue - a String specifying the default value when the parameter
     *                    is not present
     * @return a String containing the value of the initalization parameter
     */
    public String getInitParameter(String name, String defValue) {
        String res = config.getInitParameter(name);
        if (res == null) {
            return defValue;
        } else {
            return res;
        }
    }

    /**
     * Returns the names of the mailet's initialization parameters as an
     * Iterator of String objects, or an empty Iterator if the mailet has no
     * initialization parameters.
     * <p>
     * This method is supplied for convenience. It gets the parameter names from
     * the mailet's MailetConfig object.
     *
     * @return an Iterator of String objects containing the names of
     *          the mailet's initialization parameters
     */
    public Iterator getInitParameterNames() {
        return config.getInitParameterNames();
    }

    /**
     * Returns this Mailet's MailetConfig object.
     *
     * @return the MailetConfig object that initialized this mailet
     */
    public MailetConfig getMailetConfig() {
        return config;
    }

    /**
     * Returns a reference to the MailetContext in which this mailet is
     * running.
     *
     * @return the MailetContext object passed to this mailet by the init method
     */
    public MailetContext getMailetContext() {
        return getMailetConfig().getMailetContext();
    }

    /**
     * Returns information about the mailet, such as author, version, and
     * copyright.  By default, this method returns an empty string. Override
     * this method to have it return a meaningful value.
     *
     * @return information about this mailet, by default an empty string
     */
    public String getMailetInfo() {
        return "";
    }

    /**
     * Returns the name of this mailet instance.
     *
     * @return the name of this mailet instance
     */
    public String getMailetName() {
        return config.getMailetName();
    }


    public void init(MailetConfig newConfig) throws MessagingException {
        config = newConfig;
        init();
    }

    /**
     * <p>A convenience method which can be overridden so that there's no
     * need to call super.init(config).</p>
     *
     * Instead of overriding init(MailetConfig), simply override this
     * method and it will be called by GenericMailet.init(MailetConfig config).
     * The MailetConfig object can still be retrieved via getMailetConfig().
     *
     * @throws javax.mail.MessagingException
     *          if an exception occurs that interrupts the mailet's normal operation
     */
    public void init() throws MessagingException {
        //Do nothing... can be overriden
    }

    /**
     * Writes the specified message to a mailet log file, prepended by
     * the mailet's name.
     *
     * @param message - a String specifying the message to be written to the log file
     */
    public void log(String message) {
        StringBuffer logBuffer =
            new StringBuffer(256)
                    .append(getMailetName())
                    .append(": ")
                    .append(message);
        getMailetContext().log(logBuffer.toString());
    }

    /**
     * Writes an explanatory message and a stack trace for a given Throwable
     * exception to the mailet log file, prepended by the mailet's name.
     *
     * @param message - a String that describes the error or exception
     * @param t - the java.lang.Throwable to be logged
     */
    public void log(String message, Throwable t) {
        StringBuffer logBuffer =
            new StringBuffer(256)
                    .append(config.getMailetName())
                    .append(": ")
                    .append(message);
        getMailetContext().log(logBuffer.toString(), t);
    }

    /**
     * <p>Called by the mailet container to allow the mailet to process a
     * message.</p>
     *
     * <p>This method is declared abstract so subclasses must override it.</p>
     *
     * @param mail - the Mail object that contains the MimeMessage and
     *          routing information
     * @throws javax.mail.MessagingException - if an exception occurs that interferes with the mailet's normal operation
     */
    public abstract void service(Mail mail) throws MessagingException;
}


