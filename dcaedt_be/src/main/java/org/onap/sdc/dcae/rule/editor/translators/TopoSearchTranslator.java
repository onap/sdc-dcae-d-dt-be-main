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

package org.onap.sdc.dcae.rule.editor.translators;

import org.onap.sdc.dcae.composition.restmodels.ruleeditor.Condition;
import org.onap.sdc.dcae.composition.restmodels.ruleeditor.TopoSearchAction;
import org.onap.sdc.dcae.rule.editor.enums.OperatorTypeEnum;
import org.onap.sdc.dcae.rule.editor.enums.RuleEditorElementType;
import org.onap.sdc.dcae.rule.editor.utils.ValidationUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TopoSearchTranslator extends ActionTranslator<TopoSearchAction> {

	private static TopoSearchTranslator topoSearchTranslator = new TopoSearchTranslator();

	public static TopoSearchTranslator getInstance() {
		return topoSearchTranslator;
	}

	private TopoSearchTranslator() {
	}

	private class TopoSearchTranslation extends ProcessorTranslation {
		private String searchField;
		private String searchValue;
		private Object searchFilter;
		private Map <String, Object> updates;
		private List<String> enrichFields;
		private String enrichPrefix;

		private TopoSearchTranslation(TopoSearchAction action) {
			clazz = "TopoSearch";
			searchField = action.searchField();
			searchValue = action.searchValue();
			// fix - check that the condition is not only declared but also defined
			if(action.conditionalSearch() && ValidationUtils.validateNotEmpty(action.searchFilter().getLeft())) {
				searchFilter = getSimpleConditionTranslation(action.searchFilter());
			}
			if(action.doEnrich()){
				enrichFields = action.enrichFields();
				enrichPrefix = action.enrichPrefix();
			} else {
				updates = new LinkedHashMap<>();
				updates.putAll(action.updatesMap());
				updates.put("isEnriched", true);
			}
		}
	}

	private Object getSimpleConditionTranslation(Condition condition) {
		String conditionType = OperatorTypeEnum.getTypeByName(condition.getOperator()).getConditionType();
		IRuleElementTranslator<Condition> translator = RuleEditorElementType.getElementTypeByName(conditionType).getTranslator();
		return translator.translateToHpJson(condition);
	}


	public Object translateToHpJson(TopoSearchAction action) {
		return new TopoSearchTranslation(action);
	}

}
