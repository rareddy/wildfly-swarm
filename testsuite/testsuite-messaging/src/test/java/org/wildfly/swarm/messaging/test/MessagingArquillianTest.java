/**
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wildfly.swarm.messaging.test;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.naming.InitialContext;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import static org.junit.Assert.assertNotNull;

/**
 * @author Bob McWhirter
 */
@RunWith(Arquillian.class)
@DefaultDeployment
public class MessagingArquillianTest {

    @ArquillianResource
    InitialContext context;

    @Test
    public void testDefaultConnectionFactory() throws Exception {
        ConnectionFactory factory = (ConnectionFactory) context.lookup("java:jboss/DefaultJMSConnectionFactory");
        assertNotNull(factory);
    }

    @Test
    public void testQueue() throws Exception {
        Queue queue = (Queue) context.lookup("java:/jms/queue/my-queue");
        assertNotNull(queue);
    }

    @Test
    public void testTopic() throws Exception {
        Topic topic = (Topic) context.lookup("java:/jms/topic/my-topic");
        assertNotNull(topic);
    }


}
