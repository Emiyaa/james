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

import java.util.Collection;

/**
 * This interface define the behaviour of the message "routing" inside
 * the mailet container. The match(Mail) method returns a Collection of
 * recipients that meet this class's criteria.
 * <p>
 * An important feature of the mailet container is the ability to fork
 * processing of messages.  When a message first arrives at the server,
 * it might have multiple recipients specified.  As a message is passed
 * to a matcher, the matcher might only "match" one of the listed
 * recipients.  It would then return only the matching recipient in
 * the Collection.  The mailet container should then duplicate the
 * message splitting the recipient list across the two messages as per
 * what the matcher returned.
 * <p>
 * <b>[THIS PARAGRAPH NOT YET IMPLEMENTED]</b>
 * <i>The matcher can extend this forking to further separation by returning
 * a Collection of Collection objects.  This allows a matcher to fork
 * multiple processes if there are multiple recipients that require
 * separate processing.  For example, we could write a ListservMatcher
 * that handles multiple listservs.  When someone cross-posts across
 * multiple listservs that this matcher handles, it could put each
 * listserv address (recipient) that it handles in a separate Collection
 * object.  By returning each of these Collections within a container
 * Collection object, it could indicate to the mailet container how
 * many forks to spawn.</i>
 * <p>
 * This interface defines methods to initialize a matcher, to match
 * messages, and to remove a matcher from the server. These are known
 * as life-cycle methods and are called in the following sequence:
 * <ol>
 * <li>The matcher is constructed, then initialized with the init method.</li>
 * <li>Any calls from clients to the match method are handled.</li>
 * <li>The matcher is taken out of service, then destroyed with the
 *      destroy method, then garbage collected and finalized.</li>
 * </ol>
 * In addition to the life-cycle methods, this interface provides the
 * getMatcherConfig method, which the matcher can use to get any startup
 * information, and the getMatcherInfo method, which allows the matcher
 * to return basic information about itself, such as author, version,
 * and copyright.
 *
 * @version 1.0.0, 24/04/1999
 */
public interface Matcher {

    /**
     * Called by the mailet container to indicate to a matcher that the matcher
     * is being taken out of service. This method is only called once all threads
     * within the matcher's service method have exited or after a timeout period
     * has passed. After the mailet container calls this method, it will not call
     * the match method again on this matcher.
     * <p>
     * This method gives the matcher an opportunity to clean up any resources that
     * are being held (for example, memory, file handles, threads) and make sure
     * that any persistent state is synchronized with the matcher's current state in memory.
     */
    void destroy();

    /**
     * Returns a MatcherConfig object, which contains initialization and
     * startup parameters for this matcher.
     * <p>
     * Implementations of this interface are responsible for storing the
     * MatcherConfig object so that this method can return it. The GenericMatcher
     * class, which implements this interface, already does this.
     *
     * @return the MatcherConfig object that initializes this matcher
     */
    MatcherConfig getMatcherConfig();

    /**
     * Returns information about the matcher, such as author, version, and copyright.
     * <p>
     * The string that this method returns should be plain text and not markup
     * of any kind (such as HTML, XML, etc.).
     *
     * @return a String containing matcher information
     */
    String getMatcherInfo();

    /**
     * Called by the mailet container to indicate to a matcher that the
     * matcher is being placed into service.
     * <p>
     * The mailet container calls the init method exactly once after instantiating
     * the matcher. The init method must complete successfully before the matcher
     * can receive any messages.
     *
     * @param config - a MatcherConfig object containing the matcher's configuration
     *          and initialization parameters
     * @throws javax.mail.MessagingException - if an exception has occurred that
     *          interferes with the matcher's normal operation
     */
    void init(MatcherConfig config) throws javax.mail.MessagingException;

    /**
     * Takes a Mail message, looks at any pertinent information, and then returns a subset
     * of recipients that meet the "match" conditions.
     * <p>
     * This method is only called after the matcher's init() method has completed
     * successfully.
     * <p>
     * Matchers typically run inside multithreaded mailet containers that can handle
     * multiple requests concurrently. Developers must be aware to synchronize access
     * to any shared resources such as files, network connections, and as well as the
     * matcher's class and instance variables. More information on multithreaded
     * programming in Java is available in <a href="http://java.sun.com/Series/Tutorial/java/threads/multithreaded.html">the
     * Java tutorial on multi-threaded programming</a>.
     *
     * @param mail - the Mail object that contains the message and routing information
     * @return a Collection of String objects (recipients) that meet the match criteria
     * @throws MessagingException - if an message or address parsing exception occurs or
     *      an exception that interferes with the matcher's normal operation
     */
    Collection match(Mail mail) throws javax.mail.MessagingException;
}
