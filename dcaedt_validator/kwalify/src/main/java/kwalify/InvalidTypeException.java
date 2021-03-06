/*-
 * ============LICENSE_START=======================================================
 * SDC
 * ================================================================================
 * @(#)InvalidTypeException.java	$Rev: 4 $ $Release: 0.5.1 $
 * copyright(c) 2005 kuwata-lab all rights reserved.
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


package kwalify;

/**
 * exception class thrown by Util.compareValues() when comparing different type values.
 * 
 * @revision    $Rev: 4 $
 * @release     $Release: 0.5.1 $
 */
public class InvalidTypeException extends KwalifyRuntimeException {
    private static final long serialVersionUID = -6937887618526171845L;

    public InvalidTypeException(String message) {
        super(message);
    }
}
