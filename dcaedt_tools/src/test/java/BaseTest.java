/*-
 * ============LICENSE_START=======================================================
 * SDC
 * ================================================================================
 * Copyright (C) 2019 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
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
 * ============LICENSE_END=========================================================
 */

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.onap.sdc.dcae.composition.restmodels.sdc.Resource;
import org.onap.sdc.dcae.composition.restmodels.sdc.ResourceDetailed;
import utilities.IDcaeRestClient;
import utilities.IReport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

abstract class BaseTest {
    static final String USER_ID = "userId";
    static final String TEMPLATE_INFO_NAME = "templateInfoName";
    static final String TEMPLATE_INFO_FLOWTYPE = "templateInfoFlowType";
    static final String VFCMT_NAME1 = "my vfcmt1";
    static final String UUID1 = "my uuid1";
    static final String VFCMT_NAME2 = "my vfcmt2";
    static final String UUID2 = "my uuid2";
    static final String VFCMT_NAME3 = "my vfcmt3";
    static final String UUID3 = "my uuid3";
    static final String ELEMENT_NAME1 = "my element1";
    static final String ELEMENT_NAME2 = "my element2";
    static final String ELEMENT_NAME3 = "my element3";
    static final String ALIAS_NAME1 = "my alias1";
    static final String ALIAS_NAME2 = "my alias2";
    static final String ALIAS_NAME3 = "my alias3";
    static final String ITEM_NAME1 = "my item1";
    static final String ITEM_NAME2 = "my item2";
    static final String ITEM_NAME3 = "my item3";

    @Mock
    IReport report;
    @Mock
    IDcaeRestClient dcaeRestClient;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockGetCatalog();
    }

    void mockCheckoutVfcmtAndCreateResource() {
        ResourceDetailed resourceDetailed = new ResourceDetailed();
        resourceDetailed.setName(VFCMT_NAME1);
        resourceDetailed.setUuid(UUID1);
        resourceDetailed.setLifecycleState("NOT_CERTIFIED_CHECKOUT");
        resourceDetailed.setLastUpdaterUserId(USER_ID);
        when(dcaeRestClient.createResource(any())).thenReturn(resourceDetailed);
    }

    void mockGetItemType() {
        when(dcaeRestClient.getItemType(any(), any())).thenReturn("{\"data\":{\"type\":{\"itemId\":\"e45ec9d7-01df-4cb1-896f-aff2a6ca5a8b/tosca.dcae.nodes.cdapApp.Map\", \"typeinfo\":\"typeInfo\"}}}");
    }

    void mockGetItemModel() {
        when(dcaeRestClient.getItemModel(any())).thenReturn("{\"data\":{\"model\":{\"itemId\":\"\",\"nodes\":[{\"capability\":{\"type\":\"someType\"}, \"type\":\"type\", \"name\":\"SomeNameFromRequirement\", \"requirements\":[{\"name\":\"SomeNameFromRequirement\"}], \"properties\":[{}], \"capabilities\":[{\"name\":\"SomeNameToCapability\"}],\"type\":\"type\"}]}}}",
                "{\"data\":{\"model\":{\"itemId\":\"\",\"nodes\":[{\"capability\":{\"type\":\"someType\"}, \"type\":\"type\", \"name\":\"SomeNameToCapability\", \"requirements\":[{\"name\":\"SomeNameFromRequirement\"}], \"properties\":[{}], \"capabilities\":[{\"name\":\"SomeNameToCapability\"}],\"type\":\"type\"}]}}}");
    }

	private void mockGetCatalog() {
		Map<String, List<Resource>> catalog = new HashMap<>();
		catalog.put(ELEMENT_NAME1, null);
		List<Resource> items = new ArrayList<>();
		Resource item = new Resource();
		item.setName(ITEM_NAME1);
		items.add(item);
		item = new Resource();
		item.setName(ITEM_NAME2);
		items.add(item);
		catalog.put(ELEMENT_NAME2, items);
		items = new ArrayList<>();
		item = new Resource();
		item.setName(ITEM_NAME3);
		items.add(item);
		catalog.put(ELEMENT_NAME3, items);
	}


    void mockGetAllVfcmt() {
        List<ResourceDetailed> resourceDetaileds = new ArrayList<>();
        ResourceDetailed resourceDetailed = new ResourceDetailed();
        resourceDetailed.setName(VFCMT_NAME1);
        resourceDetailed.setUuid(UUID1);
        resourceDetailed.setLifecycleState("NOT_CERTIFIED_CHECKOUT");
        resourceDetailed.setLastUpdaterUserId(USER_ID);
        resourceDetaileds.add(resourceDetailed);
        resourceDetailed = new ResourceDetailed();
        resourceDetailed.setName(VFCMT_NAME2);
        resourceDetailed.setUuid(UUID2);
        resourceDetaileds.add(resourceDetailed);
        resourceDetailed = new ResourceDetailed();
        resourceDetailed.setName(VFCMT_NAME3);
        resourceDetailed.setUuid(UUID3);
        resourceDetaileds.add(resourceDetailed);

        List<ResourceDetailed> resourceDetailed2 = new ArrayList<>();
        resourceDetailed = new ResourceDetailed();
        resourceDetailed.setName(VFCMT_NAME1);
        resourceDetailed.setUuid(UUID1);
        resourceDetailed.setLifecycleState("NOT_CERTIFIED_CHECKOUT");
        resourceDetailed.setLastUpdaterUserId(USER_ID);
        resourceDetailed2.add(resourceDetailed);
        resourceDetailed = new ResourceDetailed();
        resourceDetailed.setName(VFCMT_NAME2);
        resourceDetailed.setUuid(UUID2);
        resourceDetailed2.add(resourceDetailed);
        resourceDetailed = new ResourceDetailed();
        resourceDetailed.setName(VFCMT_NAME3);
        resourceDetailed.setUuid(UUID3);
        resourceDetailed2.add(resourceDetailed);
        resourceDetailed = new ResourceDetailed();
        resourceDetailed.setName(TEMPLATE_INFO_NAME);
        resourceDetailed.setUuid(UUID3);
        resourceDetailed2.add(resourceDetailed);
        when(dcaeRestClient.getAllVfcmts()).thenReturn(resourceDetaileds, resourceDetailed2);
        when(dcaeRestClient.getAllBaseVfcmts()).thenReturn(new ArrayList<>());
    }
}
