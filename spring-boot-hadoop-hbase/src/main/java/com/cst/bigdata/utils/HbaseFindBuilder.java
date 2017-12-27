package com.cst.bigdata.utils;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * @author Johnney.chiu
 * create on 2017/11/23 15:35
 * @Description 按qualifier返回结果
 */
public class HbaseFindBuilder<T> {
    private String family;

    private Result result;

    private String qualifier;

    private Map<String, PropertyDescriptor> fieldsMap;

    private Set<String> propertiesSet;

    private Set<String> qualifierSet;

    private BeanWrapper beanWrapper;

    private T tBean;

    /**
     * 按family查询
     * @param family
     * @param result
     * @param tclazz
     */
    public HbaseFindBuilder(String family, Result result, Class<T> tclazz) {

        this.family = family;
        this.result = result;
        fieldsMap = new HashMap();
        propertiesSet = new HashSet<>();

        reflectBean(tclazz);

    }
    /**
     * return the result by qulifier
     * @param qualifier
     * @return
     */
    public HbaseFindBuilder build(String qualifier) {
        return this.build(qualifier,"");
    }

    /**
     * by multiple qualifier
     * @param qualifiers
     * @return
     */
    public HbaseFindBuilder build(String... qualifiers) {
        if (qualifiers == null || qualifiers.length == 0) {
            return this;
        }
        Arrays.stream(qualifiers).filter(q->!StringUtils.isEmpty(q))
                .forEach(q->{
                    PropertyDescriptor p  = fieldsMap.get(q.trim());
                    byte[] qualifierByte=result.getValue(family.getBytes(), HumpNameOrMethodUtils.humpEntityForVar(q.trim()).getBytes());
                    if (qualifierByte != null && qualifierByte.length > 0) {
                        beanWrapper.setPropertyValue(p.getName(), Bytes.toString(qualifierByte));
                        propertiesSet.add(p.getName());
                    }
                });
        return this;
    }
    /**
     * by map
     * @param map
     * @return
     */
    public HbaseFindBuilder build(Map<String,String> map) {
        if (map == null || map.size() <= 0) {
            return this;
        }
        map.values().stream().filter(v->!StringUtils.isEmpty(v))
                .forEach(v->{
                    PropertyDescriptor p=fieldsMap.get(v.trim());
                    byte[] qualifierByte = result.getValue(family.getBytes(), HumpNameOrMethodUtils.humpEntityForVar(v).getBytes());
                    if (qualifierByte != null && qualifierByte.length > 0) {
                        beanWrapper.setPropertyValue(p.getName(), Bytes.toString(qualifierByte));
                        propertiesSet.add(p.getName());
                    }
                });

        return this;
    }

    private void reflectBean(Class<T> tclazz) {
        tBean = BeanUtils.instantiate(tclazz);
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(tclazz);
        Arrays.stream(propertyDescriptors).filter(p->p.getWriteMethod() != null)
                .forEach(p->this.fieldsMap.put(p.getName(), p));
        beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(tBean);
    }

    public T fetch() {
        if (!CollectionUtils.isEmpty(propertiesSet)) {
            return this.tBean;
        }
        return null;
    }

}
