package com.alibaba.cloud.sentinel.feign;

import feign.Contract;
import feign.MethodMetadata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SentinelContractHolder
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/9 17:01
 */
public class SentinelContractHolder implements Contract {

    private final Contract delegate;

    /**
     * map key is constructed by ClassFullName + configKey. configKey is constructed by
     * {@link feign.Feign#configKey}
     */
    public final static Map<String, MethodMetadata> METADATA_MAP = new HashMap<>();

    public SentinelContractHolder(Contract delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<MethodMetadata> parseAndValidateMetadata(Class<?> targetType) {
        List<MethodMetadata> metadatas = delegate.parseAndValidateMetadata(targetType);
        metadatas.forEach(metadata -> METADATA_MAP
                .put(targetType.getName() + metadata.configKey(), metadata));
        return metadatas;
    }
}
