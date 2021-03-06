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

package json.response.ModelResponse;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Property {

    @SerializedName("assignment")
    private Assignment mAssignment;
    @SerializedName("format")
    private List<Format> mFormat;
    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;

    public Assignment getAssignment() {
        return mAssignment;
    }

    public void setAssignment(Assignment assignment) {
        mAssignment = assignment;
    }

    public List<Format> getFormat() {
        return mFormat;
    }

    public void setFormat(List<Format> format) {
        mFormat = format;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
