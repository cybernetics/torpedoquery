/**
 *   Copyright Xavier Jodoin xjodoin@torpedoquery.org
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.torpedoquery.jpa.internal.utils;

import org.torpedoquery.core.QueryBuilder;
import org.torpedoquery.jpa.internal.QueryConfigurator;
import org.torpedoquery.jpa.internal.conditions.ConditionBuilder;


public class WithQueryConfigurator<T> implements QueryConfigurator<T> {

	@Override
	public void configure(QueryBuilder<T> builder, ConditionBuilder<T> condition) {
		builder.setWithClause(condition);
	}

}
