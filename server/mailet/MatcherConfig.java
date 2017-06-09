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
 * A matcher configuration object used by a mailet container used to pass information
 * to a matcher during initialization.
 * <p>
 * The configuration information contains an initialization parameter,
 * which is set as a condition String, and a MailetContext object,
 * which gives the mailet information about the mailet container.
 *
 * @version 1.0.0, 24/04/1999
 */
public interface MatcherConfig {

    /**
     * The simple condition defined for this matcher, e.g., for
     * SenderIs=admin@localhost, this would return admin@localhost.
     *
     * @return a String containing the value of the initialization parameter
     */
    String getCondition();

    /**
     * Returns a reference to the MailetContext in which the matcher is executing
     *
     * @return a MailetContext object, used by the matcher to interact with its
     *      mailet container
     */
    MailetContext getMailetContext();

    /**
     * Returns the name of this matcher instance. The name may be provided via server
     * administration, assigned in the application deployment descriptor, or for
     * an unregistered (and thus unnamed) matcher instance it will be the matcher's
     * class name.
     *
     * @return the name of the matcher instance
     */
    String getMatcherName();
}
