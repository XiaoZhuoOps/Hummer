package com.xiaozhuo.hummer.beans.config;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaozhuo 2021/10/3 15:27
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addProperty(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(name)) {
                return pv;
            }
        }
        return null;
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}
