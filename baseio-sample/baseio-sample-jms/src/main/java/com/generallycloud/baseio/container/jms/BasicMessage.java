/*
 * Copyright 2015-2017 GenerallyCloud.com
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.generallycloud.baseio.container.jms;

public abstract class BasicMessage implements Message {

    private long   timestamp = System.currentTimeMillis();
    private String queueName;
    private String msgID;

    @Override
    public String getMsgID() {
        return msgID;
    }

    @Override
    public String getQueueName() {
        return queueName;
    }

    public BasicMessage(String msgID, String queueName) {
        this.msgID = msgID;
        this.queueName = queueName;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public abstract String toString();

}
