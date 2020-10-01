package com.orion.cloud.order.feign.fee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.SystemPropertyUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @date 2020/9/29
 */
@Slf4j
public class ScanSupport implements ResourceLoaderAware{

        private static ScanSupport self = new ScanSupport();
        /**
         * Spring容器注入
         */
        private ResourceLoader resourceLoader;
        private ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        private MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);

        /**
         * 利用spring提供的扫描包下面的类信息,再通过classfrom反射获得类信息
         */
        public static Set<Class<?>> doScan(String scanPath) {
            try {
                Set<Class<?>> classes = new HashSet<Class<?>>();
                String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                        .concat(ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(scanPath))
                                .concat("/**/*.class"));
                Resource[] resources = self.resolver.getResources(packageSearchPath);
                MetadataReader metadataReader = null;
                for (Resource resource : resources) {
                    if (resource.isReadable()) {
                        metadataReader = self.metadataReaderFactory.getMetadataReader(resource);
                        try {
                            // 当类型不是抽象类或接口在添加到集合
                            if (metadataReader.getClassMetadata().isConcrete()) {
                                classes.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
                            }
                        } catch (Exception e) {
                            log.error("扫描包 [{}] 失败!!!", scanPath, e);
                        }
                    }
                }
                return classes;
            } catch (IOException e) {
                log.error("扫描包 [{}] 失败!!!", scanPath, e);
            }
            return Collections.emptySet();
        }

        /**
         * set注入对象
         */
        @Override
        public void setResourceLoader(ResourceLoader resourceLoader) {
            this.resourceLoader = resourceLoader;
        }

    }
