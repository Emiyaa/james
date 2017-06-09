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

/**
 * Draft of a Mailet inteface. The <code>service</code> perform all needed work
 * on the Mail object. Whatever remains at the end of the service is considered
 * to need futher processing and will go to the next Mailet if there is one
 * configured or will go to the error processor if not.
 * Setting a Mail state (setState(String)) to Mail.GHOST or cleaning its recipient
 * list has the same meaning that s no more processing is needed.
 * Instead of creating new messages, the mailet can put a message with new recipients
 * at the top of the mail queue, or insert them immediately after it's execution
 * through the API are provided by the MailetContext interface.
 * <p>
 * This interface defines methods to initialize a mailet, to service messages, and to
 * remove a mailet from the server. These are known as life-cycle methods and are called
 * in the following sequence:
 * <ol>
 * <li>The mailet is constructed, then initialized with the init method. </li>
 * <li>Any messages for the service method are handled.</li>
 * <li>The mailet is taken out of service, then destroyed with the destroy method,
 *      then garbage collected and finalized.</li>
 * </ol>
 * In addition to the life-cycle methods, this interface provides the getMailetConfig
 * method, which the mailet can use to get any startup information, and the
 * getMailetInfo method, which allows the mailet to return basic information about itself,
 * such as author, version, and copyright.
 *
 * @version 1.0.0, 24/04/1999
 */
public interface Mailet {

    /**
     * Called by the mailet container to indicate to a mailet that the
     * mailet is being taken out of service. This method is only called once
     * all threads within the mailet's service method have exited or after a
     * timeout period has passed. After the mailet container calls this method,
     * it will not call the service method again on this mailet.
     * <p>
     * This method gives the mailet an opportunity to clean up any resources that
     * are being held (for example, memory, file handles, threads) and make sure
     * that any persistent state is synchronized with the mailet's current state in memory.
     */
    void destroy();

    /**
     * Returns information about the mailet, such as author, version, and
     * copyright.
     * <p>
     * The string that this method returns should be plain text and not markup
     * of any kind (such as HTML, XML, etc.).
     *
     * @return a String containing servlet information
     */
    String getMailetInfo();

    /**
     * Returns a MailetConfig object, which contains initialization and
     * startup parameters for this mailet.
     * <p>
     * Implementations of this interface are responsible for storing the MailetConfig
     * object so that this method can return it. The GenericMailet class, which implements
     * this interface, already does this.
     *
     * @return the MailetConfig object that initializes this mailet
     */
    MailetConfig getMailetConfig();

    /**
     * Called by the mailet container to indicate to a mailet that the
     * mailet is being placed into service.
     * <p>
     * The mailet container calls the init method exactly once after
     * instantiating the mailet. The init method must complete successfully
     * before the mailet can receive any requests.
     *
     * @param config - a MailetConfig object containing the mailet's configuration
     *          and initialization parameters
     * @throws javax.mail.MessagingException - if an exception has occurred that interferes with
     *          the mailet's normal operation
     */
    void init(MailetConfig config) throws javax.mail.MessagingException;

    /**
     * Called by the mailet container to allow the mailet to process to
     * a message.
     * <p>
     * This method is only called after the mailet's init() method has completed
     * successfully.
     * <p>
     * Mailets typically run inside multithreaded mailet containers that can handle
     * multiple requests concurrently. Developers must be aware to synchronize access
     * to any shared resources such as files, network connections, as well as the
     * mailet's class and instance variables. More information on multithreaded
     * programming in Java is available in <a href="http://java.sun.com/Series/Tutorial/java/threads/multithreaded.html">the
     * Java tutorial on multi-threaded programming</a>.
     *
     * @param mail - the Mail object that contains the message and routing information
     * @throws javax.mail.MessagingException - if a message or address parsing exception occurs or
     *      an exception that interferes with the mailet's normal operation
     */
    void service(Mail mail) throws javax.mail.MessagingException;
}
