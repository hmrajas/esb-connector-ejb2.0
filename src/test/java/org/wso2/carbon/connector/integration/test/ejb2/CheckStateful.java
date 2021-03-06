package org.wso2.carbon.connector.integration.test.ejb2;/*
/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import com.ejb2connector.stateful.Hello;
import com.ejb2connector.stateful.HelloHome;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class CheckStateful {

    /**
     * @param context context.
     * @return sum.
     * @throws RemoteException
     * @throws CreateException
     * @throws NamingException
     */
    public static int getFromStaeful(Context context) throws RemoteException, CreateException, NamingException {
        HelloHome home;
        home = (HelloHome) context.lookup("EJB2StatefulJboss");
        Hello bean;
        bean = home.create();
        // invoke on the remote counter bean
        final int NUM_TIMES = 5;
        for (int i = 0; i < NUM_TIMES; i++) {
            bean.increment();
        }
        return bean.getCount();
    }
}